/**
 * implement this interface with a class called "[yourGivenName]PrimeCalc"
 */
package de.edicos.azubi.aufgabe5;

/**
 * @author ckoepp
 *
 */
public interface IPrimeCalc {
	
	/**
	 * Calculate the first n prime numbers.
	 * @param n the number of primes to calculate.
	 * @return a list of n primes in ascending order.
	 */
	public int[] calcPrimes(int n);
	
}
