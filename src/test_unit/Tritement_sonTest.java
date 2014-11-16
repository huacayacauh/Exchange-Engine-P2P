package test_unit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import traitement_son.Tritement_son;

public class Tritement_sonTest {
private Tritement_son son=null;
	@Before
	public void setUp() throws Exception {
		son=  new Tritement_son();
	}

	@After
	public void tearDown() throws Exception {
		son=null;
	}

	@Test
	public void testRun() {
		son.run();
	}

}
