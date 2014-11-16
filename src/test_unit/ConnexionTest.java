package test_unit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import principal.Connexion;
import traitement.Traitement_xml;

public class ConnexionTest {
	 private Connexion connexion = null;
	@Before
	public void setUp() throws Exception {
		connexion = new Connexion();
	}

	@After
	public void tearDown() throws Exception {
		connexion = null;
	}

	@Test
	public void testConnexion() {
		connexion.connexion("chtiwi.dev@gmail.com","123");
	}

	@Test
	public void testIsValidEmailAddress() {
		connexion.isValidEmailAddress("chtiwi.dev@gmail.com");
	}

}
