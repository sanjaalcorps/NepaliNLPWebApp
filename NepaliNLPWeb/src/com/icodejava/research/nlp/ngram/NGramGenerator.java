package com.icodejava.research.nlp.ngram;
/**
 * @author Kushal Paudyal
 * www.sanjaal.com | www.icodejava.com | www.inepal.org
 * 
 * This class can be used to generate n-grams (bi, tri etc) as well as forward and backward skipgrams
 * 
 * Created on: 2017/04/24
 * Last Modified On: 2017/04/24
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.icodejava.research.nlp.tokenizer.NepaliTokenizer;

public class NGramGenerator {

	public static final int LEVEL_BIGRAM = 2;
	public static final int LEVEL_TRIGRAM = 3;
	
	
	public static List<String> generateForwardBigrams(String sentence) {
		return generateForwardNGrams(LEVEL_BIGRAM, sentence);
	}
	
	public static List<String> generateForwardTrigrams(String sentence) {
		return generateForwardNGrams(LEVEL_TRIGRAM, sentence);
	}
	
	public static List<String> generateBackwardBigrams(String sentence) {
		return generateBackwardNGrams(LEVEL_BIGRAM, sentence);
	}
	
	public static List<String> generateBackwardTrigrams(String sentence) {
		return generateBackwardNGrams(LEVEL_TRIGRAM, sentence);
	}
	
	
	
    /**
     * Given a sentence, this method will return a collection of n (i.e. level) adjacent words
     * 
     * e.g. [This is my] -> [This is, is my] for level 2.
     */
	
	public static List<String> generateForwardNGrams(int level, String sentence) {

		List<String> words = Arrays.asList(sentence.split("\\s+"));

		List<String> ngrams = new ArrayList<String>();

		int levelTemp = level;
		for (int i = 0; i < words.size(); i++) {

			String ngram = "";
			while (level > 0 && (i + levelTemp - 1) < words.size()) {
				ngram += NepaliTokenizer.cleanWordToken(words.get(i + levelTemp - level)) + " ";
				level--;
			}

			ngram = ngram.trim();

			if (ngram.length() > 0) {
				ngrams.add(ngram);
			}

			// restore
			level = levelTemp;
		}
		return ngrams;

	}
	
	/**
     * Given a sentence, this method will return a collection of n (i.e. level) adjacent words but in backward order
     * 
     * e.g. [This is my book] -> [book my, my is, is this] for level 2.
     */
	
	public static List<String> generateBackwardNGrams(int level, String sentence) {

		//generate regular n-gram
		List<String> ngrams = generateForwardNGrams(level, sentence);
		
		List<String> backwardsNgrams = new ArrayList<String>(); 
		
		//reverse words
		for(String ngram: ngrams) {
			
			ngram = reverse(ngram);
			
			backwardsNgrams.add(ngram);
		}
		
		
		return backwardsNgrams;

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
	
	public static List<String> generateSkipBigramsForward(String sentence) {

		List<String> words = Arrays.asList(sentence.split("\\s+")); // split
																	// sentence
																	// into
																	// tokens

		List<String> skipBigrams = new ArrayList<String>();
		for (int i = 0; i < words.size(); i++) {

			if (words.size() > i + 2) {
				skipBigrams.add(new String(words.get(i) + " " + words.get(i + 2)));
			}

		}
		return skipBigrams;

	}

	public static List<String> generateSkipBigramsBackward(String sentence) {

		List<String> words = Arrays.asList(sentence.split("\\s+")); // split
																	// sentence
																	// into
																	// tokens

		List<String> skipBigrams = new ArrayList<String>();
		for (int i = words.size() - 1; i >= 0; i--) {

			if (i - 2 >= 0) {
				skipBigrams.add(new String(words.get(i) + " " + words.get(i - 2)));
			}
		}

		return skipBigrams;

	}

}
