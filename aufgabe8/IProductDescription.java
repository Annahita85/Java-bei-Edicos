/**
 * 
 */
package de.edicos.azubi.aufgabe8;

import java.util.LinkedHashMap;

/**
 * @author ckoepp
 *
 */
public interface IProductDescription {
	
	/**
	 * Get the name of the product.
	 * @return
	 */
	public String getName();
	
	/**
	 * Get all attributes and their values for the product.
	 * There is a defined order of the attributes.
	 * @return an ordered map.
	 */
	public LinkedHashMap<String, String> getAttributes();

}
