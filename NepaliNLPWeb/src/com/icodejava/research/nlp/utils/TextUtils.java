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
    
    /**
     * Utility method that allows you to replace the last occurence from a string
     * @param string - The String to replace text from
     * @param from - The text that needs to be replaced
     * @param to - The text to be replaced with
     * @return
     */
    public static String replaceLast(String string, String from, String to) {
        int lastIndex = string.lastIndexOf(from);
        if (lastIndex < 0) return string;
        String tail = string.substring(lastIndex).replaceFirst(from, to);
        return string.substring(0, lastIndex) + tail;
   }

}
