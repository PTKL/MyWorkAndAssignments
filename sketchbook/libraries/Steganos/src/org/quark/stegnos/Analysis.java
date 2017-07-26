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
 * Simple class to hold the results of an analysis. <br/>
 * 
 * 
 * @author Peter Lager
 *
 */
public class Analysis {

	
	public final boolean approved;
	public final String text;
	
	/**
	 * This class can only be instantiated by the library.
	 */
	Analysis(boolean approved, String text) {
		super();
		this.approved = approved;
		this.text = text;
	}
	
	/**
	 * Returns true if the analysis shows the combination is suitable for a stegan.
	 */
	public boolean approved(){
		return approved;
	}
	
	/**
	 * Returns the analysis text.
	 */
	public String text(){
		return text;
	}
	
	
}
