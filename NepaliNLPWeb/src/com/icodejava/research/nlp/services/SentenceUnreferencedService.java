package com.icodejava.research.nlp.services;

import java.util.List;

import com.icodejava.research.nlp.database.ArticlesDB;
import com.icodejava.research.nlp.database.SentencesUnreferencedDB;
import com.icodejava.research.nlp.database.WordsUnreferencedDB;
import com.icodejava.research.nlp.domain.Article;
import com.icodejava.research.nlp.domain.Sentence;
import com.icodejava.research.nlp.tokenizer.NepaliTokenizer;
import com.icodejava.research.nlp.utils.TextUtils;

public class SentenceUnreferencedService {
	
	public static void main (String args []) throws InterruptedException {
		
		//extractUnreferencedSentencesFromArticles(20000);
		//cleanSentences(2000000);
		//updateWordCount(200000);
		
		removeDuplication();
		
		updateSentenceVerification(null);
		getVerifiedSentenceCount();
		
	}
	
	public static int getVerifiedSentenceCount() {
		return SentencesUnreferencedDB.getVerifiedSentenceCount();
		
	}

	public static void updateSentenceVerification(List<Sentence> sentences) {
		for(Sentence sentence: sentences) {
			if(sentence.isMarkedForDeletion()) {
				SentencesUnreferencedDB.deleteRecordsByID(sentence.getId());
			} else if(sentence.getVerified() != null) {
				SentencesUnreferencedDB.updateSentenceVerificationStatus(sentence.getId(), sentence.getVerified());
			}
		}
	}

	private static void removeDuplication() throws InterruptedException {
		SentencesUnreferencedDB.removeDuplicateWords();
		
	}

	private static void updateWordCount(int limit) {
		
		//OPERATE 5000 SETENCES AT A TIME
		int batch = limit / 5000 + 1;
		
		for(int i=0;i<batch; i ++ ) {
		System.out.println("Processing Batch: " + i + " out of " +  batch);	
			//Bring records
			List<Sentence> sentences = SentencesUnreferencedDB.selectRecordsWithNoWordCount(5000);
			
			calculateWordCount(sentences);
			
			SentencesUnreferencedDB.updateSentencesWordCount(sentences);
			
			
			
		}
		
	}

	private static void calculateWordCount(List<Sentence> sentences) {
		for(Sentence sentence: sentences) {
			sentence.setWordCount(TextUtils.countWords(sentence.getValue()));
			//System.out.println("Word Count " + sentence.getWordCount());
		}
		
	}

	private static void extractUnreferencedSentencesFromArticles(int articleLimit) {
		List<Integer> unprocessedArticlesID =  ArticlesDB.selectArticlesUnProcessedSentences(articleLimit);

		int processing = 0;
		for(Integer id: unprocessedArticlesID) {
			
			try{ 
			
			System.out.println("Processing article " + processing++ + " out of " + unprocessedArticlesID.size());
			String articleText = ArticlesDB.selectArticleTextByID(id);
			
			//tokenize 
			List<String> sentences = NepaliTokenizer.tokenizeSentence(articleText, NepaliTokenizer.Terminator.NP);
			
			//then store the sentence to Database
			for(String sentence:sentences) {
				
				SentencesUnreferencedDB.insertSentence(sentence);
			}
			
			
			//WordsLinkedUnreferencedDB.getRowCount(WordsLinkedUnreferencedDB.DATABASE_URL, Tables.WORDS_UNREFERENCED);
			
			//then mark article as processed.
			ArticlesDB.updateArticleMarkAsProcessedForUnreferenceSentences(id);
			
			} catch (Exception e) {
				e.printStackTrace(); //gracefuL
			}
			
		}
		
		//do a second round of cleaning
		//WordsUnreferencedDB.cleanStrangeWords();
		
		//finally print report
		//ReportingService.printUnreferencedSentenceReport();
		
	}
	
	
	private static void cleanSentences(int limit) {
		//Load Titles that are not marked as clean
		List<Sentence> sentences = SentencesUnreferencedDB.selectRecordsWithLimit(limit);
		
		for(Sentence sentence : sentences) {
			
			//System.out.println("Original: " + sentence.getValue());
			
			//clean sentences
			sentence.setValue(NepaliTokenizer.cleanSentence(sentence.getValue()));
			
			//System.out.println("Cleaned: " + sentence.getValue());

		}
		
		//update sentence
		SentencesUnreferencedDB.updateSentences(sentences);
		
		
	}
	

}
