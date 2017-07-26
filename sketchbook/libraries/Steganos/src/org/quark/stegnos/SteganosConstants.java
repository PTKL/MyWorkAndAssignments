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

/**
 * Constant values used in the library.
 * 
 * @author Peter Lager
 *
 */
interface SteganosConstants {

	// Message type (2 bits)
	int TEXT_BURDEN 	= 0x0;
	int IMAGE_BURDEN 	= 0x1;
	
	// Image config
	int RGB  			= PConstants.RGB;
	int ARGB 			= PConstants.ARGB;
	
	// Text config
	int UTF8			= 0x1;

	// Identify bits used in the carrier image for storing the burden
	int[] CARRIER3_BITS 		= { 0x00000000, 0x00010101, 0x00030303, 0x00070707, 0x000f0f0f, 0x001f1f1f, 0x003f3f3f, 0x007f7f7f, 0x00ffffff };
	int[] CARRIER4_BITS 		= { 0x00000000, 0x01010101, 0x03030303, 0x07070707, 0x0f0f0f0f, 0x1f1f1f1f, 0x3f3f3f3f, 0x7f7f7f7f, 0xffffffff };
	

	// Once the ARGB or RGB is merged these show the bits in the burden to be merged
	int[] RGB_MERGED_BITS		= { 0x00000000, 0xe0000000, 0xfc000000, 0xff800000, 0xfff00000, 0xfffe0000, 0xffffc000, 0xfffff800, 0xffffff00 };
	int[] ARGB_MERGED_BITS		= { 0x00000000, 0xf0000000, 0xff000000, 0xfff00000, 0xffff0000, 0xfffff000, 0xffffff00, 0xfffffff0, 0xffffffff }; 

}
