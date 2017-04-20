package com.icodejava.research.nlp.database;

public class WordsLinkedUnreferencedDB extends DBUtility {
	
	/*
	 * ID
	 * LINKED_WORDS
	 * WORD_LENGTH
	 * FREQUENCY
	 * 
	 */

	public static final String DATABASE_URL = "jdbc:sqlite:C:/Users/paudyals/Desktop/NLP/nlpdb/npl3.db";//SHADOWED FROM PARENT
	
	public static void main(String args[]) {

		createWordsUnreferencedTable();
	}
	
	public static void createWordsUnreferencedTable() {
		String sql = "CREATE TABLE IF NOT EXISTS "+ Tables.WORDS_LINKAGE +" (\n" + " ID integer PRIMARY KEY AUTOINCREMENT,\n"
				 + " LINKED_WORDS text NOT NULL,\n" 
				 + " WORD_COUNT integer,\n" 
				 + " WORD_ROMANIZED text,\n" 
				 + " VERIFIED CHAR(1),\n"
				 + " FREQUENCY integer);";
		
		System.out.println(sql);

		createNewTable(DATABASE_URL,sql);
	}

	public void insertTwoLinkedWords() {

	}

	public void insertThreeLinkedWords() {

	}

	public void insertFourLinkedWords() {

	}

	public void insertFiveLinkedWords() {

	}

	public void insertSixLinkedWords() {

	}

	public void insertSevenLinkedWords() {

	}

	public void insertEightLinkedWords() {

	}

}
