package com.icodejava.research.nlp;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlTextExtractor {
	
	public static void main (String args []) throws IOException {
		
		System.out.println(extractTextFromWeb("http://www.majheri.com/taxonomy_vtn/voc/5"));
	}

	public static String extractTextFromWeb(String url) throws IOException {
		Document doc = Jsoup.connect(url).userAgent("Mozilla").timeout(10000).get();
		
		return doc.body().text();
	}

}
