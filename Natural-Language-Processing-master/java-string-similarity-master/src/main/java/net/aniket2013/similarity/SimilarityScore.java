
package net.aniket2013.similarity;


public class SimilarityScore {
	
	private String key;
	private double score;
	
	

	public SimilarityScore(String key, double score) {
		this.key = key;
		this.score = score;
	}
	
	
	public String getKey() {
		return this.key;
	}
	
	
	public double getScore() {
		return this.score;
	}

	
	
	public int hashCode() {
		int hash = 11;
		hash = 23 * hash + key.hashCode(); 
		hash = 23 * hash + (int)(score * 1000000);
		return hash;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if((o == null) || (o.getClass() != this.getClass())) {
			return false; 
		}
		SimilarityScore other=(SimilarityScore)o;
		
		return this.key.equals(other.key)
					&& this.score == other.score;
	}
	
	
}
