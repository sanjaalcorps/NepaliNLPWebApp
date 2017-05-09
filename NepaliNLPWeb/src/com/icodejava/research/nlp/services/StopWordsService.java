package com.icodejava.research.nlp.services;

/**
 * Stop Words Service. Provides mechanism to remove stop words from text.
 * @author Kushal Paudyal
 * @created 05/06/2017
 * @modified 05/06/2017
 */
import java.util.List;

import com.icodejava.research.nlp.domain.Sentence;
import com.icodejava.research.nlp.utils.FileUtilities;
import com.icodejava.research.nlp.utils.TextUtils;

public class StopWordsService {

	private static final String STOP_WORDS_LOCATION = "src/com/icodejava/research/nlp/nepali_stop_words.txt";
	private static List<String> stopWords = null;

	public static List<String> loadStopWords() {
		// read unique stop words
		if (stopWords == null) {
			stopWords = FileUtilities.readUTF8FileAsUniqueList(STOP_WORDS_LOCATION);
		}
		return stopWords;

	}

	/**
	 * This method removes stop words from a given sentence
	 * @param sentence
	 * @return
	 */
	public static String removeStopWords(String sentence) {

		for (String stopWord : loadStopWords()) {
			sentence = TextUtils.removeWord(sentence, stopWord);
		}
		
		return sentence;
	}

	/**
	 * This method removes stop words from a list of sentences
	 * @param sentences
	 * @return
	 */
	public static List<Sentence> removeStopWords(List<Sentence> sentences) {
		for(Sentence sentence: sentences) {
			sentence.setValue(removeStopWords(sentence.getValue()));
		}
		
		return sentences;
	}

    public static Sentence removeStopWords(Sentence sentence) {
        sentence.setValue(removeStopWords(sentence.getValue()));
        return sentence;
        
    }
}