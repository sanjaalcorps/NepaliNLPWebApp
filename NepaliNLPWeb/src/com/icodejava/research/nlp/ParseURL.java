package com.icodejava.research.nlp;

import java.net.*;
import java.io.*;

public class ParseURL {

	public static void printURLInfo(String url) throws MalformedURLException {

		URL aURL = new URL(url);

		System.out.println("protocol = " + aURL.getProtocol()); // http
		System.out.println("authority = " + aURL.getAuthority()); // example.com:80
		System.out.println("host = " + aURL.getHost()); // example.com
		System.out.println("port = " + aURL.getPort()); // 80
		System.out.println("path = " + aURL.getPath()); // /docs/books/tutorial/index.html
		System.out.println("query = " + aURL.getQuery()); // name=networking
		System.out.println("filename = " + aURL.getFile()); /// docs/books/tutorial/index.html?name=networking
		System.out.println("ref = " + aURL.getRef()); // DOWNLOADING
	}
	
	public static String getDomainName(String url) throws MalformedURLException {

		URL aURL = new URL(url);
		
		return aURL.getProtocol()+"://"+aURL.getHost();
	
	}
	
	
	

	public static void main(String args[]) throws MalformedURLException {
		//printURLInfo("http://nagariknews.com/category/21?page=26");
		System.out.println(getDomainName("http://www.nagariknews.com/category/21?page=26"));
	}
	
	
}