package com.icodejava.research.nlp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.icodejava.research.nlp.database.ArticlesDB;
import com.icodejava.research.nlp.database.WebsitesDB;

public class WebCrawlService {
	public static final int LIMIT_FROM_EACH_DOMAIN=5000;
	public static void main (String args []) {
		//fetchURLs(1);
		//crawlSites(LIMIT_FROM_EACH_DOMAIN);
		//crawlSitesForDomain("https://ne.wikipedia.org");
		//crawl("http://www.samakalinsahitya.com/index.php?show=detail&art_id=100");
		WordsUnreferencedService.processUnreferencedWords(10000);
	}

	private static void crawlSitesForDomain(String domain) {
		for(String site: fetchURLsForDomain(domain, LIMIT_FROM_EACH_DOMAIN)) {
			startCrawl(site);
		}
		
		//WordsUnreferencedService.processUnreferencedWords(10000);
	}

	public static void crawlSites(final int limitForEachDomain) {
		//Fetch 10 urls from each domain that are not crawled
		List<String> sitesToCrawl = fetchURLs(limitForEachDomain);
		
		//Randomize URL order so we go to random domains from the list
		Collections.shuffle(sitesToCrawl);
		
		int count = 0;
		for(String site: sitesToCrawl) {
			System.out.println("Crawling: " + count++ +" of " + sitesToCrawl.size());
			startCrawl(site);
		}
		
	}

	private static void startCrawl(String site) {
		try {

			long start = System.currentTimeMillis();
			crawl(site);
			long end = System.currentTimeMillis();
			
			System.out.println("Crawling site "  + site + " took " + (end-start)/100 + "ms");
			
			Thread.sleep(4000); //Sleep 5 Seconds
			
		} catch (Exception e) {
			System.out.println("Error Occurred while crawling "  + site);
			
		}
	}

	public static void crawl(String site) {

		Document doc;
		try{ 
			doc = Jsoup.connect(site).userAgent("Mozilla").get();
		} catch (Exception e) {
			System.out.println("Could not crawl " + site + "\n" + e.getMessage() );
			return;
		}
		
		int siteID = WebsitesDB.getSiteID(site);
		
		//return doc.body().text();

		if(siteID > 0) {
			ArticlesDB.insertArticles(siteID, doc.html(), doc.body().text(), doc.title());
		} else {
			System.out.println("Crawled the website, but no site id found. Did not insert the articles to the datbase" );
		}
		
		WebsitesDB.updateSiteCrawledDate(siteID);
		
	}

	private static List<String> fetchURLs(int limitForEachDomain) {
		List<String> domains = WebsitesDB.selectDistinctDomains();
		System.out.println("Fetched: " +  domains.size() + " Domains");
		List<String> urls = new ArrayList<String>();
		for(String domain: domains) {
			urls.addAll(WebsitesDB.selectUncrawledWebsites(domain, limitForEachDomain));
		}
		
		System.out.println("Fetched: " +  urls.size() + " URLs");
		
		return urls;
	}
	
	private static List<String> fetchURLsForDomain(String domain, int limitForEachDomain) {
		
		return WebsitesDB.selectUncrawledWebsites(domain, limitForEachDomain);
	}

}
