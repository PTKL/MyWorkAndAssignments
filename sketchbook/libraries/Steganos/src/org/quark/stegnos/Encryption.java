/*
 * Copyright (c) 2015 Peter Lager
 * <quark(a)lagers.org.uk> http:www.lagers.org.uk
 * 
 * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from
 * the use of this software.
 * 
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it freely,
 * subject to the following restrictions:
 * 
 * 1. The origin of this software must not be misrepresented;
 * you must not claim that you wrote the original software.
 * If you use this software in a product, an acknowledgment in the product
 * documentation would be appreciated but is not required.
 * 
 * 2. Altered source versions must be plainly marked as such,
 * and must not be misrepresented as being the original software.
 * 
 * 3. This notice may not be removed or altered from any source distribution.
 */

package org.quark.stegnos;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import processing.core.PImage;

/**
 * This class provides a number of methods used internally by the library to 
 * encrypt / decrypt images and text. The image methods are the only ones 
 * made public to the library user. 
 * 
 * @author Peter Lager
 *
 */
public class Encryption implements SteganosConstants {


	/**
	 * Encode the image.
	 * 
	 * @param passphrase the pass phrase used to encrypt the image
	 * @param img the image to encrypt
	 * @param format either ARGB or RGB
	 */
	public static void encodeImage(String passphrase, PImage img, int format){
		encodeImage(passphrase, img, format, 8);
	}
	
	/**
	 * Decode the image. <br>
	 * The passphrase and format must match the ones used to encrypt the
	 * image originally.
	 * 
	 * @param passphrase the pass phrase used to decrypt the image
	 * @param img the image to encrypt
	 * @param format either ARGB or RGB
	 */
	public static void decodeImage(String passphrase, PImage img, int format){
		decodeImage(passphrase, img, format, 8);
	}
	
	/**
	 * Encode the image to hide.
	 * 
	 * @param passphrase the pass-phrase or password
	 * @param img the image to encode
	 * @param format image format either RGB or ARGB
	 * @param nbcKeep the number of bits per channel being kept
	 */
	static void encodeImage(String passphrase, PImage img, int format, int nbcKeep){
		if(passphrase == null || passphrase.length() == 0)
			return;
		img.loadPixels();
		int[] d = img.pixels;
		int hash = passphrase.hashCode() & 0x00ffffff;
		if(format == RGB)
			encodeRGB(passphrase, d, hash, nbcKeep);
		else 
			encodeARGB(passphrase, d, hash, nbcKeep);
		img.updatePixels();
	}

	/**
	 * Decode the retrieved image.
	 * 
	 * @param passphrase the pass-phrase or password
	 * @param img the image to encode
	 * @param format image format either RGB or ARGB
	 * @param nbcKeep the number of bits per channel being kept
	 */
	static void decodeImage(String passphrase, PImage img, int format, int nbcKeep){
		if(passphrase == null || passphrase.length() == 0)
			return;
		img.loadPixels();
		int[] d = img.pixels;
		int hash = passphrase.hashCode() & 0x00ffffff;
		if(format == RGB)
			decodeRGB(passphrase, d, hash, nbcKeep);
		else 
			decodeARGB(passphrase, d, hash, nbcKeep);
		img.updatePixels();
	}

	/**
	 * Encode the text to hide.
	 * @param passphrase the pass-phrase or password
	 * @param d UTF-8 characters in an int array
	 */
	static void encodeText(String passphrase, int[] d){
		if(passphrase == null || passphrase.length() == 0)
			return;
		int[] rotKeys = getRotKeys(passphrase, 1, 32);
		int[] hashKeys = getHashKeys(passphrase);
		int k = 0, h = 0;
		for(int i = 0; i < d.length; i++){
			d[i] ^= hashKeys[h++];
			d[i] = rotInteger(d[i], rotKeys[k++]);
			k %= rotKeys.length;
			h %= hashKeys.length;
		}
	}

	/**
	 * Decode the text retrieved from the image.
	 * 
	 * @param passphrase the pass-phrase or password
	 * @param d UTF-8 characters in an int array
	 */
	static void decodeText(String passphrase, int[] d){
		if(passphrase == null || passphrase.length() == 0)
			return;
		int[] rotKeys = getRotKeys(passphrase, 1, 32);
		int[] hashKeys = getHashKeys(passphrase);
		int k = 0, h = 0;
		for(int i = 0; i < d.length; i++){
			d[i] = rotInteger(d[i], 32 - rotKeys[k++]);
			d[i] ^= hashKeys[h++];
			k %= rotKeys.length;
			h %= hashKeys.length;
		}
	}

	/**
	 * Encode the RGB image data in the burden.
	 * 
	 * @param passphrase the pass-phrase or password
	 * @param d pixel data
	 * @param hash has for password
	 * @param nbcKeep the number of bits/channel to keep from the burden
	 */
	private static void encodeRGB(String passphrase, int[] d,  int hash, int nbcKeep){
		int[] rotKeys = getRotKeys(passphrase, 1, 3 * nbcKeep);
		int[] hashKeys = getHashKeys(passphrase);
		int k = 0, h = 0;
		for(int i = 0; i < d.length; i++){
			d[i] = mergeRGB(d[i]);
			d[i] = rotColorData(d[i], 3, nbcKeep, rotKeys[k++]);
			d[i] ^= hashKeys[h++];
			k %= rotKeys.length;
			h %= hashKeys.length;
		}
	}

	/**
	 * Decode the RGB image data retrieved.
	 * 
	 * @param passphrase the pass-phrase or password
	 * @param d pixel data
	 * @param hash has for password
	 * @param nbcKeep the number of bits/channel to keep from the burden
	 */
	private static void decodeRGB(String passphrase, int[] d, int hash, int nbcKeep){
		int[] rotKeys = getRotKeys(passphrase, 1, 3 * nbcKeep);
		int[] hashKeys = getHashKeys(passphrase);
		int k = 0, h = 0, rgbKeep = 3 * nbcKeep;
		for(int i = 0; i < d.length; i++){
			d[i] ^= hashKeys[h++];
			d[i] = rotColorData(d[i], 3, nbcKeep, rgbKeep - rotKeys[k++]);
			d[i] = splitRGB(d[i]);
			k %= rotKeys.length;
			h %= hashKeys.length;
		}
	}

	/**
	 * Encode the ARGB image data in the burden.
	 * 
	 * @param passphrase the pass-phrase or password
	 * @param d pixel data
	 * @param hash has for password
	 * @param nbcKeep the number of bits/channel to keep from the burden
	 */
	private static void encodeARGB(String passphrase, int[] d, int hash, int nbcKeep){
		int[] keys = getRotKeys(passphrase, 1, 4 * nbcKeep);
		int[] hashKeys = getHashKeys(passphrase);
		int k = 0, h = 0;
		for(int i = 0; i < d.length; i++){
			d[i] = mergeARGB(d[i]);
			d[i] = rotColorData(d[i], 4, nbcKeep, keys[k++]);
			d[i] ^= hashKeys[h++];
			k %= keys.length;
			h %= hashKeys.length;
		}
	}
		
	/**
	 * Decode the ARGB image data retrieved.
	 * 
	 * @param passphrase the pass-phrase or password
	 * @param d pixel data
	 * @param hash has for password
	 * @param nbcKeep the number of bits/channel to keep from the burden
	 */
	private static void decodeARGB(String passphrase, int[] d, int hash, int nbcKeep){
		int[] keys = getRotKeys(passphrase, 1, 4 * nbcKeep);
		int[] hashKeys = getHashKeys(passphrase);
		int k = 0, h = 0, rgbKeep = 4 * nbcKeep;
		for(int i = 0; i < d.length; i++){
			d[i] ^= hashKeys[h++];
			d[i] = rotColorData(d[i], 4, nbcKeep, rgbKeep - keys[k++]);
			d[i] = splitARGB(d[i]);
			k %= keys.length;
			h %= hashKeys.length;
		}
	}
	

	/**
	 * (1) Creates a byte array of password in UTF-8 format <br>
	 * (2) Uses a one-way encryption algorithm to produce a hash value array.<br>
	 * (3) From has creates an array used to rotate the bits in the image. <br>
	 * Acceptable algorithms are MD5 (16 bytes), SHA-1 (21 bytes) and SHA-256 (32 bytes)<br>
	 * Produces an array where all elements are in the range >=minRot
	 * and <= maxRot
	 * @param s
	 * @param minRot the minimum bit rotation 
	 * @param maxRot the maximum bit rotation 
	 */
	private static int[] getRotKeys(String s,  int minRot, int maxRot){
		String algorithm = "SHA-256";
		int diff = --maxRot - minRot;
		byte[] input = new byte[0];
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.reset();
			input = digest.digest(s.getBytes("UTF-8"));
		} 
		catch (NoSuchAlgorithmException e) {
			System.out.println("Unable to find " + algorithm + " hashing algorithm");
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Unable to convert String to UTF-8");
		}
		// Convert result into array used when rotating bits
		int[] k = new int[input.length];
		for(int i = 0; i < k.length; i++){
			k[i] = (input[i] & 0xff);
			k[i] = (k[i] % diff) + minRot;
		}
		return k;
	}

	/**
	 * Create an array of 17 integers that can be used for hash values. <br>
	 * 
	 * Acceptable algorithms are MD5 (16 bytes), SHA-1 (21 bytes) and SHA-256 (32 bytes)<br>
	 * Produces an array where all elements are in the range >=minRot
	 * and <= maxRot
	 * @param s
	 */
	private static int[] getHashKeys(String s){
		String algorithm = "SHA-1";
		int[] k = new int[17];
		byte[] input = new byte[0];
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.reset();
			input = digest.digest(s.getBytes("UTF-8"));
		} 
		catch (NoSuchAlgorithmException e) {
			System.out.println("Unable to find " + algorithm + " hashing algorithm");
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Unable to convert String to UTF-8");
		}
		// Convert result into array used when XORing bits
		for(int i = 0; i < k.length; i++){
			k[i] = (input[i] & 0xff) << 24;
			k[i] |= (input[i+1] & 0xff) << 16;
			k[i] |= (input[i+2] & 0xff) << 8;
			k[i] |= (input[i+3] & 0xff);
		}
		return k;
	}

	/**
	 * Merge the bits of an ARGB image from
	 * MSB to LSB ignoring the alpha channel
	 * e.g. rgbrgbrgb...
	 * 
	 * @param argb the ARGB value to merge
	 * @return the RGBX merged value
	 */
	private static int mergeRGB(int argb){
		int r = (argb >> 16) &  0xff;
		int g = (argb >> 8) &  0xff;
		int b = argb &  0xff;
		int n = 8;
		int rgb = 0;
		while(n-- > 0){
			rgb <<= 1;
			rgb |= ((r & 0x80) >>> 7);
			rgb <<= 1;
			rgb |= ((g & 0x80) >>> 7);
			rgb <<= 1;
			rgb |= ((b & 0x80) >>> 7);
			r <<= 1;
			g <<= 1;
			b <<= 1;
		}
		rgb <<= 8;
		return rgb;
	}

	/**
	 * Merge the bits of an ARGB image from
	 * MSB to LSB e.g. argbargbargb...
	 * 
	 * @param argb the ARGB value to merge
	 * @return the ARGB merged value
	 */
	private static int mergeARGB(int argb){
		int a = (argb >> 24) &  0xff;
		int r = (argb >> 16) &  0xff;
		int g = (argb >> 8) &  0xff;
		int b = argb &  0xff;
		int n = 8;
		argb = 0;
		while(n-- > 0){
			argb <<= 1;
			argb |= ((a & 0x80) >>> 7);
			argb <<= 1;
			argb |= ((r & 0x80) >>> 7);
			argb <<= 1;
			argb |= ((g & 0x80) >> 7);
			argb <<= 1;
			argb |= ((b & 0x80) >>> 7);
			a <<= 1;
			r <<= 1;
			g <<= 1;
			b <<= 1;
		}
		return argb;
	}

	/**
	 * Split a merged ARGB value.
	 * @param argb the merged value in ARGB order
	 * @return the un-merged value in the format ARGB
	 */
	private static int splitARGB(int argb){
		int a = 0, r = 0, g = 0, b = 0;
		int n = 8;
		while(n-- > 0){
			a <<= 1;
			r <<= 1;
			g <<= 1;
			b <<= 1;
			a |= ((argb & 0x80000000) >>> 31);
			argb <<= 1;
			r |= ((argb & 0x80000000) >>> 31);
			argb <<= 1;
			g |= ((argb & 0x80000000) >>> 31);
			argb <<= 1;
			b |= ((argb & 0x80000000) >>> 31);
			argb <<= 1;
		}
		argb = (a << 24) | (r << 16) | (g << 8) | b;
		return argb;
	}

	/**
	 * Split a merged RGB value. Note the 8 LSBits are unused.
	 * 
	 * @param rgb the merged value in RGBX order
	 * @return the un-merged value in the format ARGB
	 */
	private static int splitRGB(int rgb){
		int r = 0, g = 0, b = 0;
		int n = 8;
		while(n-- > 0){
			r <<= 1;
			g <<= 1;
			b <<= 1;
			r |= ((rgb & 0x80000000) >>> 31);
			rgb <<= 1;
			g |= ((rgb & 0x80000000) >>> 31);
			rgb <<= 1;
			b |= ((rgb & 0x80000000) >>> 31);
			rgb <<= 1;
		}
		rgb = 0xff000000 | (r << 16) | (g << 8) | b;
		return rgb;
	}


	/**
	 * Rotate merged ARGB/RGB so as to maintain MSB clear all unused LSBits
	 * 
	 * @param argb
	 * @param nbrChannels 3 for RGB and 4 for ARGB
	 * @param bitsKept number of bits/channel kept (1-7 incl)
	 * @param bitsRotate number of bits to rotate
	 * @param left if true rotate left else rotate right
	 * @return the rotated number
	 */
	private static int rotColorData(int argb, int nbrChannels, int bitsKept, int bitsRotate){
		int mask = nbrChannels == 3 ? RGB_MERGED_BITS[bitsKept] : ARGB_MERGED_BITS[bitsKept];
		// Clear out LSBits
		argb &= mask;
		int msb = argb >>> (32 - bitsRotate);
		msb <<= (32 - nbrChannels * bitsKept);
		int lsb = argb << bitsRotate;
		argb = msb | lsb;
		return argb;
	}

	/**
	 * Rotate all 32 bits of the integer. This method is called when encoding 
	 * and decoding text.
	 * 
	 * @param value the value to rotate 
	 * @param bitsRotate number of bits to rotate by
	 * @return the rotated value
	 */
	private static int rotInteger(int value, int bitsRotate){
		int msb = value << bitsRotate;
		int lsb = value >>> (32 - bitsRotate);
		// Clear out LSBits
		value = msb | lsb;
		return value;
	}

}
