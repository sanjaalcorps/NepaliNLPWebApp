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

import com.icodejava.research.nlp.domain.NGram;
import com.icodejava.research.nlp.domain.NGramType;
import com.icodejava.research.nlp.services.StopWordsService;
import com.icodejava.research.nlp.tokenizer.NepaliTokenizer;

public class NGramGenerator {

	public static final int LEVEL_BIGRAM = 2;
	public static final int LEVEL_TRIGRAM = 3;
	
	
	public static List<NGram> generateForwardBigramsWithStopWords(String sentence) {
		List<NGram> ngrams = generateForwardNGrams(LEVEL_BIGRAM, sentence);
		
		for(NGram ngram: ngrams) {
		    ngram.setType(NGramType.BIGRAM_FORWARD_WITH_STOPWORDS);
		}
		
		return ngrams;
	}
	
    public static List<NGram> generateForwardTrigramsWithStopWords(String sentence) {

        List<NGram> ngrams = generateForwardNGrams(LEVEL_TRIGRAM, sentence);

        for (NGram ngram : ngrams) {
            ngram.setType(NGramType.TRIGRAM_FORWARD_WITH_STOPWORDS);
        }

        return ngrams;
    }
	
	public static List<NGram> generateBackwardBigramsWithStopWords(String sentence) {
		
        List<NGram> ngrams = generateBackwardNGrams(LEVEL_BIGRAM, sentence);

        for (NGram ngram : ngrams) {
            ngram.setType(NGramType.BIGRAM_BACKWARD_WITH_STOPWORDS);
        }

        return ngrams;
		
	}
	
	public static List<NGram> generateBackwardTrigramsWithStopWords(String sentence) {
	    List<NGram> ngrams = generateBackwardNGrams(LEVEL_TRIGRAM, sentence);

        for (NGram ngram : ngrams) {
            ngram.setType(NGramType.TRIGRAM_BACKWARD_WITH_STOPWORDS);
        }

        return ngrams;
	}
	
	public static List<NGram> generateForwardBigramsWithNoStopWords(String sentence) {
	    
	    sentence = StopWordsService.removeStopWords(sentence);
        List<NGram> ngrams = generateForwardNGrams(LEVEL_BIGRAM, sentence);
        
        for(NGram ngram: ngrams) {
            ngram.setType(NGramType.BIGRAM_FORWARD_NO_STOPWORDS);
        }
        
        return ngrams;
    }
    
    public static List<NGram> generateForwardTrigramsWithNoStopWords(String sentence) {

        sentence = StopWordsService.removeStopWords(sentence);
        List<NGram> ngrams = generateForwardNGrams(LEVEL_TRIGRAM, sentence);

        for (NGram ngram : ngrams) {
            ngram.setType(NGramType.TRIGRAM_FORWARD_NO_STOPWORDS);
        }

        return ngrams;
    }
    
    public static List<NGram> generateBackwardBigramsWithNoStopWords(String sentence) {
        
        sentence = StopWordsService.removeStopWords(sentence);
        List<NGram> ngrams = generateBackwardNGrams(LEVEL_BIGRAM, sentence);

        for (NGram ngram : ngrams) {
            ngram.setType(NGramType.BIGRAM_BACKWARD_NO_STOPWORDS);
        }

        return ngrams;
        
    }
    
    public static List<NGram> generateBackwardTrigramsWithNoStopWords(String sentence) {
        sentence = StopWordsService.removeStopWords(sentence);
        List<NGram> ngrams = generateBackwardNGrams(LEVEL_TRIGRAM, sentence);

        for (NGram ngram : ngrams) {
            ngram.setType(NGramType.TRIGRAM_BACKWARD_NO_STOPWORDS);
        }

        return ngrams;
    }
	
	
	
    /**
     * Given a sentence, this method will return a collection of n (i.e. level) adjacent words
     * 
     * e.g. [This is my] -> [This is, is my] for level 2.
     */
	
    private static List<NGram> generateForwardNGrams(int level, String sentence) {

        List<String> words = Arrays.asList(sentence.split("\\s+"));

        List<NGram> ngrams = new ArrayList<NGram>();

        int levelTemp = level;
        for (int i = 0; i < words.size(); i++) {

            String ngramStr = "";
            while (level > 0 && (i + levelTemp - 1) < words.size()) {
                ngramStr += NepaliTokenizer.cleanWordToken(words.get(i + levelTemp - level)) + " ";
                level--;
            }

            ngramStr = ngramStr.trim();

            if (ngramStr.length() > 0) {
                ngrams.add(new NGram(ngramStr));
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
	
	private static List<NGram> generateBackwardNGrams(int level, String sentence) {

		//generate regular n-gram
		List<NGram> ngrams = generateForwardNGrams(level, sentence);
		
		List<NGram> backwardsNgrams = new ArrayList<NGram>(); 
		
		//reverse words
		for(NGram ngram: ngrams) {
			
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
	
	/**
     * Recursively reverses a sentence
     * @param sentence
     * @return
     */
    public static NGram reverse(NGram ngram) {
           String words = ngram.getWords();
           int k = words.indexOf(" ");
           String reversedWords =  k == -1 ? words : reverse(words.substring(k + 1)) + " " + words.substring(0, k);
           
           ngram.setWords(reversedWords);
           
           return ngram;
           
    }
	
	/**
	 * Returns Forward Skip Bigrams with no stop words removed
	 * @param sentence
	 * @return
	 */
	public static List<NGram> generateSkipBigramsForwardWithStopWords(String sentence) {

		List<String> words = Arrays.asList(sentence.split("\\s+"));
		List<NGram> skipBigrams = new ArrayList<NGram>();
		for (int i = 0; i < words.size(); i++) {

			if (words.size() > i + 2) {
			    String text = NepaliTokenizer.cleanWordToken(words.get(i)) + " " + NepaliTokenizer.cleanWordToken(words.get(i + 2));
			    
			    //System.out.println(text +" <--" + words.get(i) +" " + words.get(i+2));
				skipBigrams.add(new NGram(text, NGramType.SKIP_BIGRAM_FORWARD_WITH_STOPWORDS));
			}

		}
		return skipBigrams;
	}

	/**
	 * Returns Backward Skip Bigram with no stop words removed
	 * @param sentence
	 * @return
	 */
	public static List<NGram> generateSkipBigramsBackwardWithStopWords(String sentence) {

		List<String> words = Arrays.asList(sentence.split("\\s+"));
		List<NGram> skipBigrams = new ArrayList<NGram>();
		for (int i = words.size() - 1; i >= 0; i--) {

			if (i - 2 >= 0) {
			    String text = NepaliTokenizer.cleanWordToken(words.get(i)) + " " + NepaliTokenizer.cleanWordToken(words.get(i - 2));
			    
				skipBigrams.add(new NGram(text, NGramType.SKIP_BIGRAM_BACKWARD_WITH_STOPWORDS));
			}
		}

		return skipBigrams;

	}
	
	/**
	 * Returns Forward Skip Bigrams with stop words removed
	 * @param sentence
	 * @return
	 */
	public static List<NGram> generateSkipBigramsForwardWithNoStopWords(String sentence) {

		List<String> words = Arrays.asList(sentence.split("\\s+"));
		List<NGram> skipBigrams = new ArrayList<NGram>();
		for (int i = 0; i < words.size(); i++) {

			if (words.size() > i + 2) {
			    String text = NepaliTokenizer.cleanWordToken(words.get(i)) + " " + NepaliTokenizer.cleanWordToken(words.get(i + 2));
				skipBigrams.add(new NGram(text, NGramType.SKIP_BIGRAM_FORWARD_NO_STOPWORDS));
			}

		}
		return skipBigrams;

	}

	/**
	 * Returns Backward Skip Bigram with stop words removed
	 * @param sentence
	 * @return
	 */
	public static List<NGram> generateSkipBigramsBackwardWithNoStopWords(String sentence) {

		List<String> words = Arrays.asList(sentence.split("\\s+"));
		List<NGram> skipBigrams = new ArrayList<NGram>();
		for (int i = words.size() - 1; i >= 0; i--) {

			if (i - 2 >= 0) {
			    String text = NepaliTokenizer.cleanWordToken(words.get(i)) + " " + NepaliTokenizer.cleanWordToken(words.get(i - 2));
			    
				skipBigrams.add(new NGram(text, NGramType.SKIP_BIGRAM_BACKWARD_NO_STOPWORDS));
			}
		}

		return skipBigrams;

	}

	/**
	 * Creates a list of words (MONOGRAMS) from sentence. Does not remove any stop words.
	 * @param sentence
	 * @return
	 */
    public static List<NGram> generateMonograms(String sentence) {
        List<NGram> ngrams = new ArrayList<NGram>();

        List<String> words = NepaliTokenizer.tokenizeWords(sentence);

        for (String wordStr : words) {
            NGram ngram = new NGram(wordStr);
            ngram.setType(NGramType.MONOGRAM);

            ngrams.add(ngram);
        }

        return ngrams;
    }

}
