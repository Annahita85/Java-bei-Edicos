/**
 * extend this abstract class with a class called "[yourGivenName]VerwendungszweckGeneratorTest"
 * and implement the abstract method “createInstance”
 * which returns an instance of "[yourGivenName]VerwendungszweckGenerator"
 * 
 * Add more test cases to cover all corner cases!
 * <p>Remark: initially created with package name de.edicos.azubi.sascha.fundgourmet.zahlung</p>
 */
package de.edicos.azubi.aufgabe6;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author ckoepp
 * 
 */
public abstract class IVerwendungszweckGeneratorTest {
	
	public abstract IVerwendungszweckGenerator createInstance();

	/**
     * Test method for {@link de.edicos.azubi.aufgabe6.IVerwendungszweckGenerator#verwendungszweckFfm(int, boolean, boolean, int, int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testVerwendungszweckFfm() {
		IVerwendungszweckGenerator o = createInstance();
		String generated;
		
		
		generated = o.verwendungszweckFfm(2015, true, true, 2, 779191, "Hans-Jörg", "von Mettenheim");
		assertEquals("FG-FFM2015-PA2D-T4S6-VONMETTE-HANSJRG", generated);
		
		generated = o.verwendungszweckFfm(2015, false, false, 1, 358082, "Cornelius", "Köpp");
		assertEquals("FG-FFM2015-NN1D-C0K1-KPP-CORNELIU", generated);
	}

	/**
     * Test method for {@link de.edicos.azubi.aufgabe6.IVerwendungszweckGenerator#verwendungszweckPaperDB(boolean, boolean, int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testVerwendungszweckPaperDB() {
		IVerwendungszweckGenerator o = createInstance();
		String generated;
		
		generated = o.verwendungszweckPaperDB(true, true, 779191, "Hans-Jörg", "von Mettenheim");
		assertEquals("FG-DB-AE-T4S6-VONMETTE-HANSJRG", generated);

		generated = o.verwendungszweckPaperDB(false, true, 231680, "Rolf", "Henning");
		assertEquals("FG-DB-AF-7R2H-HENNING-ROLF", generated);

	}

}
