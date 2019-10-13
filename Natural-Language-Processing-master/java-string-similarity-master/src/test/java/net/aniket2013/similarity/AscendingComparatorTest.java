

package net.aniket2013.similarity;

import static org.junit.Assert.*;

import net.aniket2013.similarity.AscendingSimilarityScoreComparator;
import net.aniket2013.similarity.SimilarityScore;

import org.junit.Test;

public class AscendingComparatorTest {

	@Test
	public void testCompareScoreFirstGreater() {
		SimilarityScore first = new SimilarityScore("First", 0.87);
		SimilarityScore second = new SimilarityScore("Second", 0.54);
		AscendingSimilarityScoreComparator c = new AscendingSimilarityScoreComparator();
		assertTrue(c.compare(first, second)>0);
		assertTrue(c.compare(second, first)<0);
	}
	
	@Test
	public void testCompareScoreSecondGreater() {
		SimilarityScore first = new SimilarityScore("First", 0.37);
		SimilarityScore second = new SimilarityScore("Second", 0.65);
		AscendingSimilarityScoreComparator c = new AscendingSimilarityScoreComparator();
		assertTrue(c.compare(first, second)<0);
		assertTrue(c.compare(second, first)>0);
	}

	@Test
	public void testCompareScoreEquality() {
		SimilarityScore first = new SimilarityScore("First", 0.96);
		SimilarityScore second = new SimilarityScore("Second", 0.96);
		AscendingSimilarityScoreComparator c = new AscendingSimilarityScoreComparator();
		assertEquals(c.compare(first, second), 0);
		assertEquals(c.compare(second, first), 0);
	}

}
