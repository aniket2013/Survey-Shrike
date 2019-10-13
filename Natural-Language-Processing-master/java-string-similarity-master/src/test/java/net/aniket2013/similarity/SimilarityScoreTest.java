

package net.aniket2013.similarity;

import static org.junit.Assert.*;

import net.aniket2013.similarity.SimilarityScore;

import org.junit.Test;

public class SimilarityScoreTest {

	@Test
	public void testGetKey() {
		SimilarityScore s = new SimilarityScore("Test", 0.99);
		assertEquals("Test", s.getKey());
	}

	@Test
	public void testGetScore() {
		SimilarityScore s = new SimilarityScore("Test", 0.99);
		assertEquals(0.99, s.getScore(), 0.000);
		
	}

	
	
}
