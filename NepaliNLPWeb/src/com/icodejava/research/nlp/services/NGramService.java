package com.icodejava.research.nlp.services;

import java.util.ArrayList;
import java.util.List;

import com.icodejava.research.nlp.domain.NGram;
import com.icodejava.research.nlp.domain.NGramType;
import com.icodejava.research.nlp.domain.Sentence;
import com.icodejava.research.nlp.ngram.NGramGenerator;
import com.icodejava.research.nlp.tokenizer.NepaliTokenizer;

public class NGramService {

    /*
     * MONOGRAM("M"), BIGRAM_FORWARD_WITH_STOPWORD("BFWS"),
     * BIGRAM_FORWARD_NO_STOPWORD("BFNS"),
     * BIGRAM_BACKWARD_WTIH_STOPWORD("BBWS"),
     * BIGRAM_BACKWARD_NO_STOPWORD("BBNS"),
     * TRIGRAM_FORWARD_WITH_STOPWORD("TBNS"),
     * TRIGRAM_FORWARD_NO_STOPWORD("TFNS"),
     * TRIGRAM_BACKWARD_WITH_STOP_WORD("TBWS"),
     * TRIGRAM_BACKWARD_NO_STOP_WORD("TBNS"),
     * SKIP_BIGRAM_FORWARD_WTIH_STOPWPRD("SBFWS"),
     * SKIP_BIGRAM_FORWARD_NO_STOPWPRD("SBFNS"),
     * SKIP_BIGRAM_BACKWARD_WITH_STOPWORD("SBBWS"),
     * SKIP_BIGRAM_BACKWARD_NO_STOPWORD("SBBNS");
     */

    public static void main(String args[]) {
        int sentenceLimit = 1;

        createCompleteNGrams(sentenceLimit);

    }

    public static void createCompleteNGrams(int sentenceLimit) {

        List<Sentence> sentences = SentenceUnreferencedService.getVerifiedSentencesNgramNotCreated(sentenceLimit);
        System.out.println(sentences);
        List<NGram> ngrams = new ArrayList<NGram>();
        
        //monograms
        ngrams.addAll(createMonograms(sentences));
        
        //bigrams forward and bigrams backward
        ngrams.addAll(createBigramForwardWithStopWord(sentences));
        ngrams.addAll(createBigramBackwardWithStopWord(sentences));
        
        //trigrams forward and trigrams backgward
        ngrams.addAll(createTrigramForwardWithStopWord(sentences));
        ngrams.addAll(createTrigramBackwardWithStopWord(sentences));
        
        ngrams.addAll(createSkipBigramForwardWithStopWord(sentences));
        ngrams.addAll(createSkipBigramBackwardWithStopWord(sentences));
        

        /*        ngrams.addAll(createBigramForwardNoStopWord(sentences));//TODO: complete
        ngrams.addAll(createTrigramForwardNoStopWord(sentences));//TODO: complete
        ngrams.addAll(createSkipBigramForwardNoStopWord(sentences));//TODO: complete
        ngrams.addAll(createSkipBigramBackwardNoStopWord(sentences));//TODO: complete
*/
        
        print(ngrams);
    }

    private static void print(List<NGram> ngrams) {
        for(NGram ngram:ngrams) {
            System.out.println(ngram.getWords() + " [" +ngram.getType().getTag() + "]");
        }
        
    }

    public static List<NGram> createSkipBigramBackwardWithStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateSkipBigramsBackwardNoStopWordRemoved(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
           
        }
        return ngrams;

    }

    public static List<NGram> createSkipBigramForwardWithStopWord(List<Sentence> sentences) {

        List<NGram> ngrams = new ArrayList<NGram>();
        for (Sentence sentence : sentences) {
            List<NGram> ngramsForSentence = NGramGenerator.generateSkipBigramsForwardNoStopWordRemoved(sentence.getValue());
            ngrams.addAll(ngramsForSentence);
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

/*    public static List<NGram> createBigramForwardNoStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();

        return ngrams;

    }*/

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
/*
    public static List<NGram> createSkipBigramBackwardNoStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();

        return ngrams;

    }

    public static List<NGram> createSkipBigramForwardNoStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();

        return ngrams;
    }*/

/*    public static List<NGram> createTrigramForwardNoStopWord(List<Sentence> sentences) {
        List<NGram> ngrams = new ArrayList<NGram>();

        return ngrams;
    }*/

}
