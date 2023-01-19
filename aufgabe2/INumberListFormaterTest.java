/**
 * extend this abstract class with a class called [yourGivenName]NumberListFormaterTest
 * and implement the abstract method createInstance
 * which returns an instance of [yourGivenName]NumberListFormater
 */

package de.edicos.azubi.aufgabe2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public abstract class INumberListFormaterTest {
	
	public abstract INumberListFormater createInstance();


	@Test
	public void testAsRangedListIntArray() {

		INumberListFormater lf = createInstance();
		
		assertEquals("1", lf.asRangedList(new int[] {1}));
		
		assertEquals("1,2", lf.asRangedList(new int[] {1,2}));

		assertEquals("1-3", lf.asRangedList(new int[] {1,2,3}));
		
		assertEquals("1-9", lf.asRangedList(new int[] {1,2,3,4,5,6,7,8,9}));
		
		assertEquals("1,2,4-9", lf.asRangedList(new int[] {1,2,4,5,6,7,8,9}));
		
		assertEquals("1-5,7-9", lf.asRangedList(new int[] {1,2,3,4,5,7,8,9}));
		
		assertEquals("3-9", lf.asRangedList(new int[] {3,4,5,6,7,8,9}));
		
		assertEquals("3,4", lf.asRangedList(new int[] {3,4}));
		
		assertEquals("5,9,10,115-118", lf.asRangedList(new int[] {5,9,10,115,116,117,118}));
		
		assertEquals("1-3,5", lf.asRangedList(new int[] {1,2,3,5}));
		
		assertEquals("1-3,5,6", lf.asRangedList(new int[] {1,2,3,5,6}));
		
		assertEquals("1-3,5-7", lf.asRangedList(new int[] {1,2,3,5,6,7}));
		
		assertEquals("1,3-5,7,9", lf.asRangedList(new int[] {1,3,4,5,7,9}));
	}

	// @return a string in the described form, or "" for empty lists and null.

	@Test
	public void testAsRangedListArrayNullOrEmpty() {
		INumberListFormater lf = createInstance();

		assertEquals("", lf.asRangedList(new int[] {}));

		assertEquals("", lf.asRangedList((int[])null));

	}

	@Test
	public void testAsRangedListIntArrayWithDuplicates() {
		INumberListFormater lf = createInstance();

		assertEquals("1-3", lf.asRangedList(new int[] {3,1,2,3}));
		
		assertEquals("3,6-10,12,117-119", lf.asRangedList(new int[] {10,12,9,6,8,3,117,119,118,7}));
		
		assertEquals("1-4", lf.asRangedList(new int[] {1,2,3,3,3,3,3,3,4}));
		
		assertEquals("1,3", lf.asRangedList(new int[] {1,3,3,3,3,3,3}));
		
		assertEquals("10,12,14,16-20,25", lf.asRangedList(new int[] {10,12,14,16,17,18,19,20,25,25,25}));
		
		assertEquals("9,11,13-15", lf.asRangedList(new int[] {9,11,13,13,13,13,13,14,15}));
		
		assertEquals("11-13,15,16", lf.asRangedList(new int[] {11,11,11,12,12,13,13,13,13,15,15,15,15,16}));
		
		assertEquals("1,3", lf.asRangedList(new int[] {1,1,1,1,1,1,1,1,3}));
		
		assertEquals("1,3", lf.asRangedList(new int[] {1,1,1,1,1,1,1,1,3,3,3,3,3,3}));
		
		assertEquals("1,3-5", lf.asRangedList(new int[] {1,3,3,3,3,3,3,4,5}));
		
		assertEquals("1-5,10,11", lf.asRangedList(new int[] {1,2,3,3,3,3,3,4,5,10,10,11,11,11}));
		
		assertEquals("3,5-7,10-12,20,21", lf.asRangedList(new int[] {3,3,3,3,5,6,7,10,10,11,11,11,12,12,12,12,20,20,20,21,21,21,21}));
		
		assertEquals("3,5-7,10-12,20,21,23,25-28", lf.asRangedList(new int[] {3,3,3,3,5,5,5,6,6,6,7,7,10,10,11,11,11,12,12,12,12,20,20,20,21,21,21,21,23,23,23,25,26,27,28,28,28}));
		
		
	}

	@Test
	public void testAsRangedListIntArray2() {
		INumberListFormater lf = createInstance();

		int[] numberTest = new int[]{0,1,2,3,7,9,10,111,112,117};
		assertEquals("0-3,7,9,10,111,112,117", lf.asRangedList(numberTest));
	}

	@Test
	public void testAsRangedListIntList3() {
		INumberListFormater lf = createInstance();

		List<Integer> numberTest = Arrays.asList(17,28,3,4,6,7,9,11,12);
		assertEquals("3,4,6,7,9,11,12,17,28", lf.asRangedList(numberTest));
	}
	
	@Test
	public void testAsRangedListIntList4() {
		INumberListFormater lf = createInstance();

		List<Integer> numberTest = Arrays.asList(17,28,29,30,3,4,6,7,9,13,11,12);
		assertEquals("3,4,6,7,9,11-13,17,28-30", lf.asRangedList(numberTest));
	}
}
