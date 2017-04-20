package com.icodejava.research.nlp.utils;

public class GeneralTool {

	public static void main(String args []) {
		
		String text1 = "०१२३४५६७८९";
		
		System.out.println("Cleaned" + text1.replaceAll("[०-९]", ""));

		
	}

}
