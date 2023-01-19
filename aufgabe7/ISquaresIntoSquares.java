/**
 * implement this interface with a class called "[yourGivenName]SquaresIntoSquares"
 */

package de.edicos.azubi.aufgabe7;


/**
 * NOTE: Original source is documented in Solutions.
 *
 * <h3>Task</h3>
 * Given a positive integral number n, return a strictly increasing sequence (list/array/string depending on the language) of numbers, so that the sum of the squares is equal to n².
 *
 * If there are multiple solutions (and there will be), return as far as possible the result with the largest possible values:
 *
 * <h4>Examples</h4>
 * decompose(11) must return [1,2,4,10]. Note that there are actually two ways to decompose 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10² but don't return [2,6,9], since 9 is smaller than 10.
 *
 * For decompose(50) don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly increasing sequence.
 *
 * <h4>Note</h4>
 * Neither [n] nor [1,1,1,...,1] are valid solutions. If no valid solution exists, null.
 *
 * The function "decompose" will take a positive integer n and return the decomposition of N = n² as:
 *
 * "x1 ... xk"
 *
 * <h4>Hint</h4>
 * Very often xk will be n-1.
 */
public interface ISquaresIntoSquares {

    public String decompose(int n);

}