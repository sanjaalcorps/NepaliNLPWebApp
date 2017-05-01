package com.icodejava.research.nlp.utils;
import java.util.Arrays;
import java.util.List;
/**
 * @author Kushal Paudyal
 * General Text Utility Class providing various functionalities.
 * 
 * Created On: 4/11/2017
 * Last Modified On: 4/30/2017
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
    
    /**
     * Recursively reverses a sentence
     * @param sentence
     * @return
     */
    public static String reverse(String sentence) {
           int k = sentence.indexOf(" ");
           return k == -1 ? sentence : reverse(sentence.substring(k + 1)) + " " + sentence.substring(0, k);
    }
    
    /**
     * This method removes a specific word (not words) from a given text.
     * @param text
     * @param wordToRemove
     * @return
     */
    public static String removeWord(String text, String wordToRemove) {

        if (text == null || wordToRemove == null) {
            return text;
        }

        List<String> words = Arrays.asList(text.split("\\s+"));
        String modifiedText = "";

        for (String word: words) {
            if (wordToRemove.equals(word)) {
                continue;
            } else {
                modifiedText += word + " ";
            }
        }
        
        //Remove extra space at the end
        modifiedText = modifiedText.trim();

        return modifiedText;

    }

}
