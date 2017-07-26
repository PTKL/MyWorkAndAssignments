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


/**
 * 
 * This class encapsulates an integer array and enables the data to be 
 * read one or more bits at a time. The masks are used to indicate 
 * which bits from the data are to be returned. <br>
 * 
 * 
 * @author Peter Lager
 *
 */
public class BitBuffer {

	private static boolean SHOW_INFO = false;

	private int[] data;

	// Bit masks for identifying bits for extraction
	private int metaDataMask;
	private int bitDataMask;
	private int maskToUse;;

	private int metaDataMaskNbrBits;
	private int bitDataMaskNbrBits;

	// Size in bits to read
	private int metaDataSize;
	private int dataSize;

	// Number of bits read
	private int bitsRead;

	private int idx;
	private int p = 31;


	/**
	 * Use this for reading the CARRIER data <br>
	 * A BitBuffer created using this constructor is suitable for 
	 * reading encrypted burden data from the carrier.
	 * 
	 * @param carrierData
	 * @param skipBytes the elements used by the header of bytes to s
	 * @param carrierMask
	 */
	public BitBuffer(int[] carrierData, int skipBytes, int carrierMask){
		this.data = new int[carrierData.length - skipBytes];
		System.arraycopy(carrierData, skipBytes, data, 0, carrierData.length - skipBytes);
		this.bitDataMask = this.metaDataMask = this.maskToUse = carrierMask;
		metaDataMaskNbrBits = nbrBitsSet(this.metaDataMask);
		bitDataMaskNbrBits = nbrBitsSet(this.bitDataMask);
		dataSize = carrierData.length * bitDataMaskNbrBits;
		idx = 0;
		if(SHOW_INFO)
			printDetails();
	}

	/**
	 * Use this for reading the BURDEN data <br>
	 * A BitBuffer created using this constructor is suitable for 
	 * reading encrypted burden data when embedding into a steganograph.
	 * 
	 * @param bdnData the burden data
	 * @param bdnMask the burden mask
	 * @param mdData the meta data
	 * @param mdMask the meta data mask
	 */
	public BitBuffer(int[] bdnData, int bdnMask, int[] mdData, int mdMask){
		this.data = new int[mdData.length + bdnData.length];
		System.arraycopy(mdData, 0, data, 0, mdData.length);
		System.arraycopy(bdnData, 0, data, mdData.length, bdnData.length);
		this.bitDataMask = bdnMask;
		this.metaDataMask = mdMask;
		this.maskToUse = mdMask;
		metaDataMaskNbrBits = nbrBitsSet(this.metaDataMask);;
		metaDataSize = mdData.length * metaDataMaskNbrBits;
		bitDataMaskNbrBits = nbrBitsSet(this.bitDataMask);
		dataSize = bdnData.length * bitDataMaskNbrBits;
		idx = 0;
		if(SHOW_INFO)
			printDetails();
	}

	/**
	 * Has all the bits been read?
	 * @return true if all the available bits in the buffer have been read
	 */
	public boolean isEmpty(){
		return bitsRead >= dataSize + metaDataSize;
	}

	/**
	 * Get the next bit
	 */
	public int getNext(){
		while(idx < data.length){
			while(p >= 0){
				int bit = 1 << p;
				if( (maskToUse & bit) != 0){
					int bitValue = (data[idx] & bit) != 0 ? 1 : 0;
					bitsRead++;
					p--;
					return bitValue;
				}
				p--;
			}
			// if we get here then try the next data element
			p = 31;
			idx++;
			maskToUse = bitsRead < metaDataSize ? metaDataMask : bitDataMask;
		}
		//System.out.println("No more data " + bitsRead);
		// If we get here then no more data
		return 0;
	}

	/**
	 * Get a number of bits and pass back as LSB in an integer.
	 * @param nbrBits >0
	 */
	public int getNext(int nbrBits){
		int bits = 0;
		bits = getNext();
		while(nbrBits > 1){
			bits <<= 1;
			bits |= getNext();
			nbrBits--;
		}
		return bits;
	}

	/**
	 * Calculate the number of bits set in a mask.
	 * @param mask
	 * @return number of '1' / set bits
	 */
	public int nbrBitsSet(int mask){
		int c = 0;
		while(mask != 0){
			c += mask & 1;
			mask >>>= 1;
		}
		return c;
	}

	/**
	 * For testing only
	 */
	private void printDetails(){
		System.out.println("\n##############       Bit Buffer Details      ##############");
		System.out.println("Metadata mask      \t" + SteganosUtil.binary(metaDataMask));
		System.out.println("      nbr bits set \t" + metaDataMaskNbrBits);
		System.out.println("      size         \t" + metaDataSize);
		System.out.println("Data mask          \t" + SteganosUtil.binary(bitDataMask));
		System.out.println("      nbr bits set \t" + bitDataMaskNbrBits);
		System.out.println("      size         \t" + dataSize);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}


}
