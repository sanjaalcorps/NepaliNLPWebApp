package com.icodejava.research.nlp.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.icodejava.research.nlp.ParseURL;
import com.icodejava.research.nlp.database.WebsitesDB;

public class LinksInsertService {
	
	static String domains [] = new String [] {
			/*"src/com/icodejava/research/nlp/sources/hamrakura.txt",
			"src/com/icodejava/research/nlp/sources/karobardaily.txt",
			"src/com/icodejava/research/nlp/sources/mysansar.txt",
			"src/com/icodejava/research/nlp/sources/nagariknews.txt",
			"src/com/icodejava/research/nlp/sources/nepalihimal.txt",
			"src/com/icodejava/research/nlp/sources/onlinekhabar.txt",
			"src/com/icodejava/research/nlp/sources/samakalinsahitya.txt",
			"src/com/icodejava/research/nlp/sources/setopati.txt",
			"src/com/icodejava/research/nlp/sources/tokyonepal.txt",
			"src/com/icodejava/research/nlp/sources/wikipedia_ne.txt",
			"src/com/icodejava/research/nlp/sources/dainiknepal.txt",
			"src/com/icodejava/research/nlp/sources/swasthyakhabar.txt",*/
			"src/com/icodejava/research/nlp/sources/kantipur.txt"
			
	};
	
	public static void main (String args []) throws IOException {
		insertWebLinks();
		
		
	}
	


	public static void insertWebLinks() throws IOException {

		BufferedReader reader = null;
		for (String source : domains) {
			try {
				reader = new BufferedReader(new FileReader(source));
				String url;

				int count = 0;
				while ((url = reader.readLine()) != null) {

					url = url.trim();
					String domain = ParseURL.getDomainName(url);

					WebsitesDB.insertWebsite(domain, url);

					if (count % 100 == 0) {
						System.out.println("Processed Records: " + count + " (" + source + ")");
					}

					count++;

				}

				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Print the report
		ReportingService.printRowCountStatus();
	}

}
