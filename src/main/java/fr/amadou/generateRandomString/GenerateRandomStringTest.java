package fr.amadou.generateRandomString;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenerateRandomStringTest {

	
	
	@Test
	public void testRandomString() {
		GenerateRandomString gen = new GenerateRandomString();
		
		
		System.out.println("gen:" + " " + gen.randomString(10) );
	}

}
