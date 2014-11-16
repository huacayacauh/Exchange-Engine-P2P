package test_unit;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import traitement.Traitement_xml;

public class Traitement_xmlTest {
	/**
	 *
	 *  Test unit methode Traitement xml
	 */
	private Traitement_xml xml = null;
	@Before
	public void setUp() throws Exception {
		xml = new Traitement_xml();
	}

	@After
	public void tearDown() throws Exception {
		xml = null;
	}
	@Test
	//Attention cette methode permettant de supprimer une ligne dans le fichier objet.xml
	// donc forcement on aura des erreurs dans la methode Liste_objet
	//public void testReadReplace() {
	//xml.readReplace("./src/media/objet.xml",2);
	//}

	public void testRecherche() {
		xml.recherche("./src/media/objet.xml","titre");
	}

	public void testRe_int() {
		xml.re_int("maison v2");
	}

	@Test
	public void testListe_utilisateur() {
		xml.Liste_utilisateur();
	}

	@Test
	public void testListe_objet() {
		xml.Liste_objet();

	}
	@Test
	public void testIsPhoneNumberCorrect() {
		xml.isPhoneNumberCorrect("0618878120");
	}
	@Test
	public void testrecuper_image() {
		xml.recuper_image("voiture v2");
	}

	public void testrecuper_info_mes_objet() {
		xml.recuper_info_mes_objet("voiture v2");
	}

}
