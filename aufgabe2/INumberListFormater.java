/**
 * implement this interface with a class called “[yourGivenName]NumberListFormater”
 */
package de.edicos.azubi.aufgabe2;

import java.util.List;

/**
 * @author ckoepp
 * @version 1.1
 */
public interface INumberListFormater {

	/**
	 * Listen von Zahlen mit zusammenhängenden Bereichen schön darstellen.
	 * 
	 * <p>
	 * Beispiel:
	 * </p>
	 * 
	 * <pre>
	 * 1,2               -> 1,2
	 * 1,2,3             -> 1-3
	 * 1,2,3,4,5,6,7,8,9 -> 1-9
	 * 1,2,4,5,6,7,8,9   -> 1,2,4-9
	 * 1,2,3,4,5,7,8,9   -> 1-5,7-9
	 * </pre>
	 * Hinweis: Wenn nur zwei Zahlen aufeinander folgen, so sollen diese mit Komma getrennt werden.
	 * <p>Beispiel 4,5 und nicht 4-5</p>
	 * @param a list of numbers, could be null.
	 * @return a string in the described form, or "" for empty lists and null.
	 */
	public String asRangedList(List<Integer> numbers);

	/**
	 * Format array of numbers as described for {@link #asRangedList(List)}
	 * @param numbers
     * @return
	 */
	public String asRangedList(int[] numbers);

}
