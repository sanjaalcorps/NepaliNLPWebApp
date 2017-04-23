package com.icodejava.research.nlp.services;

import java.util.Map;

import com.icodejava.research.nlp.database.ArticlesDB;
import com.icodejava.research.nlp.database.Tables;
import com.icodejava.research.nlp.database.WebsitesDB;
import com.icodejava.research.nlp.database.WordsUnreferencedDB;

public class ReportingService {
	
	public static void main (String args []) {
		//printReportOnConsole();
		//System.out.println(getHTMLReport());
	}

	private static void printReportOnConsole() {
		System.out.println(getReport());
		
	}

	public static String getHTMLReport() {
		
		String report = getReport().toString();
		report=report.replace("\n", "<br/>");
		
		return report;
		
	}

	public static StringBuffer getReport() {
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer = printRowCountStatus(stringBuffer);
		stringBuffer = printCrawlStatus(stringBuffer);
		stringBuffer = printUnreferencedWordReport(stringBuffer);
//		stringBuffer = printUnreferencedSentenceReport(stringBuffer);
//		stringBuffer = printArticleTitleInfo(stringBuffer);
//		stringBuffer = printCompoundWords(stringBuffer);
		
		return stringBuffer;
	}


	private static void printCompoundWords() {
		WordsUnreferencedService.printCompoundWords();
		WordsUnreferencedService.printCompoundWordsNotTagged();
		WordsUnreferencedService.printCompoundWordsNotTaggedCount();
		
	}


	public static StringBuffer printCrawlStatus(StringBuffer stringBuffer) {
		stringBuffer.append("Crawled Sites Count: " + WebsitesDB.getCrawledSitesCount());
		stringBuffer.append("\n");
		stringBuffer.append("Uncralwed Sites Count: " + WebsitesDB.getUncrawledSitesCount());
		stringBuffer.append("\n");
		
		Map<String, Integer> countMap = WebsitesDB.getRowCountByDomainUncrawled();
		
		for(String key:countMap.keySet()) {
			
			stringBuffer.append(key +" ("+countMap.get(key)+")");
			stringBuffer.append("\n");
		}
		
		return stringBuffer;
		
	}


	public static StringBuffer printRowCountStatus(StringBuffer stringBuffer) {
		stringBuffer.append(WebsitesDB.getRowCountByDomain());
		int rowCount = WebsitesDB.getRowCount(Tables.WEBSITES);
		stringBuffer.append("============Total Row Count in "+Tables.WEBSITES+" table: " + rowCount +"\n\n");
		
		return stringBuffer;
	}
	
	
	public static StringBuffer printUnreferencedWordReport(StringBuffer stringBuffer) {
		stringBuffer.append("\n");
		stringBuffer.append("========================================");
		stringBuffer.append("\n");
		stringBuffer.append("Total Articles in the Database: " + ArticlesDB.getArticlesCount());
		
		stringBuffer.append("\n");
		stringBuffer.append("Total Articles Processed for extracing Unreferenced Words: " + ArticlesDB.getArticlesCount_ProcessedForUnreferenceWord());
		
		stringBuffer.append("\n");
		int rowCount = WordsUnreferencedDB.getRowCount(WordsUnreferencedDB.DATABASE_URL,Tables.WORDS_UNREFERENCED);
		stringBuffer.append("Total Row Count in "+Tables.WORDS_UNREFERENCED+" table " + rowCount);
		
		return stringBuffer;
		
	}
	
	public static void printUnreferencedSentenceReport() {
		System.out.println("\n========================================");
		ArticlesDB.getArticlesCount();
		ArticlesDB.selectArticlesCountProcessedForUnreferenceSentence();
		WordsUnreferencedDB.getRowCount(WordsUnreferencedDB.DATABASE_URL,Tables.WORDS_UNREFERENCED);
		
	}
	
	public static void printArticleTitleInfo() {
		ArticlesDB.selectArticlesWithTitlesCount();
		ArticlesDB.selectArticlesWithoutTitlesCount();
		ArticlesDB.selectTitlesMarkedAsClean_count();
	}

}
