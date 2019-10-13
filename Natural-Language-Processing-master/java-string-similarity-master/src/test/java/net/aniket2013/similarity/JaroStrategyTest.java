
package net.aniket2013.similarity;

import static org.junit.Assert.*;
import net.aniket2013.similarity.JaroStrategy;
import net.aniket2013.similarity.SimilarityStrategy;

import org.junit.Test;

public class JaroStrategyTest {

	@Test
	public void testOneTranspostion() {
		SimilarityStrategy s = new JaroStrategy();
		String first = "Martha";
		String second = "Marhta";
		double expected = 0.944;
		double delta = 0.001;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testSoundAlike() {
		SimilarityStrategy s = new JaroStrategy();
		String first = "Dwayne";
		String second = "Duane";
		double expected = 0.822;
		double delta = 0.001;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
		
	}
	
	@Test
	public void testMisspelledSoundAlike() {
		SimilarityStrategy s = new JaroStrategy();
		String first = "Dixon";
		String second = "Dicksonx";
		double expected = 0.767;
		double delta = 0.001;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
		
	}
	
	@Test
	public void testAbsoluteSimilarity() {
		SimilarityStrategy s = new JaroStrategy();
		String first = "Mississippi";
		String second = "Mississippi";
		double expected = 1.000;
		double delta = 0.000;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
	}
	
	@Test
	public void testAbsoluteDissimilarity() {
		SimilarityStrategy s = new JaroStrategy();
		String first = "Mississippi";
		String second = "Oklahoma";
		double expected = 0.000;
		double delta = 0.000;
		double actual = s.score(first, second);
		assertEquals(expected, actual, delta);
	}
	
}
