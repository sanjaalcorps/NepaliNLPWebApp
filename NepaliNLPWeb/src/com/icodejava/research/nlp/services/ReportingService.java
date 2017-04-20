package com.icodejava.research.nlp.services;

import com.icodejava.research.nlp.database.ArticlesDB;
import com.icodejava.research.nlp.database.Tables;
import com.icodejava.research.nlp.database.WebsitesDB;
import com.icodejava.research.nlp.database.WordsUnreferencedDB;

public class ReportingService {
	
	public static void main (String args []) {
		
		printRowCountStatus();
		printCrawlStatus();
		//printUnreferencedWordReport();
		//printUnreferencedSentenceReport();
		//printArticleTitleInfo();
		
		printCompoundWords();
	}


	private static void printCompoundWords() {
		WordsUnreferencedService.printCompoundWords();
		WordsUnreferencedService.printCompoundWordsNotTagged();
		WordsUnreferencedService.printCompoundWordsNotTaggedCount();
		
	}


	public static void printCrawlStatus() {
		WebsitesDB.printCrawledSitesCount();
		WebsitesDB.printUncrawledSitesCount();
		WebsitesDB.printRowCountByDomainUncrawled();
	}


	public static void printRowCountStatus() {
		WebsitesDB.printRowCountByDomain();
		WebsitesDB.getRowCount(Tables.WEBSITES);
	}
	
	
	public static void printUnreferencedWordReport() {
		System.out.println("\n========================================");
		ArticlesDB.selectArticlesCount();
		ArticlesDB.selectArticlesCountProcessedForUnreferenceWord();
		WordsUnreferencedDB.getRowCount(WordsUnreferencedDB.DATABASE_URL,Tables.WORDS_UNREFERENCED);
		
	}
	
	public static void printUnreferencedSentenceReport() {
		System.out.println("\n========================================");
		ArticlesDB.selectArticlesCount();
		ArticlesDB.selectArticlesCountProcessedForUnreferenceSentence();
		WordsUnreferencedDB.getRowCount(WordsUnreferencedDB.DATABASE_URL,Tables.WORDS_UNREFERENCED);
		
	}
	
	public static void printArticleTitleInfo() {
		ArticlesDB.selectArticlesWithTitlesCount();
		ArticlesDB.selectArticlesWithoutTitlesCount();
		ArticlesDB.selectTitlesMarkedAsClean_count();
	}

}
