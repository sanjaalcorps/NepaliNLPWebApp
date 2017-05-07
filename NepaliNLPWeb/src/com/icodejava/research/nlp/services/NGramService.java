package com.icodejava.research.nlp.services;

/**
 * @author Kushal Paudyal
 * www.icodejava.com | www.inepal.org| www.sanjaal.com
 * Service class to generate NGrams for Sentences.
 * The following NGRAMS are supported. 
 * - Monograms (Also known as Bag of Words)
 * - Forward/Backward Bigrams with/without stop words
 * - Forward/Backward Trigrams with/without stop words
 * - Forward/Backward Skip Bigrams with/without stop words
 * 
 * Refer to NGramType.java for these types
 */
import java.util.ArrayList;
import java.util.List;

import com.icodejava.research.nlp.database.NGramsDB;
import com.icodejava.research.nlp.domain.NGram;
import com.icodejava.research.nlp.domain.NGramType;
import com.icodejava.research.nlp.domain.Sentence;
import com.icodejava.research.nlp.ngram.NGramGenerator;
import com.icodejava.research.nlp.tokenizer.NepaliTokenizer;

public class NGramService {

    public static void main(String args[]) {
        int sentenceLimit = 50;
        createCompleteNGrams(sentenceLimit);

    }
    
    public static void createCompleteNGrams(int sentenceLimit) {

        // OPERATE 500 SETENCES AT A TIME
        int perBatch = 500;
        int batch = sentenceLimit / perBatch + 1;

        for (int i = 0; i < batch; i++) {
            System.out.println("Processing Batch: " + i + " out of " + batch);

            List<Sentence> sentences = SentenceUnreferencedService.getVerifiedSentencesNgramNotCreated((sentenceLimit > perBatch) ? perBatch:sentenceLimit);

            //System.out.println(sentences);

            List<NGram> ngrams = new ArrayList<NGram>();
            // monograms
            ngrams.addAll(createMonograms(sentences)); // TODO: might be good idea to do this in batch.

            /**
             * WITH STOP WORDS - USEFUL FOR PREDICING NEXT WORD
             */
            ngrams.addAll(createBigramForwardWithStopWord(sentences));
            ngrams.addAll(createBigramBackwardWithStopWord(sentences));
            ngrams.addAll(createTrigramForwardWithStopWord(sentences));
            ngrams.addAll(createTrigramBackwardWithStopWord(sentences));
            ngrams.addAll(createSkipBigramForwardWithStopWord(sentences));
            ngrams.addAll(createSkipBigramBackwardWithStopWord(sentences));
            
            /**
             * WITH NO STOP WORDS - USEFUL FOR PREDICTING CONTEXT
             */
            ngrams.addAll(createBigramForwardWithNoStopWord(sentences));
            ngrams.addAll(createBigramBackwardWithNoStopWord(sentences));
            ngrams.addAll(createTrigramForwardWithNoStopWord(sentences));
            ngrams.addAll(createTrigramBackwardWithNoStopWord(sentences));
            ngrams.addAll(createSkipBigramForwardWithNoStopWord(sentences));
            ngrams.addAll(createSkipBigramBackwardWithNoStopWord(sentences));
            
            // Store to database
            NGramsDB.insertOrUpdateNGrams(ngrams);
            
            // mark the sentence as NGRAM extracted.
            SentenceUnreferencedService.markNGramExtracted(sentences);
        }
    }

    public static List<NGram> createBigramBackwardWithStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateBackwardBigrams(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
            
            for(NGram ngram: ngrams) {
                ngram.setType(NGramType.BIGRAM_BACKWARD_NO_STOPWORD_REMOVED);
            }
        }
        return ngrams;
    }
    
    public static List<NGram> createBigramBackwardWithNoStopWord(List<Sentence> sentences) {
    	sentences = StopWordsService.removeStopWords(sentences);
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateBackwardBigrams(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
            
            for(NGram ngram: ngrams) {
                ngram.setType(NGramType.BIGRAM_BACKWARD_WTIH_STOPWORD_REMOVED);
            }
            
        }
        return ngrams;
    }

    public static List<NGram> createBigramForwardWithNoStopWord(List<Sentence> sentences) {
    	
    	sentences = StopWordsService.removeStopWords(sentences);
    	
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateForwardBigrams(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
            
            for(NGram ngram: ngrams) {
                ngram.setType(NGramType.BIGRAM_FORWARD_WITH_STOPWORD_REMOVED);
            }
            
        }
        return ngrams;

    }

    public static List<NGram> createBigramForwardWithStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateForwardBigrams(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
            
            for(NGram ngram: ngrams) {
                ngram.setType(NGramType.BIGRAM_FORWARD_NO_STOPWORD_REMOVED);
            }
        }
        return ngrams;
    }

    /**
     * Creates a list of monograms from a list of sentences
     * @param sentences
     * @return
     */
    public static List<NGram> createMonograms(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();
        
        for(Sentence sentence: sentences) {
            List<String> words = NepaliTokenizer.tokenizeWords(sentence.getValue());
            
            for(String wordStr: words) {
                NGram ngram = new NGram(wordStr);
                ngram.setType(NGramType.MONOGRAM);
                
                ngrams.add(ngram);
            }
        }
        
        return ngrams;
    }

    /**
     * Creates a SkipBigramBackward and contains stop words
     * @param sentences
     * @return
     */
    public static List<NGram> createSkipBigramBackwardWithStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateSkipBigramsBackwardNoStopWordRemoved(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
        }
        return ngrams;
    }
    
    /**
     * Creates a SkipBigramForward and contains stop words
     * @param sentences
     * @return
     */
    public static List<NGram> createSkipBigramForwardWithStopWord(List<Sentence> sentences) {

        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateSkipBigramsForwardNoStopWordRemoved(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
        }
        return ngrams;
    }
    
    /**
     * Creates a SkipBigramBackward and does not contain stop words
     * @param sentences
     * @return
     */
    public static List<NGram> createSkipBigramBackwardWithNoStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateSkipBigramsBackwardWithStopWordRemoved(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
        }
        return ngrams;
    }
    
    /**
     * Creates a SkipBigramForward and does not contain stop words
     * @param sentences
     * @return
     */
    public static List<NGram> createSkipBigramForwardWithNoStopWord(List<Sentence> sentences) {

        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateSkipBigramsForwardWithStopWordRemoved(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
        }
        return ngrams;
    }


    public static List<NGram> createTrigramBackwardWithStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateBackwardTrigrams(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
            
            for(NGram ngram: ngrams) {
                ngram.setType(NGramType.TRIGRAM_BACKWARD_NO_STOPWORD_REMOVED);
            }
        }
        return ngrams;
    }
    
    public static List<NGram> createTrigramBackwardWithNoStopWord(List<Sentence> sentences) {
    	sentences = StopWordsService.removeStopWords(sentences);
    	List<NGram> ngrams = new ArrayList<NGram>();
    	for (Sentence sentence : sentences) {
    		List<NGram> ngramsForSentence = NGramGenerator.generateBackwardTrigrams(sentence.getValue());
    		ngrams.addAll(ngramsForSentence);
    		
    		for(NGram ngram: ngrams) {
    			ngram.setType(NGramType.TRIGRAM_BACKWARD_WITH_STOPWORD_REMOVED);
    		}
    	}
    	return ngrams;
    }
    
    public static List<NGram> createTrigramForwardWithStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateForwardTrigrams(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
            
            for(NGram ngram: ngrams) {
                ngram.setType(NGramType.TRIGRAM_FORWARD_NO_STOPWORD_REMOVED);
            }
        }
        return ngrams;
    }
    
    public static List<NGram> createTrigramForwardWithNoStopWord(List<Sentence> sentences) {
    	sentences = StopWordsService.removeStopWords(sentences);
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateForwardTrigrams(sentence.getValue());
            ngrams.addAll(ngramsForSentence);

            for(NGram ngram: ngrams) {
                ngram.setType(NGramType.TRIGRAM_FORWARD_WITH_STOPWORD_REMOVED);
            }
        }
        return ngrams;
    }

    /**
     * This method prints the NGrams List to the console
     * @param ngrams
     */
    private static void print(List<NGram> ngrams) {
        for(NGram ngram:ngrams) {
            System.out.println(ngram.getWords() + " [" +ngram.getType().getTag() + "]");
        }
        
    }
}
