/**
 * extend this abstract class with a class called "[yourGivenName]SquaresIntoSquares"
 * and implement the abstract method "createInstance()"
 * which returns an instance of "[yourGivenName]SquaresIntoSquares"
 */

package de.edicos.azubi.aufgabe7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * TODO Add more test cases to cover all corner cases!
 * @author plagershausen
 * @version 1.0
 */
public abstract class ISquaresIntoSquaresTest {
    
    public abstract ISquaresIntoSquares createInstance();

    /**
     * Test method for {@link ISquaresIntoSquares#decompose(int)}.
     */
    @Test
    public final void testVerwendungszweckFfm() {

        ISquaresIntoSquares o = createInstance();
        String generated;


        generated = o.decompose(15);
        assertEquals("2 5 14", generated);

        generated = o.decompose(4);
        assertEquals(null, generated);

        generated = o.decompose(50);
        assertEquals("1 3 5 8 49", generated);

        generated = o.decompose(251);
        assertEquals("1 4 22 250", generated);

        generated = o.decompose(251);
        assertEquals("1 4 22 250", generated);

        generated = o.decompose(45861);
        assertEquals("1 4 10 20 302 45860", generated);

        generated = o.decompose(1789563);
        assertEquals("1 7 13 55 1891 1789562", generated);

        generated = o.decompose(414865175);
        assertEquals("2 4 48 28805 414865174", generated);
    }

}
