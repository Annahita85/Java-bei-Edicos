/**
 * implement this interface with a class called "[yourGivenName]ProductAttributesAggregator"
 */

package de.edicos.azubi.aufgabe8;

import java.util.List;

/**
 * Combine the attributes from several product descriptions 
 * to a common attribute list conserving the order.
 * 
 * <h3>Examples</h3>
 *
 * <h3>Example0</h3>
 * <pre>
 * Product1 has attributes: a, b,    d, e,    g, h, i
 * Product2 has attributes: a, b,    d, e, f,    h, i
 * Product3 has attributes: a, b, c, d,    f, g, h, i
 * So the resulting attribute list should be:
 *                          a, b, c, d, e, f, g, h, i
 * </pre>
 *
 * <h3>Example1</h3>
 * <pre>
 * Product1 has attributes: a, b,    d, e,    g, h, i
 * Product2 has attributes: a, b,    d, e, f,    h, i
 * Product3 has attributes: a, b, c,    e, f, g, h, i
 * So the resulting attribute list should be:
 *                          a, b, d, c, e, f, g, h, i
 * </pre>
 * 
 * <h3>Example2</h3>
 * <pre>
 * Product1 has attributes: a, b, c
 * Product2 has attributes: d, e, f
 * So the resulting attribute list should be:
 *                          a, b, c, d, e, f
 * </pre>
 * 
 * <h3>Example3</h3>
 * <pre>
 * Product1 has attributes: d, e, f
 * Product2 has attributes: a, b, c
 * So the resulting attribute list should be:
 *                          d, e, f, a, b, c
 * </pre>
 * 
 * <h3>Example4</h3>
 * <pre>
 * Product1 has attributes: a, b, c
 * Product2 has attributes: c, b, a
 * So the resulting attribute list should be:
 *                          a, b, c
 * </pre>
 * 
 * @author ckoepp
 * @version 1.0
 */
public interface IProductAttributesAggregator {

	public List<String> aggregateAttributes(IProductDescription... p);

}
