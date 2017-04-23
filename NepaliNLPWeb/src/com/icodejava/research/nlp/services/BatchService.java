package com.icodejava.research.nlp.services;
/**
 * 
 * @author Kushal Paudyal
 * 
 * This class contains methods that will potentially take longer time. 
 * 
 * Suitable to run this service (such as over night)
 *
 */
public class BatchService {
	
	public static void main(String [] args) {
		
		//Process Unreferenced Words - Extract Words from Articles
		WordsUnreferencedService.processUnreferencedWords(1000000);
		
		//clean words in the database
		WordsUnreferencedService.cleanWordsInDatabase(0, 1000000);
		
		//cleaning words can always leave duplicates, so remove duplicates. 
		try {
			WordsUnreferencedService.removeDuplication();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Tag Compound Words
		WordsUnreferencedService.tagCompoundWords(500000);
		
		
		//Process Unreferenced Sentences - Extract Sentences From Articles
		
		//clean sentences
		
		//recalculate word count
		//SentenceUnreferencedService.recomputeAndStoreWordCount(20000000);
		
		//Extract Word Linkage
		
		
		
		
		//Process Article Titles
		
	}

}
