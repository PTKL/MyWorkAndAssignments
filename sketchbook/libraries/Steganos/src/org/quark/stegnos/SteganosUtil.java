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

import processing.core.PImage;

/**
 * Provides a range of utility methods for this library.
 * 
 * @author Peter Lager
 *
 */
final class SteganosUtil {

	/**
	 * Detect whether an image has transparent pixels ie.e Alpha != 0xFF
	 */
	public static boolean hasAlpha(PImage img) {
		img.loadPixels();
		int[] pixels = img.pixels;
		for (int i = 1; i < pixels.length; i++) {
			if ((pixels[i] & 0xff000000) != 0xff000000)
				return true;
		}
		return false;
	}

	/**
	 * Convert a String burden to UTF-8 byte array
	 */
	public static byte[] getUTF8array(String burden){
		try {
			return burden.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unable to covert text to UTF-8");
		}
		return new byte[0];
	}

	/**
	 * Create an integer array from a byte array. <br>
	 * This will pack an array of bytes into an array of integers. It is used 
	 * to prepare text for inserting into the carrier image.
	 */
	public static int[] convertByteToIntArray(byte[] bytes, int nbrBytes){
		// Get the string as UTF-8
		if(nbrBytes % 4 != 0){
			byte[] temp = new byte[4 * (nbrBytes/4 + 1)];
			System.arraycopy(bytes, 0, temp, 0, nbrBytes);
			bytes = temp;
		}
		// Convert to int array for bit buffer
		int[] d = new int[bytes.length/4];
		for(int idx = 0; idx < d.length; idx++){
			int p = 4*idx;
			d[idx] = (bytes[p]) << 24;
			d[idx] |= (bytes[p+1]) << 16;
			d[idx] |= (bytes[p+2]) << 8;
			d[idx] |= (bytes[p+3]);
		}
		return d;
	}

	/**
	 * Create a byte array from an integer array. Used when retrieving 
	 * text from a stegan. <br>
	 * 
	 * An integer array is created when first retrieving a text burden. 
	 * This method can be used to unpack the bytes into a byte array
	 */
	public static byte[] convertIntToByteArray(int[] data, int nbrBytes){
		// Get the string as UTF-8
		byte[] d = new byte[data.length * 4];
		// Convert to int array for bit buffer
		for(int idx = 0; idx < data.length; idx++){
			int p = 4*idx;
			d[p]   = (byte)((data[idx]  >>> 24) & 0xff);
			d[p+1] = (byte)((data[idx]  >>> 16) & 0xff);
			d[p+2] = (byte)((data[idx]  >>>  8) & 0xff);
			d[p+3] = (byte)(data[idx] & 0xff);
		}
		return d;
	}

	public static String binary(int n){
		String b = "";
		for(int i = 31; i >= 0; i--){
			b += (n & (1 << i)) != 0 ? "1" : "0";
			if(i%8 == 0) b += " ";
		}
		return b;
	}

	public static String binary(long n){
		String b = "";
		for(int i = 63; i >= 0; i--){
			b += (n & (1 << i)) != 0 ? "1" : "0";
			if(i%8 == 0) b += " ";
		}
		return b;
	}
	
	public static void printImage(String text, PImage img){
		img.loadPixels();
		int[] n = img.pixels;
		System.out.print(text + "\n");
		for(int p = 0 ; p < n.length; p++){
			System.out.println(binary(n[p]));
		}
	}
	
	public static void printImage(String text, int[] n){
		System.out.print(text + "\n");
		for(int p = 0 ; p < n.length; p++){
			System.out.println(binary(n[p]));
		}
	}
	
	public static void print(String text, int n){
		System.out.print(text + "\t\t");
		for(int i = 31; i >= 0; i--){
			String b = (n & (1 << i)) != 0 ? "1" : "0";
			System.out.print(b);
			if(i%8 == 0) System.out.print(" ");
		}
		System.out.println();
	}

	public static void print(String text, long n){
		System.out.print(text + "\t\t");
		for(int i = 63; i >= 0; i--){
			String b = (n & (1L << i)) != 0 ? "1" : "0";
			System.out.print(b);
			if(i%8 == 0) System.out.print(" ");
		}
		System.out.println();
	}


}
