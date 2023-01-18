/**
 * extend this abstract class with a class called “[yourGivenName]ListFormaterTest”
 * and implement the abstract method “createInstance”
 * which returns an instance of “[yourGivenName]ListFormater”
 */
package de.edicos.azubi.aufgabe1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * @author ckoepp
 * @version 1.6
 */
public abstract class IListFormaterTest {
	
	public abstract IListFormater createInstance();
	
	private List<String> createList() {
		List<String> list = new ArrayList<String>();
		list.add("Erster");
		list.add("Zweiter");
		list.add("Dritter");
		list.add("Vierter");
		return list ;
	}

	private List<String> createList2() {
		List<String> list = new ArrayList<String>();
		list.add("");
		list.add("Nicht leer");
		list.add("auch nicht leer");
		list.add("Letzter Eintrag");
		return list ;
	}

	private List<String> createList3() {
		List<String> list = new ArrayList<String>();
		list.add("Einziger");
		return list ;
	}
	
    private List<String> createList4() {
		List<String> list = new ArrayList<String>();
		return list ;
	}
    
	private List<String> createList5() {
		return Arrays.asList("1","+","!");
	}
	
	
	/**
	 * Test method for {@link de.edicos.azubi.aufgabe1.IListFormater#asCommaSeparatedList(java.util.List)}.
	 */
	@Test
	public void testAsCommaSeparatedList() {
		assertEquals("Erster, Zweiter, Dritter, Vierter", createInstance().asCommaSeparatedList(createList()));
		
		assertEquals(", Nicht leer, auch nicht leer, Letzter Eintrag", createInstance().asCommaSeparatedList(createList2()));
		assertEquals("Einziger", createInstance().asCommaSeparatedList(createList3()));
		assertEquals("", createInstance().asCommaSeparatedList(createList4()));
	}

	/**
	 * Test method for {@link de.edicos.azubi.aufgabe1.IListFormater#asSeparatedList(java.util.List)}.
	 */
	@Test
	public void testAsSeparatedListListOfString() {
		IListFormater o = createInstance();
		o.setSeparator("~+");
		assertEquals("Erster~+Zweiter~+Dritter~+Vierter", o.asSeparatedList(createList()));
		
		o.setSeparator("Vierter");
		assertEquals("ErsterVierterZweiterVierterDritterVierterVierter", o.asSeparatedList(createList()));
		
		o.setSeparator("!");
		assertEquals("1!+!!", o.asSeparatedList(createList5()));
		assertEquals("", o.asSeparatedList(new ArrayList<>(0)));
		
		o.setSeparator("XXXX");
		assertEquals("ErsterXXXXZweiterXXXXDritterXXXXVierter", o.asSeparatedList(createList()));
	}

	/**
	 * Test method for {@link de.edicos.azubi.aufgabe1.IListFormater#asSeparatedList(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testAsSeparatedListListOfStringString() {
		assertEquals("Erster & Zweiter & Dritter & Vierter", createInstance().asSeparatedList(createList(), " & "));
		assertEquals("ErsterZweiterDritterVierter", createInstance().asSeparatedList(createList(), ""));
	}

	/**
	 * Test method for {@link de.edicos.azubi.aufgabe1.IListFormater#asSeparatedList(java.util.List, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAsSeparatedListListOfStringStringString() {
		assertEquals("Erster, Zweiter, Dritter und Vierter", createInstance().asSeparatedList(createList(), ", ", " und "));
		
		assertEquals("undNicht leerundauch nicht leer, Letzter Eintrag", createInstance().asSeparatedList(createList2(), "und", ", "));

		assertEquals("Einziger", createInstance().asSeparatedList(createList3(), "+", "**"));
		
		final IListFormater o = createInstance();
		final List<String> list = Arrays.asList("Erster", "Zweiter", "Dritter", "Vierter, Fünfter");
		assertEquals("Erster, Zweiter, Dritter und Vierter, Fünfter", o.asSeparatedList(list, ", ", " und "));
	}

	/**
	 * Test method for {@link de.edicos.azubi.aufgabe1.IListFormater#asTabSeparatedList(java.util.List)}.
	 */
	@Test
	public void testAsTabSeparatedList() {
		assertEquals("Erster\tZweiter\tDritter\tVierter", createInstance().asTabSeparatedList(createList()));
	}
	
	
	/**
	 * Test method for {@link de.edicos.azubi.aufgabe1.IListFormater#getSeparator()} and {@link de.edicos.azubi.aufgabe1.IListFormater#setSeparator()}.
	 */
	@Test
	public void testGetSeparator() {
		String separator;
		IListFormater o = createInstance();
		
		separator = "-SEP-";
		o.setSeparator(separator);
		assertEquals(separator, o.getSeparator());
		assertEquals(o.asSeparatedList(createList()), o.asSeparatedList(createList(), separator));
		
		separator = "|";
		o.setSeparator(separator);
		assertEquals(separator, o.getSeparator());
		
		separator = "";
		o.setSeparator(separator);
		assertEquals(separator, o.getSeparator());
	}
	
	
	/**
	 * Test special chars usage.
	 * @since 1.5
	 */
	@Test
	public void testSpecialChars() {
		IListFormater o = createInstance();
		
		assertEquals("[a, bc, def, ghi, jkl", o.asCommaSeparatedList(Arrays.asList("[a", "bc", "def", "ghi", "jkl")));
		assertEquals(", a, bc, def, ghi, jkl", o.asCommaSeparatedList(Arrays.asList(", a", "bc", "def", "ghi", "jkl")));
		assertEquals(",a, bc, def, ghi, jkl", o.asCommaSeparatedList(Arrays.asList(",a", "bc", "def", "ghi", "jkl")));
		assertEquals("[a, bc, def, ghi, jkl]", o.asCommaSeparatedList(Arrays.asList("[a", "bc", "def", "ghi", "jkl]")));
		assertEquals("a, bc, def, ghi, jkl]", o.asCommaSeparatedList(Arrays.asList("a", "bc", "def", "ghi", "jkl]")));
		assertEquals("a, bc, d, ef, g,hi, jkl]", o.asCommaSeparatedList(Arrays.asList("a", "bc", "d, ef", "g,hi", "jkl]")));
		assertEquals("[[[a, ]bc, []def, ghi, jkl]", o.asCommaSeparatedList(Arrays.asList("[[[a", "]bc", "[]def", "ghi", "jkl]")));

		assertEquals("[a[bc[def[ghi[jkl", o.asSeparatedList(Arrays.asList("[a", "bc", "def", "ghi", "jkl"), "["));
		assertEquals("[a]bc]def]ghi]jkl", o.asSeparatedList(Arrays.asList("[a", "bc", "def", "ghi", "jkl"), "]"));
		assertEquals("[a , ,  bc , ,  def , ,  ghi , ,  jkl", o.asSeparatedList(Arrays.asList("[a", "bc", "def", "ghi", "jkl"), " , ,  "));
	}
	
	
	/**
	 * Test side effect free implementation of list generator functions.
	 * @since 1.3
	 */
	@Test
	public void testSideEffectFreeImplementation() {
		String separator;
		IListFormater o = createInstance();
		
		separator = "-SEP-";
		o.setSeparator(separator);
		
		o.asCommaSeparatedList(createList());
		o.asSeparatedList(createList());
		o.asTabSeparatedList(createList());
		
		assertEquals(separator, o.getSeparator());
	}
	
	
	/**
	 * Test value checking in {@link de.edicos.azubi.aufgabe1.IListFormater#setSeparator()}.
	 * @since 1.2
	 */
	@Test(expected=NullPointerException.class)
	public void testSetSeparatorNullCheck() {
		IListFormater o = createInstance();
		o.setSeparator(null);
	}

}
