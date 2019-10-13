
package net.aniket2013.similarity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;



public class StringSimilarityServiceImpl implements StringSimilarityService {

	private SimilarityStrategy strategy;


   
    public StringSimilarityServiceImpl(SimilarityStrategy strategy) {
        this.strategy = strategy;
    }

    
    public List<SimilarityScore> scoreAll(List<String> features, String target)
    {
        ArrayList<SimilarityScore> scores = new ArrayList<SimilarityScore>();
        
        for(String feature: features) {
        	double score = strategy.score(feature, target);
        	scores.add(new SimilarityScore(feature, score));
        }
        
        return scores;
    }


    
    public double score(String feature, String target)
    {
        return strategy.score(feature, target);
    }

    
    public SimilarityScore findTop(List<String> features, String target)
    {
    	return findTop(features, target, new DescendingSimilarityScoreComparator());
    }
    
    
    public SimilarityScore findTop(List<String> features, String target, Comparator<SimilarityScore> comparator)
    {
    	if (features.size() == 0) {
    		return null;
    	}
    	List<SimilarityScore> scores= scoreAll(features, target);
    	Collections.sort(scores, comparator);
    	return scores.get(0);
    }
}
