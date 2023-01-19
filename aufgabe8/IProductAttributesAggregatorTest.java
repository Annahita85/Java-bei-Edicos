/**
 * extend this abstract class with a class called “[yourGivenName]ProductAttributesAggregatorTest”
 * and implement the abstract method “createInstance”
 * which returns an instance of “[yourGivenName]ProductAttributesAggregator”
 */

package de.edicos.azubi.aufgabe8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class IProductAttributesAggregatorTest {
	
	public abstract IProductAttributesAggregator createInstance();
	
	private IProductDescription product1 = new ProductDescriptionDummy("a", "b",     "d", "e", "g",      "h", "i");
	private IProductDescription product2 = new ProductDescriptionDummy("a", "b",     "d", "e", "f",      "h", "i");
	private IProductDescription product3 = new ProductDescriptionDummy("a", "b", "c",     "e", "f", "g", "h", "i");
	private IProductDescription product4 = new ProductDescriptionDummy("a", "b", "c");
	private IProductDescription product5 = new ProductDescriptionDummy("d", "e", "f");
	private IProductDescription product6 = new ProductDescriptionDummy("c", "b", "a");
	
	private final IProductAttributesAggregator paa = createInstance();

	@Test
	public void testAggregateAttributesA() {
		assertEquals(arrList("a", "b", "d", "e", "g", "h", "i"), paa.aggregateAttributes(product1, product1));
	}

	@Test
	public void testAggregateAttributesB() {
		assertEquals(arrList("a", "b", "c", "d", "e", "f"), paa.aggregateAttributes(product4, product5));
	}	

	@Test
	public void testAggregateAttributesC() {
		assertEquals(arrList("a", "b", "c", "d", "e", "f", "g", "h", "i"), paa.aggregateAttributes(product3, product2, product1));
	}	

	@Test
	public void testAggregateAttributesD() {
		assertEquals(arrList("a", "b", "d", "c", "e", "f", "g", "h", "i"), paa.aggregateAttributes(product1, product2, product3));
	}	

	@Test
	public void testAggregateAttributesE() {
		assertEquals(arrList("d", "e", "f", "a", "b", "c"), paa.aggregateAttributes(product5, product4));
	}	

	@Test
	public void testAggregateAttributesF() {
		assertEquals(arrList("a", "b", "c"), paa.aggregateAttributes(product4, product6));
	}	

	@Test
	public void testAggregateAttributesG() {
		assertEquals(arrList("a", "b", "c"), paa.aggregateAttributes(product4));
	}	

	@Test
	public void testAggregateAttributesH() {
		assertEquals(arrList(), paa.aggregateAttributes());
	}	

	@Test
	public void testAggregateAttributesI() {
		assertEquals(arrList("a", "b", "c"), paa.aggregateAttributes(product4, product4, product4));
	}	
	
	private ArrayList<String> arrList(String... elements) {
		return new ArrayList<>(Arrays.asList(elements));
	}



}
