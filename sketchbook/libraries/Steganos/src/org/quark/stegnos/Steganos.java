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

import processing.core.PImage;

/**
 * This class provides the main user API for this library and
 * provides methods to <br>
 * 
 * In this documentation I use the term 'stegan' to represent 
 * any image with a hidden burden. <br>
 * <ul>
 * <li>embed an image into a carrier image </li>
 * <li>embed text into a carrier image </li>
 * <li>extract an image from a stegan </li>
 * <li>extract text from a stegan </li>
 * <li>analyze an image<>image combination for a stegan </li>
 * <li>analyze an image<>text combination for a stegan </li>
 * </ul>
 *
 * @author Peter Lager
 *
 */
public final class Steganos implements  SteganosConstants {

	// Current version to use in creating steganographs 
	private static int CURRENT_VERSION = 0;

	/**
	 * Given a stegan get the version number used to create it. At present
	 * there is only one steganography version so will return 0. <br>
	 * If the image is not a steganograph the returned value has no significance.
	 * 
	 * 
	 * @param stegno the stegan
	 * @return the version number
	 */
	public static int getVersion(PImage stegno){
		stegno.loadPixels();
		return stegno.pixels[0] & 0x7;
	}

	/**
	 * Assuming that the image is in fact a stegan get the type of burden
	 * embedded. <br>
	 * If the image is not a steganograph the returned value has no significance. <br>
	 * At present only text and images can be embedded so the value returned will be 
	 * either Steganos.TEXT_BURDEN or Steganos.IMAGE_BURDEN
	 * 
	 * @param stegno the stegan
	 * @return the burden type
	 */
	public static int getBurdenType(PImage stegno){
		stegno.loadPixels();
		return (stegno.pixels[0] >>> 8) & 0x3;
	}


	/**
	 * Merge the burden image into the carrier image to create a stegan. <br>
	 * If a password is not supplied the burden will be stored un-encrypted.
	 * 
	 * @param pphrase password / pass-phrase
	 * @param carrier the carrier image with embedded burden (stegan)
	 * @param burden the text to insert
	 * @return the stegan
	 */
	public static PImage embedImage(String pphrase, PImage carrier, PImage burden) {
		switch (CURRENT_VERSION){
		case 0:
			Steganograph steg = new Steganograph_v0();
			return steg.embedImageInStegan(pphrase, carrier, burden);
		}
		return null;
	}

	/**
	 * Extract the image from the stegan.
	 * If a password is not supplied it is assumed that the burden is un-encrypted.
	 * 
	 * @param pphrase password / pass-phrase
	 * @param stegan the carrier image with embedded burden (stegan)
	 * @return null if unable to retrieve the image
	 */
	public static PImage extractImage(String pphrase, PImage stegan) {
		switch (CURRENT_VERSION){
		case 0:
			Steganograph steg = new Steganograph_v0();
			return steg.extractImageFromStegan(pphrase, stegan);
		}

		return null;
	}

	/**
	 * Create a merge the text into the carrier image to make a stegan.
	 * If a password is not supplied the burden will be stored un-encrypted.
	 * 
	 * @param pphrase password / pass-phrase
	 * @param carrier the impregnated image (stegan)
	 * @param burden the text to insert
	 * @return the stegan
	 */
	public static PImage embedText(String pphrase, PImage carrier, String burden) {
		switch (CURRENT_VERSION){
		case 0:
			Steganograph steg = new Steganograph_v0();
			return steg.embedTextInStegan(pphrase, carrier, burden);
		}
		return null;
	}

	/**
	 * Extract the text from the stegan.
	 * If a password is not supplied it is assumed that the burden is un-encrypted.
	 * 
	 * @param pphrase password / pass-phrase
	 * @param stegan the impregnated image (stegan)
	 * @return null if unable to retrieve text
	 */
	public static String extractText(String pphrase, PImage stegan) {
		switch (CURRENT_VERSION){
		case 0:
			Steganograph steg = new Steganograph_v0();
			return steg.extractTextFromStegan(pphrase, stegan);
		}
		return null;
	}

	/**
	 * Analyze a possible image-image combination and confirm that it is
	 * a usable combination.
	 * 
	 * @param carrier proposed carrier image
	 * @param burden proposed burden image
	 * @return an analysis of this potential combination
	 */
	public static Analysis analyze(PImage carrier, PImage burden) {
		Steganograph steg = new Steganograph_v0();
		return steg.analysis(carrier, burden);
	}

	/**
	 * Analyze a possible image-text combination and confirm that it is
	 * a usable combination.
	 * 
	 * @param carrier proposed carrier image
	 * @param burden proposed burden text
	 * @return an analysis of this potential combination
	 */
	public static Analysis analyze(PImage carrier, String burden) {
		Steganograph steg = new Steganograph_v0();
		return steg.analysis(carrier, burden);
	}

}
