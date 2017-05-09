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
import java.time.Duration;
import java.time.Instant;

import java.util.ArrayList;
import java.util.List;

import com.icodejava.research.nlp.domain.NGram;
import com.icodejava.research.nlp.domain.Sentence;
import com.icodejava.research.nlp.ngram.NGramGenerator;

public class NGramService {
    
    public static void main(String args[]) {
        int sentenceLimit = 3000;
        createAndStoreCompleteNGrams(sentenceLimit);

    }

    public static void createAndStoreCompleteNGrams(int sentenceLimit) {
        //Create Complete NGrams
        List<Sentence> sentences = createCompleteNGrams (sentenceLimit);
        // Store the NGrams to the database
        // NGramsDB.insertOrUpdateNGrams(ngrams);

        // mark the sentence as NGRAM extracted.
        // SentenceUnreferencedService.markNGramExtracted(sentences);
    }
    
    public static List<Sentence> createCompleteNGrams(int sentenceLimit) {
        Instant start = Instant.now();

        List<Sentence> sentences = SentenceUnreferencedService.getVerifiedSentencesNgramNotCreated(sentenceLimit);
        
        for(Sentence sentence: sentences) {
        
            List<NGram> ngrams = new ArrayList<NGram>();
            
            /**
             * MONOGRAMS - INCLUDES STOP WORDS
             */
            createMonograms(sentence); 
    
            /**
             * WITH STOP WORDS - USEFUL FOR PREDICING NEXT WORD
             */
            
            createBigramForwardWithStopWord(sentence);
            createBigramBackwardWithStopWord(sentence);
            createTrigramForwardWithStopWord(sentence);
            createTrigramBackwardWithStopWord(sentence);
            createSkipBigramForwardWithStopWord(sentence);
            createSkipBigramBackwardWithStopWord(sentence);
            
            /**
             * WITH NO STOP WORDS - USEFUL FOR PREDICTING CONTEXT
             */
            createBigramForwardWithNoStopWord(sentence);
            createBigramBackwardWithNoStopWord(sentence);
            createTrigramForwardWithNoStopWord(sentence);
            createTrigramBackwardWithNoStopWord(sentence);
            createSkipBigramForwardWithNoStopWord(sentence);
            createSkipBigramBackwardWithNoStopWord(sentence);
            
            
        }
        
        Instant end = Instant.now();
        System.out.println("Time taken to create ngrams: " + Duration.between(start, end));
        
        return sentences;
    }
    
    public static Sentence createBigramBackwardWithNoStopWord(Sentence sentence) {
        StopWordsService.removeStopWords(sentence);
        
        sentence.addNGrams(NGramGenerator.generateBackwardBigramsWithNoStopWords(sentence.getValue()));
            
        return sentence;
    }
    
    public static Sentence createBigramBackwardWithStopWord(Sentence sentence) {
        sentence.addNGrams(NGramGenerator.generateBackwardBigramsWithStopWords(sentence.getValue()));

        return sentence;
    }

    public static Sentence createBigramForwardWithNoStopWord(Sentence sentence) {
    	
    	StopWordsService.removeStopWords(sentence);
    	
        sentence.addNGrams(NGramGenerator.generateForwardBigramsWithNoStopWords(sentence.getValue()));
            
        return sentence;

    }
    
    public static Sentence createBigramForwardWithStopWord(Sentence sentence) {

        sentence.addNGrams(NGramGenerator.generateForwardBigramsWithStopWords(sentence.getValue()));
        return sentence;
    }

    /**
     * Creates a list of monograms from a list of sentences
     * @param sentences
     * @return
     */
    public static Sentence createMonograms(Sentence sentence) {
        
        sentence.addNGrams(NGramGenerator.generateMonograms(sentence.getValue()));
        return sentence;
    }

    /**
     * Creates a SkipBigramBackward and does not contain stop words
     * @param sentences
     * @return
     */
    public static Sentence createSkipBigramBackwardWithNoStopWord(Sentence sentence) {
        StopWordsService.removeStopWords(sentence);
        sentence.addNGrams(NGramGenerator.generateSkipBigramsBackwardWithNoStopWords(sentence.getValue()));
        return sentence;
    }

    /**
     * Creates a SkipBigramBackward and contains stop words
     * @param sentences
     * @return
     */
    public static Sentence createSkipBigramBackwardWithStopWord(Sentence sentence) {
        sentence.addNGrams(NGramGenerator.generateSkipBigramsBackwardWithStopWords(sentence.getValue()));
        return sentence;
    }
    
    /**
     * Creates a SkipBigramForward and does not contain stop words
     * @param sentences
     * @return
     */
    public static Sentence createSkipBigramForwardWithNoStopWord(Sentence sentence) {

        StopWordsService.removeStopWords(sentence);
        sentence.addNGrams(NGramGenerator.generateSkipBigramsForwardWithNoStopWords(sentence.getValue()));
        return sentence;
    }
    
    /**
     * Creates a SkipBigramForward and contains stop words
     * @param sentences
     * @return
     */
    public static Sentence createSkipBigramForwardWithStopWord(Sentence sentence) {

        sentence.addNGrams(NGramGenerator.generateSkipBigramsForwardWithStopWords(sentence.getValue()));
        return sentence;
    }
    
    public static Sentence createTrigramBackwardWithNoStopWord(Sentence sentence) {
        sentence = StopWordsService.removeStopWords(sentence);

        sentence.addNGrams(NGramGenerator.generateBackwardTrigramsWithNoStopWords(sentence.getValue()));

        return sentence;
    }


    public static Sentence createTrigramBackwardWithStopWord(Sentence sentence) {
        sentence.addNGrams(NGramGenerator.generateBackwardTrigramsWithStopWords(sentence.getValue()));

        return sentence;
    }
    
    public static Sentence createTrigramForwardWithNoStopWord(Sentence sentence) {
    	StopWordsService.removeStopWords(sentence);
        sentence.addNGrams(NGramGenerator.generateForwardTrigramsWithNoStopWords(sentence.getValue()));
        return sentence;
    }
    
    public static Sentence createTrigramForwardWithStopWord(Sentence sentence) {
        sentence.addNGrams(NGramGenerator.generateForwardTrigramsWithStopWords(sentence.getValue()));

        return sentence;
    }
    

    /**
     * This method prints the NGrams List to the console
     * @param ngrams
     */
    public static void print(List<NGram> ngrams) {
        for(NGram ngram:ngrams) {
            System.out.println(ngram.getWords() + " [" +ngram.getType().getTag() + "]");
        }
        
    }
}
