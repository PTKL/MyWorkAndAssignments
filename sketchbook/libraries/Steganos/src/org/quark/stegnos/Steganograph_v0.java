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


import processing.core.PConstants;
import processing.core.PImage;

/**
 * This class provides methods to merge and to extract images
 * or text from a carrier image.
 *
 * @author Peter Lager
 *
 */
final class Steganograph_v0 extends Steganograph  {

	private static boolean SHOW_INFO = false;
	
	// The number of carrier pixels needed 
	private static int NBR_HEADERS = 3;

	// 			Information in header		   Byte		Bit position(s)
	private int version = 0;				// 0		0-2
	private int burdenType;					// 0		8 & 9
	private int carrierFormat;				// 1		8 & 9
	private int carrierBPCkept;				// 1		0-2 	(3 bits give 0-7 no adjustment since 8 is not possible)
	private int burdenFormat;				// 2		8 & 9
	private int burdenBPCkept;				// 2		0-2		(3 bits give 0-7 need to add 1 to get 1-8 : only required for image burdens)

	private int[] headerMask = new int[NBR_HEADERS];
	private int[] header = new int[NBR_HEADERS];
			
	private int burdenDataSize;
	private int nbrBurdenBytes;
	private int nbrBurdenBits;
	private int burdenDataMask;
	private int[] bdata = new int[0];
	// If burden is an image
	private int burdenWidth;
	private int burdenHeight;
	
	private int carrierBPCuse;
	private float carrierBytesAvailable;
	private int carrierMask;
	private int carrierWidth;
	private int carrierHeight;

	private int[] metaData;
	private int metaDataMask;
	private int metaDataBits;
	
	private BitBuffer bitBuffer;

	private PImage cimage, bimage;
	
	
	/**
	 * Private constructor to prevent unwanted instantiations
	 */
	Steganograph_v0(){
	}
	
	/**
	 * Merge the burden image into the carrier image to create a stegan.
	 * 
	 * @param pphrase password / pass-phrase
	 * @param stegan the impregnated image (stegan)
	 * @param bImage the text to insert
	 * @return the stegan
	 */
	PImage embedImageInStegan(String pphrase, PImage cImage, PImage bImage) {
		// Make copies of the original data
		cimage = cImage.get();
		bimage = bImage.get();

		burdenType = IMAGE_BURDEN;
		burdenFormat = SteganosUtil.hasAlpha(bimage) ? ARGB : RGB;
		carrierFormat = SteganosUtil.hasAlpha(cimage) ? ARGB : RGB;;
		
		// Number of bytes available in the carrier image
		// note: 4 are required for the header 
		carrierBytesAvailable = cimage.width * cimage.height * (carrierFormat == ARGB ? 4 : 3) - 4 * NBR_HEADERS;

		// Create metadata
		metaData = new int[] { bimage.width, bimage.height };
		metaDataMask = 0x0000ffff;
		metaDataBits = 32;

		// Calculate the recommended number of burden bits to save
		nbrBurdenBytes = bimage.width * bimage.height * (burdenFormat == ARGB ? 4 : 3);
		burdenBPCkept = -1;
		carrierBPCuse = -1;
		for(int nb = 1; nb <= 8; nb++){
			int ncbits = (int) Math.ceil((metaDataBits + nbrBurdenBytes * nb) / carrierBytesAvailable);
			if(ncbits <= 4){
				burdenBPCkept = nb;
				carrierBPCuse = ncbits;
				carrierBPCkept = 8 - ncbits;
			}
		}

		// get the nbr bites per channel to use to store burden 
		if(burdenBPCkept <= 0){
			System.out.println("The carrier image is too small to use");
			return null;
		}
		// Create the header and header mask
		packHeaders(header, headerMask);

		// This mask is used to clear the carrier bits used for storing the burden
		carrierMask = carrierFormat == RGB ? ~CARRIER3_BITS[carrierBPCuse] : ~CARRIER4_BITS[carrierBPCuse];
		
		// Encrpyt the burden image
		Encryption.encodeImage(pphrase, bimage, burdenFormat, burdenBPCkept);

		//	The extract from steg mask for the burden	
		burdenDataMask = burdenFormat == RGB ? RGB_MERGED_BITS[burdenBPCkept] : ARGB_MERGED_BITS[burdenBPCkept];
		
		if(SHOW_INFO)
			show("IMAGE MERGE");

		// Create the BitBuffer
		bimage.loadPixels();
		bitBuffer = new BitBuffer(bimage.pixels, burdenDataMask, metaData, metaDataMask);

		// Merge the carrier and encrypted image
		cimage.loadPixels();
		int[] data = cimage.pixels;
		// Embed header
		mergeHeadersWithCarrier(header, headerMask, data);
		int idx = NBR_HEADERS;
		int msch = (carrierFormat == RGB) ? 16 : 24;
		while(!bitBuffer.isEmpty()){
			data[idx] &= carrierMask;
			for(int ch = msch; ch >= 0; ch -= 8) {									// Use all four channels
				int s = bitBuffer.getNext(carrierBPCuse);
				data[idx] |= (s << ch);
			}
			idx++;
		}
		cimage.updatePixels();
		return cimage;
	}

	/**
	 * Extract the image from the stegan.
	 * 
	 * @param pphrase password / pass-phrase
	 * @param sImage the impregnated image (stegan)
	 * @return null if unable to retrieve the image
	 */
	PImage extractImageFromStegan(String pphrase, PImage sImage){
		sImage.loadPixels();
		int[] data = sImage.pixels;
		unpackHeaders(data);

		carrierMask = carrierFormat == RGB ? CARRIER3_BITS[carrierBPCuse] : CARRIER4_BITS[carrierBPCuse];

		if(SHOW_INFO)
			show("IMAGE EXTRACT");
		
		bitBuffer = new BitBuffer(data, NBR_HEADERS, carrierMask);

		int w = bitBuffer.getNext(16);
		int h = bitBuffer.getNext(16);
		if(w <= 0 || h <= 0 || w > 1000 || h > 1000){
			System.out.println("Error retrieving image burden");
			return null;
		}
		
		PImage burden =  new PImage(w, h, (burdenFormat == RGB) ? RGB : ARGB);
		
		burden.loadPixels();
		int[] bdata = burden.pixels;

		// Now extract image
		int colorBits = burdenFormat == ARGB ? 4 : 3;
		colorBits *= burdenBPCkept;
		int leftShift = 32 - colorBits;

		for(int i = 0; i < bdata.length; i++){
			bdata[i] = (bitBuffer.getNext(colorBits) << leftShift);
		}
		burden.updatePixels();
		Encryption.decodeImage(pphrase, burden, burdenFormat, burdenBPCkept);
		return burden;
	}


	/**
	 * Create a merge the text into the carrier image to make a stegan.
	 * 
	 * @param pphrase password / pass-phrase
	 * @param stegan the impregnated image (stegan)
	 * @param text the text to insert
	 * @return the stegan
	 */
	PImage embedTextInStegan(String pphrase, PImage cImage, String text) {
		// Use a copy of the carrier for the stegan
		cimage = cImage.get();

		burdenType = TEXT_BURDEN;
		burdenFormat = UTF8;
		carrierFormat = SteganosUtil.hasAlpha(cimage) ? ARGB : RGB;;

		// Convert string to UTF8 then to an integer array 
		byte[] utf8 = SteganosUtil.getUTF8array(text);
		burdenDataSize = utf8.length;
		int[] d = SteganosUtil.convertByteToIntArray(utf8, burdenDataSize);
		burdenBPCkept = 8;
		nbrBurdenBits = d.length * 32;
		burdenDataMask = 0xffffffff;

		// The number of bits used for the metadata
		metaDataBits = 31;
		metaDataMask = 0x7fffffff;
		metaData = new int[] {  burdenDataSize };

		// Number of bytes available in the carrier image
		// note: 4 are required for the header 
		carrierBytesAvailable = cimage.width * cimage.height * (carrierFormat == ARGB ? 4 : 3) - 4 * NBR_HEADERS;
		// Calculate the number of bytes to use in the carrier
		carrierBPCuse = (int) Math.ceil((metaDataBits + nbrBurdenBits) / carrierBytesAvailable);
		carrierBPCkept = 8 - carrierBPCuse;
		
		if(burdenBPCkept <= 0){
			System.out.println("The carrier image is too small to use");
			return null;
		}
		
		// This mask is used to clear the carrier bits used for storing the burden
		carrierMask = carrierFormat == RGB ? ~CARRIER3_BITS[carrierBPCuse] : ~CARRIER4_BITS[carrierBPCuse];

		// Encrypt integer array
		Encryption.encodeText(pphrase, d);

		// Create the header and header mask
		packHeaders(header, headerMask);

		if(SHOW_INFO)
			show("TEXT MERGE");

		bitBuffer = new BitBuffer(d, burdenDataMask, metaData, metaDataMask);

		// Merge the carrier and encrypted image
		cimage.loadPixels();
		int[] data = cimage.pixels;
		// Embed header
		mergeHeadersWithCarrier(header, headerMask, data);
		int idx = NBR_HEADERS;
		int msch = (carrierFormat == RGB) ? 16 : 24;
		while(!bitBuffer.isEmpty()){
			data[idx] &= carrierMask;
			for(int ch = msch; ch >= 0; ch -= 8) {
				int s = bitBuffer.getNext(carrierBPCuse);
				data[idx] |= (s << ch);
			}
			idx++;
		}
		cimage.updatePixels();
		return cimage;
	}

		/**
	 * Extract the text from the stegan.
	 * 
	 * @param pphrase password / pass-phrase
	 * @param sImage the impregnated image (stegan)
	 * @return null if unable to retrieve text
	 */
	String extractTextFromStegan(String pphrase, PImage sImage){
		sImage.loadPixels();
		int[] data = sImage.pixels;
		unpackHeaders(data);
		
		carrierMask = carrierFormat == RGB ? CARRIER3_BITS[carrierBPCuse] : CARRIER4_BITS[carrierBPCuse];
		bitBuffer = new BitBuffer(data, NBR_HEADERS, carrierMask);

		burdenDataSize = bitBuffer.getNext(31);
		// Catch if invalid burden data size
		if(burdenDataSize <= 0 || burdenDataSize >= 16777216)
			return null;
		bdata = new int[(int) Math.ceil(burdenDataSize/4.0)];

		if(SHOW_INFO)
			show("TEXT EXTRACT");

		// Now extract from the stegan
		for(int i = 0; i < bdata.length; i++){
			bdata[i] = bitBuffer.getNext(32);
		}
		// Decode the data
		Encryption.decodeText(pphrase, bdata);

		// Get the data as a byte array containing UTF8 and convert to String
		byte[] bytes = SteganosUtil.convertIntToByteArray(bdata, burdenDataSize);
		String s = null;
		try {
			s = new String(bytes, "UTF-8");
		}
		catch (Exception e) {
			s = "Unable to decode text";
		}
		return s;
	}

	/**
	 * Unpack the header information from the data
	 * @param d carrier pixel data
	 */
	void unpackHeaders(int[] d){
		// Get parts common for both image and text burdens
		version = d[0] &  0x7;
		burdenType = (d[0] >>> 8) & 0x3;
		carrierFormat = (d[1] >>> 8) & 0x3;
		carrierBPCkept = d[1] & 0x7;
		carrierBPCuse = 8 - carrierBPCkept;
		burdenFormat = (d[2] >>> 8) & 0x3;
		if(burdenType == IMAGE_BURDEN)
			burdenBPCkept = 1 + (d[2] & 0x7);
	}
	
	/**
	 * Create the headers and masks ready for merging with the carrier data.
	 * 
	 * @param h headers header information
	 * @param hm header masks used to clear image bits for header info
	 */
	void packHeaders(int[] h, int hm[]){
		h[0] = version;				// version
		h[0] |= burdenType << 8;	// Image or text burden type
		hm[0] = 0xfffffcf8;
		h[1] = carrierFormat << 8;	// Carrier format _ARGB _RGB
		h[1] |= carrierBPCkept;		// Number of carrier bits retained in stagn	
		hm[1] = 0xfffffcf8;
		h[2] = burdenFormat << 8;
		if(burdenType == IMAGE_BURDEN){
			h[2] |= (burdenBPCkept - 1);
			hm[2] = 0xfffffcf8;
		}
		else {
			hm[2] = 0xfffffcff;
		}
	}

	/**
	 * Merge the header information into the carrier data
	 * 
	 * @param h headers
	 * @param hm header masks
	 * @param d carrier pixel data
	 */
	void mergeHeadersWithCarrier(int[] h, int[] hm, int[] d){
		for(int i = 0; i < h.length; i++){
			d[i] &= hm[i]; 	// clear existing data bits
			d[i] |= h[i];	// merge header info
		}
	}
	
	/**
	 * Perform an analysis on the proposed carrier / burden combination
	 * 
	 * @param carrier the carrier image
	 * @param burden the burden image
	 * @return the result of the analysis
	 */
	Analysis analysis(PImage carrier, PImage burden){
		burdenType = IMAGE_BURDEN;
		carrierWidth = carrier.width;
		carrierHeight = carrier.height;
		carrierFormat = SteganosUtil.hasAlpha(carrier) ? PConstants.ARGB : PConstants.RGB;

		burdenWidth = burden.width;
		burdenHeight = burden.height;
		burdenFormat = SteganosUtil.hasAlpha(burden) ? PConstants.ARGB : PConstants.RGB;

		nbrBurdenBits = 0;

		// Number of bytes available in the carrier image
		// note: 4 are required for the header 
		float carrierBytesAvailable = carrier.width * carrier.height * (carrierFormat == PConstants.ARGB ? 4 : 3) - 4 * NBR_HEADERS;

		int metaDataBits = 32;
		// Calculate the recommended number of burden bits to save
		int nbrBurdenBytes = burden.width * burden.height * (burdenFormat == PConstants.ARGB ? 4 : 3);
		int ckept = 0, bkept = 0; 
		burdenBPCkept = -1;
		carrierBPCkept = -1;
		for(int nb = 1; nb <= 8; nb++){
			//int ncbits = (int) Math.floor((metaDataBits + nbrBurdenBytes * nb) / carrierBytesAvailable) + 1;
			int ncbits = (int) Math.ceil((metaDataBits + nbrBurdenBytes * nb) / carrierBytesAvailable);
			if(ncbits <= 4){
				bkept = nb;
				ckept = 8 - ncbits;
			}
		}
		burdenBPCkept = bkept;
		carrierBPCkept = ckept;
		boolean approved = (carrierBPCkept >= 4) && (burdenBPCkept >= 4);
		return new Analysis(approved, analysisText(approved));
	}

	/**
	 * Perform an analysis on the proposed carrier / burden combination
	 * 
	 * @param carrier the carrier image
	 * @param burden the burden text
	 * @return the result of the analysis
	 */
	Analysis analysis(PImage carrier, String burden){
		burdenType = TEXT_BURDEN;
		carrierWidth = carrier.width;
		carrierHeight = carrier.height;
		carrierFormat = SteganosUtil.hasAlpha(carrier) ? PConstants.ARGB : PConstants.RGB;

		burdenWidth = -1;
		burdenHeight = -1;
		burdenFormat = -1;

		byte[] utf8 = SteganosUtil.getUTF8array(burden);
		int burdenBufferSize = (int) Math.ceil(utf8.length / 4.0f);
		nbrBurdenBits = burdenBufferSize * 32;
		burdenBPCkept = 8;

		// The number of bits used for the metadata
		int metaDataBits = 32;

		// Number of bytes available in the carrier image
		// note: 4 are required for the header 
		float carrierBytesAvailable = carrier.width * carrier.height * (carrierFormat == ARGB ? 4 : 3) - 4 * NBR_HEADERS;
		// Calculate the number of bytes to use in the carrier

		carrierBPCkept = 8 -(int) Math.ceil((metaDataBits + nbrBurdenBits) / carrierBytesAvailable);
		boolean approved = (carrierBPCkept >= 4);
		return new Analysis(approved, analysisText(approved));
	}

	/**
	 * Create and return the analysis report
	 */
	private String analysisText(boolean approved){
		StringBuilder sb = new StringBuilder();
		if(burdenType == IMAGE_BURDEN)
			sb.append("\n---------------------------------\n---    IMAGE BURDEN     --------");
		else
			sb.append("\n---------------------------------\n---    TEXT BURDEN      --------");
		sb.append("\nCarrier Image Details");
		sb.append("\n   Width           " + carrierWidth);
		sb.append("\n   Height          " + carrierHeight);
		sb.append("\n   Format          " + ((carrierFormat == PConstants.ARGB) ? "ARGB" : "RGB"));
		sb.append("\n   BPC retained    " + carrierBPCkept);
		if(burdenType == IMAGE_BURDEN){
			sb.append("\nBurden Image Details");
			sb.append("\n   Width           " + burdenWidth);
			sb.append("\n   Height          " + burdenHeight);
			sb.append("\n   Format          " + ((burdenFormat == PConstants.ARGB) ? "ARGB" : "RGB"));
			sb.append("\n   BPC retained    " + burdenBPCkept);	
		}
		else {
			sb.append("\nBurden Text Details");
			sb.append("\n   UTF-8 bytes     " + (nbrBurdenBits / 8));
			sb.append("\n   UTF-8 bits      " + nbrBurdenBits);
			sb.append("\n   Bits retained   8");		
		}
		if(approved)
			sb.append("\n >>> This combination is approved");
		else
			sb.append("\nXXX This combination will not work");			
		sb.append("\n---------------------------------\n");
		return sb.toString();
	}

	/**
	 * Used for testing only
	 */
	private void show(String title){
		System.out.println("\n##############       Details      ##############");
		System.out.println("###   " + title);
		System.out.println("Burden type        \t" + (burdenType == IMAGE_BURDEN ? "Image" : "Text"));
		if(burdenType == IMAGE_BURDEN){
			System.out.println("###   Image burden details");
			System.out.println("Type               \t" + (burdenFormat == RGB ? "RGB" : "ARGB"));
			System.out.println("BPC kept           \t" + burdenBPCkept);
			System.out.println("Data mask          \t" + SteganosUtil.binary(burdenDataMask));		
		}
		else {
			System.out.println("###   Text burden details");
			System.out.println("Type               \t" + (burdenFormat == UTF8 ? "UTF8" : "???"));
			System.out.println("Burden byte size   \t" + burdenDataSize);
			System.out.println("Burden array size  \t" + bdata.length);
		}
		System.out.println("###   Carrier details");
		System.out.println("Carrier type       \t" + (carrierFormat == RGB ? "RGB" : "ARGB"));
		System.out.println("Carrier BPC kept   \t" + carrierBPCkept);
		System.out.println("Carrier BPC used   \t" + carrierBPCuse);
		System.out.println("Carrier mask       \t" + SteganosUtil.binary(carrierMask));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
}
