

package net.aniket2013.similarity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import net.aniket2013.similarity.AscendingSimilarityScoreComparator;
import net.aniket2013.similarity.DescendingSimilarityScoreComparator;
import net.aniket2013.similarity.SimilarityScore;
import net.aniket2013.similarity.SimilarityStrategy;
import net.aniket2013.similarity.StringSimilarityService;
import net.aniket2013.similarity.StringSimilarityServiceImpl;

import org.junit.Test;


public class StringSimilarityServiceImplTest {

	
	@Test
	public void testScoreAll() {
		SimilarityStrategy strategy = mock(SimilarityStrategy.class);
		String target = "McDonalds";
		String c1 = "MacMahons";
		String c2 = "McPherson";
		String c3 = "McDonalds";
		
		when(strategy.score(target, c1)).thenReturn(0.90);
		when(strategy.score(target, c2)).thenReturn(0.74);
		when(strategy.score(target, c3)).thenReturn(1.000);
		
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		List<String> features = new ArrayList<String>();
		features.add(c1);
		features.add(c2);
		features.add(c3);
		
		List<SimilarityScore> scores = service.scoreAll(features, target);
		verify(strategy).score(c1, target);
		verify(strategy).score(c2, target);
		verify(strategy).score(c3, target);
		assertEquals(3, scores.size());
	}

	@Test
	public void testScore() {
		SimilarityStrategy strategy = mock(SimilarityStrategy.class);
		String target = "McDonalds";
		String c1 = "MacMahons";
		String c2 = "McPherson";
		String c3 = "McDonalds";
		
		when(strategy.score(c1, target)).thenReturn(0.90);
		when(strategy.score(c2, target)).thenReturn(0.74);
		when(strategy.score(c3, target)).thenReturn(1.000);
		
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		
		double score = service.score(c1, target);
		verify(strategy).score(c1, target);
		assertEquals(0.90, score, 0.000);
		
	}

	@Test 
	public void testFindTop() {
		SimilarityStrategy strategy = mock(SimilarityStrategy.class);
		String target = "McDonalds";
		String c1 = "MacMahons";
		String c2 = "McPherson";
		String c3 = "McDonalds";
		
		SimilarityScore expected = new SimilarityScore(c3, 1.000);
		
		when(strategy.score(c1, target)).thenReturn(0.90);
		when(strategy.score(c2, target)).thenReturn(0.74);
		when(strategy.score(c3, target)).thenReturn(1.000);
		
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		List<String> features = new ArrayList<String>();
		features.add(c1);
		features.add(c2);
		features.add(c3);
		
		SimilarityScore top= service.findTop(features,target);
		verify(strategy).score(c1, target);
		verify(strategy).score(c2, target);
		verify(strategy).score(c3, target);
		assertEquals(expected, top);
		
	}
	
	@Test 
	public void testFindTop_Ascending() {
		SimilarityStrategy strategy = mock(SimilarityStrategy.class);
		String target = "McDonalds";
		String c1 = "MacMahons";
		String c2 = "McPherson";
		String c3 = "McDonalds";
		
		SimilarityScore expected = new SimilarityScore(c2, 0.74);
		
		when(strategy.score(c1, target)).thenReturn(0.90);
		when(strategy.score(c2, target)).thenReturn(0.74);
		when(strategy.score(c3, target)).thenReturn(1.000);
		
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		List<String> features = new ArrayList<String>();
		features.add(c1);
		features.add(c2);
		features.add(c3);
		
		AscendingSimilarityScoreComparator comparator = new AscendingSimilarityScoreComparator();
		SimilarityScore top= service.findTop(features,target, comparator);
		verify(strategy).score(c1, target);
		verify(strategy).score(c2, target);
		verify(strategy).score(c3, target);
		assertEquals(expected, top);
	}
	
	@Test 
	public void testFindTop_Descending() {
		SimilarityStrategy strategy = mock(SimilarityStrategy.class);
		String target = "McDonalds";
		String c1 = "MacMahons";
		String c2 = "McPherson";
		String c3 = "McDonalds";
		
		SimilarityScore expected = new SimilarityScore(c3, 1.000);
		
		when(strategy.score(c1, target)).thenReturn(0.90);
		when(strategy.score(c2, target)).thenReturn(0.74);
		when(strategy.score(c3, target)).thenReturn(1.000);
		
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		List<String> features = new ArrayList<String>();
		features.add(c1);
		features.add(c2);
		features.add(c3);
		
		DescendingSimilarityScoreComparator comparator = new DescendingSimilarityScoreComparator();
		SimilarityScore top= service.findTop(features,target, comparator);
		verify(strategy).score(c1, target);
		verify(strategy).score(c2, target);
		verify(strategy).score(c3, target);
		assertEquals(expected, top);
		
	}
}
