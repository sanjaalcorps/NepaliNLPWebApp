package com.icodejava.research.nlp.stemmer;

import com.icodejava.research.nlp.domain.CompoundWordEnding;
import com.icodejava.research.nlp.domain.Grammar;

/**
 * 
 * @author Kushal Paudyal www.sanjaal.com | www.inepal.org | www.icodejava.com
 * 
 *         Stemmer Class for Nepali Word
 * 
 *         Stemming is a process of finding the root word from a compound word.
 *         e.g. "स्थानलगायत" is stemmed to "स्थान"
 *
 */
public class NepaliStemmer {

	/**
	 * This method finds a root word for a given compound Nepali Word. 
	 * For example: "स्थानलगायत" is stemmed to "स्थान"
	 * 
	 * @param compoundWord
	 * @return root word
	 */
	public static String getNepaliRootWord(String compoundWord) {
		for (CompoundWordEnding dir : CompoundWordEnding.values()) {
			String cwe = dir.getNepaliWordEnding();

			if (compoundWord.endsWith(cwe) && compoundWord.length() > cwe.length()) {
				compoundWord = compoundWord.replaceAll(cwe, "");
			}

		}

		compoundWord = compoundWord.trim();

		return compoundWord;
	}

	/**
	 * This method takes a Nepali Word, repalces all the matras and returns the
	 * transformed word. e.g. ट्रान्सफर --> टरनसफर
	 * 
	 * @param word
	 * @return
	 */
	public static String replaceMatras(String word) {

		for (Character c : Grammar.SET_OF_MATRAS.toCharArray()) {
			word = word.replace(c + "", "");
		}

		return word;
	}

}
