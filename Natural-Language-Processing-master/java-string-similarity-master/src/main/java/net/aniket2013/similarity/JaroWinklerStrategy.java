
package net.aniket2013.similarity;


public class JaroWinklerStrategy extends JaroStrategy implements SimilarityStrategy {
	final double DEFAULT_SCALING_FACTOR = 0.1;  // This is the default scaling factor Winkler used.

    private double scalingFactor;
    
    
    public JaroWinklerStrategy(double scalingFactor)
    {
        if (scalingFactor > 0.25)
        {
            scalingFactor = 0.25;    
        }
        this.scalingFactor = scalingFactor;
    }

   
    public JaroWinklerStrategy()
    {
        this.scalingFactor = DEFAULT_SCALING_FACTOR;
    }

        public double score(String first, String second)
    {
        double jaro = super.score(first, second);

        int cl = commonPrefixLength(first, second);

        // The Jaro–Winkler distance uses a prefix scale which gives more favorable ratings
        // to strings that match from the beginning for a set prefix length.
        double winkler = jaro + (scalingFactor * cl * (1.0 - jaro));

        return winkler;

    }

    
    private int commonPrefixLength(String first, String second)
    {
        String shorter;
        String longer;

        // Determine which string is longer.
        if (first.length() > second.length())
        {
            longer = first.toLowerCase();
            shorter = second.toLowerCase();
        }
        else
        {
            longer = second.toLowerCase();
            shorter = first.toLowerCase();
        }

        int result = 0;

        // Iterate through the shorter string.
        for (int i = 0; i < shorter.length(); i++)
        {
            if (shorter.charAt(i) != longer.charAt(i))
            {
                break;
            }
            result++;
        }

        // Limit the result to 4.
        return result > 4? 4: result;
    }

	
}
