package com.icodejava.research.nlp.utils;
/**
 * @author Kushal Paudyal
 * General Text Utility Class providing various functionalities.
 * 
 * Created On: 4/11/2017
 * Last Modified On: 4/11/2017
 */
import java.util.StringTokenizer;

public class TextUtils {
	/**
	 * Given a text, returns a count of words in it.
	 * Uses standard StringTokenizer class
	 * @param text
	 * @return
	 */
    public static int countWords(String text) {
    	if(text == null) {
    		return 0;
    	}

        StringTokenizer st = new StringTokenizer(text);
        int count = st.countTokens();

        return count;

    }

}
