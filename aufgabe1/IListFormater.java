/**
 * implement this interface with a class called “[yourGivenName]ListFormater”
 */
package de.edicos.azubi.aufgabe1;

import java.util.List;

/**
 * Creates formated strings from a list of strings.
 * <p>
 * Provide a default separator. Recommendation: use ";" as default separator.
 * </p>
 * 
 * @author ckoepp
 */
public interface IListFormater {

	/**
	 * Creates a comma separated string of a list.
	 * 
	 * @param list
	 *            a list of Strings
	 * @return returns a string in the format
	 *         "listentry1, listentry2, listentry3"
	 */
	public String asCommaSeparatedList(List<String> list);

	/**
	 * Creates a separated string of a list, using the separator defined in this
	 * instance.
	 * 
	 * @param list
	 *            a list of Strings
	 * @return returns a string in the format
	 *         "listentry1{$separator}listentry2{$separator}listentry3"
	 */
	public String asSeparatedList(List<String> list);

	/**
	 * Creates a separated string of a list, using the separator defined in this
	 * instance.
	 * 
	 * @param list
	 *            a list of Strings
	 * @param separator
	 *            a string, must not be null.
	 * @return returns a string in the format
	 *         "listentry1{$separator}listentry2{$separator}listentry3"
	 */
	public String asSeparatedList(List<String> list, String separator);

	/**
	 * Creates a separated string of a list, using the separator defined in this
	 * instance.
	 * 
	 * @param list
	 *            a list of Strings
	 * @param separator
	 *            a string, must not be null.
	 * @param lastSeparator
	 *            a string, must not be null. Used only once at the end of the list. 
	 * @return returns a string in the format
	 *         "listentry1{$separator}listentry2{$lastSeparator}listentry3"
	 */
	public String asSeparatedList(List<String> list, String separator, String lastSeparator);

	/**
	 * Creates a tabulator separated string of a list.
	 * 
	 * @param list
	 *            a list of Strings
	 * @return returns a string in the format
	 *         "listentry1\tlistentry2\tlistentry3"
	 */
	public String asTabSeparatedList(List<String> list);

	/**
	 * Get the separator string currently used as default separator in
	 * {@link #setSeparator(String)}
	 * 
	 * @return the separator, not null.
	 */
	public String getSeparator();

	/**
	 * Set the separator string as default separator used in
	 * {@link #setSeparator(String)}.
	 * 
	 * @param separator
	 *            a string, must not be null.
	 * @throws NullPointerException
	 *             when separator is null.
	 */
	public void setSeparator(String separator) throws NullPointerException;

}
