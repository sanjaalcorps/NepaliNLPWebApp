package com.icodejava.research.nlp.services;

import java.util.List;

import com.icodejava.research.nlp.database.ArticlesDB;
import com.icodejava.research.nlp.domain.Article;
import com.icodejava.research.nlp.tokenizer.NepaliTokenizer;

public class ArticleService {
	
	
	public static void main (String args []) {
		//cleanTitles(200000);
		
		ArticlesDB.selectDistinctTitles();
	}

	private static void cleanTitles(int limit) {
		//Load Titles that are not marked as clean
		//List<Article> articles = ArticlesDB.selectTitlesNotMarkedAsClean(limit);
		List<Article> articles = ArticlesDB.selectTitles(limit);
		
		
		for(Article article : articles) {
			
			
			//clean titles
			
			String title = article.getTitle();
			
			//System.out.println("Original: " + title);
			
			title = NepaliTokenizer.cleanTitles(title);
			
			//System.out.println("Cleaned: " + title);
			
			//update titles, also update the title_clean flag
			ArticlesDB.updateArticleTitle(article.getId(),title);
			
			

		}
		
		
	}

}
