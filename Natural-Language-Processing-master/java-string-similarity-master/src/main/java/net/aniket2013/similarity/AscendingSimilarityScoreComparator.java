
package net.aniket2013.similarity;

import java.util.Comparator;


public class AscendingSimilarityScoreComparator implements Comparator<SimilarityScore>
{
	
	public int compare(SimilarityScore x, SimilarityScore y) {
		double first = x.getScore();
		double second = y.getScore();
		if (first == second) {
			return 0;
		}
		if (first < second) {
			return -1;
		}
		return 1;
	}
	
}
