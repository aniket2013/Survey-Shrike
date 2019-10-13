
package net.aniket2013.similarity;

import java.util.Comparator;
import java.util.List;


public interface StringSimilarityService {

	    List<SimilarityScore> scoreAll(List<String> features, String target);
	
    
    double score(String feature, String target);

    
    
    SimilarityScore findTop(List<String> features, String target);

    
    SimilarityScore findTop(List<String> features, String target, Comparator<SimilarityScore> comparator);
}
