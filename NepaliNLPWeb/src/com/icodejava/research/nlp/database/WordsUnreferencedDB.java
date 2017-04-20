package com.icodejava.research.nlp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.icodejava.research.nlp.domain.Grammar;
import com.icodejava.research.nlp.domain.Word;
import com.icodejava.research.nlp.tokenizer.NepaliTokenizer;

public class WordsUnreferencedDB extends DBUtility {
	
	
	
	public static final String DATABASE_URL = "jdbc:sqlite:C:/Users/paudyals/Desktop/NLP/nlpdb/npl3.db";//shadowed from parent
	
	
	public static void main (String args []) throws ClassNotFoundException {
		//createNewDatabase(DATABASE_URL);
		//createWordsUnreferencedTable();
		//insertWord("test");
		//updateWord(4, "Tested");
		//selectAllRecords();
		//deleteAllRecords(DATABASE_URL, Tables.WORDS_UNREFERENCED);
		//deleteRecordsByID(4);
		
		
		//selectRandomRecords(1000);
		//selectRecordsBetweenIds(0, 50000);
		//selectRecordCountByLength();
		
		//selectWordWithLengthGreaterThan(20);
		//selectWordWithLengthEqualTo(3);
		
		//cleanWords();
		//cleanStrangeWords();
		
		//selectWithQuery("SELECT * FROM " + Tables.WORDS_UNREFERENCED +  " where word like '%नु'");
		//selectWithQuery("SELECT * FROM " + Tables.WORDS_UNREFERENCED +  " where word = '÷'");
		
		//selectWithQuery("SELECT COUNT (DISTINCT WORD) FROM " + Tables.WORDS_UNREFERENCED);
		
		//selectCompoundWords("लाई");
		//selectRecordsNotMarkedAsCompoundRandom(10);
		selectRandomCompoundWords(10);
		
	}
	
	
	public static boolean alreadyExists(String word) {
		boolean alreadyExists = false;
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE WORD=\"" + word + "\"";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				//System.out.println("Word Already Exists in "+ Tables.WORDS_UNREFERENCED);
				alreadyExists = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return alreadyExists;
	}
	
	public static void cleanStrangeWords() {
		List<Word> words = selectWithQuery("SELECT * FROM " + Tables.WORDS_UNREFERENCED +  " where word like '%à%'");
		
		for (Word word: words){
			System.out.println(word);
			deleteRecordsByID(word.getId());
		}
		
		words = selectWithQuery("SELECT * FROM " + Tables.WORDS_UNREFERENCED + " where length(word)=1");
		
		for(Word word: words) {
			if(!Grammar.LETTERS.contains("word")) {
				deleteRecordsByID(word.getId());
				System.out.println("Deleted " + word);
			}
		}
		
	}
	
	
	
	public static void cleanWords(int startId, int endId) {
		List<Word> words = selectRecordsBetweenIds(startId, endId);

		int count = 0;
		for(Word word:words) {
			String current = word.getWord();
			//System.out.print(word + "\t");
			word.setWord(NepaliTokenizer.cleanWordToken(word.getWord()));
			
			String cleaned = word.getWord();
			
			//System.out.println(word.getId() + " Dirty: " + current + " Cleaned: " + cleaned);
			
			if(!current.equalsIgnoreCase(cleaned)) {
				word.setModified(true);
			}
			
			if(count%1000 == 0 ) {
				System.out.println("CLEANED: "+ count + " of " + words.size());
			}
			
			count++;
			
			//System.out.print(word + "\n");
		}
		
		updateWords(words);
		cleanStrangeWords();
	}
	
	public static void createWordsUnreferencedTable() {
		/**
		 * CREATE TABLE `WORDS_UNREFERENCED` (
				`ID`	integer PRIMARY KEY AUTOINCREMENT,
				`WORD`	text NOT NULL,
				`WORD_ROMANIZED`	text,
				`VERIFIED`	CHAR(1),
				`PART_OF_SPEECH`	TEXT,
				`CLASSIFICATION_1`	TEXT,
				`CLASSIFICATION_2`	TEXT,
				`CLASSIFICATION_3`	TEXT,
				`CLASSIFICATION_4`	TEXT,
				`CLASSIFICATION_5`	TEXT
			);
		 */
		
		String sql = "CREATE TABLE IF NOT EXISTS "+ Tables.WORDS_UNREFERENCED +" (\n" 
					 + " ID integer PRIMARY KEY AUTOINCREMENT,\n"
					 + " WORD text NOT NULL,\n" 
					 + " WORD_ROMANIZED text,\n" 
					 + " VERIFIED CHAR(1),\n" 
					 + " PART_OF_SPEECH	TEXT,\n"
					 + " CLASSIFICATION_1	TEXT,\n"
					 + " CLASSIFICATION_2	TEXT,\n"
					 + " CLASSIFICATION_3	TEXT,\n"
					 + " CLASSIFICATION_4	TEXT,\n"
					 + " CLASSIFICATION_5	TEXT"
				 
				 + ");";

		createNewTable(DATABASE_URL,sql);
	}
	
	public static void deleteRecordsByDomain(String word) {

		String sql = "DELETE FROM "+ Tables.WORDS_UNREFERENCED +" WHERE ID=\"" + word +"\"";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			int count = pstmt.executeUpdate();

			System.out.println("Successfully Deleted records: " +  count);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	
	public static void deleteRecordsByID(int id) {

		String sql = "DELETE FROM "+ Tables.WORDS_UNREFERENCED +" WHERE ID=" + id;

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.executeUpdate();

			//System.out.println("Successfully Deleted record: " + id);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static int insertWord(String word) {
		int rowID = -1;
		if (alreadyExists(word)) {
			return rowID;
		}

		String sql = "INSERT INTO "+ Tables.WORDS_UNREFERENCED + " (WORD) VALUES(?)";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, word);
			pstmt.executeUpdate();

			// Get Article ID back
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select seq from sqlite_sequence where name=\"" + Tables.WORDS_UNREFERENCED + "\"");

			System.out.println("Inserted Record ID: " + (rowID = rs.getInt(1)) + " WORD: " + word);

		} catch (Exception e) {
			//GRACEFUL
			e.printStackTrace();
		}

		return rowID;
	}
	

	
	public static void removeDuplicateWords() throws InterruptedException {
		//Query Database And get a list of duplicate words
		String sql = "select word, count(*) from " + Tables.WORDS_UNREFERENCED + " group by word having count(*) > 1";
		List<String> wordsList = new ArrayList<String> ();
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				wordsList.add(rs.getString("WORD"));
			}
			
			System.out.println("Total " + wordsList.size() + " words found with duplicate entries" );
			Thread.sleep(5000); //sleeping for 5 seconds to allow change of mind.
			
			for(String word: wordsList) {
				
				//Fetch the IDs of the word
				List<Word> words = selectWordsByWordValue(word);
				
				if(words.size() > 1) { //duplicate
					
					for(int i=1; i< words.size(); i++) { //starting from 1 - don't delete the first record
						
						//Delete the word
						if(words.get(i).getId() > 0) {
						 
							//System.out.println("Record " +  words.get(i).getId() +" "  +  words.get(i).getWord() + " will be marked for deletion");
							deleteRecordsByID(words.get(i).getId());
						}
					}
				}
				
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	public static void selectAllRecords() {
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" ORDER BY WORD ASC";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getInt("ID") + "\t" + rs.getString("WORD") + "\t" + rs.getString("VERIFIED"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<Word> selectCompoundWords(String endsWith) {
		String sql = "SELECT ID, WORD, VERIFIED FROM " +  Tables.WORDS_UNREFERENCED +" where WORD LIKE '%"+endsWith+"'";

		List<Word> words = new ArrayList<Word>();
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			

			Word word = null;
			while (rs.next()) {
				word = new Word(rs.getInt(1), rs.getString(2), rs.getString(3));
				//System.out.println(rs.getString(1)+" " + rs.getString(2));
				words.add(word);
			}
			System.out.println("Found: " +  words.size() + " Records ending in --> " + endsWith);
			//System.out.println(words); //THIS IS CAUSING MEMORY ISSUES
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	/**
	 * Fetches a list of words ending with endsWith that are not already tagged as compound words
	 * @param endsWith
	 * @return
	 */
	public static List<Word> selectCompoundWordsNotTagged(String endsWith) {
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" where IS_COMPOUND_WORD IS NULL AND WORD LIKE '%"+endsWith+"'";

		List<Word> words = new ArrayList<Word>();
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			

			Word word = null;
			while (rs.next()) {
				word = new Word(rs.getInt(1), rs.getString(2), rs.getString(3));
				//System.out.println(rs.getString(1)+" " + rs.getString(2));
				words.add(word);
			}
			if(words.size() > 0) {
				System.out.println("Found: " +  words.size() + " Records ending in --> " + endsWith);
			}
			//System.out.println(words); //THIS IS CAUSING MEMORY ISSUES
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	public static List<Word> selectCompoundWordsRootWordsNotExtracted(String endsWith) {
		String sql = "SELECT ID, WORD, VERIFIED FROM " +  Tables.WORDS_UNREFERENCED +" where ROOT_WORD_EXTRACTED IS NULL AND WORD LIKE '%"+endsWith+"'";

		List<Word> words = new ArrayList<Word>();
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			

			Word word = null;
			while (rs.next()) {
				word = new Word(rs.getInt(1), rs.getString(2), rs.getString(3));
				//System.out.println(rs.getString(1)+" " + rs.getString(2));
				words.add(word);
			}
			System.out.println("Found: " +  words.size() + " Records ending in --> " + endsWith);
			//System.out.println(words); //THIS IS CAUSING MEMORY ISSUES
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	public static int selectCompoundWordsTaggedCount() {
		String sql = "SELECT count(*) FROM " +  Tables.WORDS_UNREFERENCED +" where IS_COMPOUND_WORD=\"Y\"";
		
		int count = 0;

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return count;
	}
	
	public static List<Word> selectRandomRecords(int limit) {
		List<Word> words = new ArrayList<Word>();
		 //SELECT * FROM table WHERE id IN (SELECT id FROM table ORDER BY RANDOM() LIMIT x)
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE ID IN (SELECT ID FROM " + Tables.WORDS_UNREFERENCED +" ORDER BY RANDOM()  LIMIT " + limit + ") ORDER BY WORD ASC";

		System.out.println(sql);
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				words.add(new Word(rs.getInt("ID"), rs.getString("WORD"), rs.getString("VERIFIED") ));
				//System.out.println(rs.getInt("ID") + "\t" + rs.getString("WORD") + "\t" + rs.getString("VERIFIED"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	
	public static void selectRecordCountByLength() {
		String sql = "SELECT Length(WORD), count (*) FROM " +  Tables.WORDS_UNREFERENCED +" GROUP BY LENGTH(WORD) ORDER BY 1 DESC";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getString(1)+" " + rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<Word> selectRecordsBetweenIds(int start, int end) {
		List<Word> words = new ArrayList<Word>();
		
		 //SELECT * FROM table WHERE id IN (SELECT id FROM table ORDER BY RANDOM() LIMIT x)
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE ID BETWEEN " + start + " AND " + end;

		System.out.println(sql);
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				words.add(new Word(rs.getInt("ID"), rs.getString("WORD"), rs.getString("VERIFIED") ));
				//System.out.println(rs.getInt("ID") + "\t" + rs.getString("WORD") + "\t" + rs.getString("VERIFIED"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	public static List<Word> selectRecordsNotMarkedAsCompound() {
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE IS_COMPOUND_WORD IS NULL OR IS_COMPOUND_WORD='N' ORDER BY WORD ASC";

		List<Word> words = new ArrayList<Word>();
		
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				//System.out.println(rs.getInt("ID") + "\t" + rs.getString("WORD") + "\t" + rs.getString("VERIFIED"));
				words.add(new Word(rs.getInt("ID"), rs.getString("WORD"), rs.getString("VERIFIED") ));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	public static List<Word> selectRecordsNotMarkedAsCompound(int limit) {
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE IS_COMPOUND_WORD IS NULL OR IS_COMPOUND_WORD='N' ORDER BY WORD ASC LIMIT " + limit ;

		List<Word> words = new ArrayList<Word>();
		
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				//System.out.println(rs.getInt("ID") + "\t" + rs.getString("WORD") + "\t" + rs.getString("VERIFIED"));
				words.add(new Word(rs.getInt("ID"), rs.getString("WORD"), rs.getString("VERIFIED") ));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	public static List<Word> selectRecordsNotMarkedAsCompoundRandom(int limit) {

		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE ID IN (SELECT ID FROM " + Tables.WORDS_UNREFERENCED +" WHERE IS_COMPOUND_WORD IS NULL OR IS_COMPOUND_WORD='N' ORDER BY RANDOM()  LIMIT " + limit + ") ORDER BY WORD ASC";

		List<Word> words = new ArrayList<Word>();
		
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				//System.out.println(rs.getInt("ID") + "\t" + rs.getString("WORD") + "\t" + rs.getString("VERIFIED"));
				words.add(new Word(rs.getInt("ID"), rs.getString("WORD"), rs.getString("VERIFIED") ));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	public static List<Word> selectRandomCompoundWords(int limit) {

		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE ID IN (SELECT ID FROM " + Tables.WORDS_UNREFERENCED +" WHERE IS_COMPOUND_WORD='Y' AND ROOT_WORD IS NULL ORDER BY RANDOM()  LIMIT " + limit + ") ORDER BY WORD ASC";

		List<Word> words = new ArrayList<Word>();
		
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				//System.out.println(rs.getInt("ID") + "\t" + rs.getString("WORD") + "\t" + rs.getString("VERIFIED"));
				words.add(new Word(rs.getInt("ID"), rs.getString("WORD"), rs.getString("VERIFIED") ));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	

	public static int selectRomanizedWordsCount() {
		int count = 0;
		String sql = "SELECT count(*) FROM " +  Tables.WORDS_UNREFERENCED +" WHERE WORD_ROMANIZED IS NOT NULL";
		
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return count;
	}
	
	public static List<Word> selectWithQuery(String sql) {

		List<Word> words = new ArrayList<Word>();
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getInt("ID") + "\t" + rs.getString("WORD"));
				words.add(new Word(rs.getInt("ID"), rs.getString("WORD"), rs.getString("VERIFIED") ));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	public static Word selectWordByID(int id) {
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE ID="+id+ " ORDER BY WORD ASC";

		Word word = new Word(id, null, null);
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				System.out.println(rs.getInt("ID") + "\t" + rs.getString("WORD") + "\t" + rs.getString("VERIFIED"));
				word.setWord(rs.getString("WORD"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return word;
	}
	
	/**
	 * Queries the database and gets a list of words by Word Value
	 * @param wordValue
	 * @return
	 */
	private static List<Word> selectWordsByWordValue(String wordValue) {
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE WORD=\""+wordValue+ "\" ORDER BY WORD ASC";

		List<Word> words = new ArrayList<Word>();
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				//System.out.println("Found: " + rs.getInt("ID") + "\t" + rs.getString("WORD") + "\t" );
				
				Word word = new Word(rs.getInt("ID"), rs.getString("WORD"), null);
				words.add(word);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		//System.out.println("Found: " + words.size() + " records of " +  wordValue);
		return words;
	}
	
	public static List<Word> selectWordsNotRomanized(int limit) {
		//String sql = "SELECT ID, WORD, VERIFIED FROM " +  Tables.WORDS_UNREFERENCED +" WHERE WORD_ROMANIZED IS NULL ORDER BY WORD ASC LIMIT " + limit +";" ;
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" WHERE ID IN (SELECT ID FROM " + Tables.WORDS_UNREFERENCED +" WHERE WORD_ROMANIZED IS NULL ORDER BY RANDOM()  LIMIT " + limit + ") ORDER BY WORD ASC";
		System.out.println(sql);

		List<Word> words = new ArrayList<Word>();
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			

			Word word = null;
			while (rs.next()) {
				word = new Word(rs.getInt(1), rs.getString(2), rs.getString(3));
				words.add(word);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return words;
	}
	
	public static void selectWordWithLengthEqualTo(int length) {
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" where LENGTH(WORD) = " + length + " ORDER BY 1 DESC";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getString(1)+" " + rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void selectWordWithLengthGreaterThan(int length) {
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" where LENGTH(WORD) > " + length + " ORDER BY 1 DESC";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getString(1)+" " + rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void selectWordWithLengthLessThan(int length) {
		String sql = "SELECT * FROM " +  Tables.WORDS_UNREFERENCED +" where LENGTH(WORD) < " + length + " ORDER BY 1 DESC";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getString(1)+" " + rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updateRomanizationISO(int id, String valueRomanizedISOStandard) {
		String sql = "UPDATE " + Tables.WORDS_UNREFERENCED + " SET WORD_ROMANIZED=? WHERE ID=?";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, valueRomanizedISOStandard);
			pstmt.setInt(2, id);
			int result = pstmt.executeUpdate();

			if(result > 0) {
				System.out.println("Successfully updated Romanization " + valueRomanizedISOStandard );
			} else {
				System.out.println("Could not update the word. Make sure the ID exists or there are no other issues");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void updateWord(int id, String wordNewValue) {

		String sql = "UPDATE " + Tables.WORDS_UNREFERENCED + " SET WORD=? WHERE ID=?";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, wordNewValue);
			pstmt.setInt(2, id);
			int result = pstmt.executeUpdate();

			if(result > 0) {
				//System.out.println("Successfully updated word");
			} else {
				System.out.println("Could not update the word. Make sure the ID exists or there are no other issues");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void updateWordClassification(Word word) {
		
		String sql = "UPDATE " +  Tables.WORDS_UNREFERENCED + " SET IS_COMPOUND_WORD = \"" + word.getIsCompoundWord() + "\"," + 
			" CLASSIFICATION_1=\"" +  word.getClassfication1() + "\","  +
			" CLASSIFICATION_2=\"" +  word.getClassfication2() + "\"," +
			" CLASSIFICATION_3=\"" +  word.getClassfication3() + "\"," +
			" CLASSIFICATION_4=\"" +  word.getClassfication4() + "\"," +
			" CLASSIFICATION_5=\"" +  word.getClassfication5() + "\"" +
			" WHERE ID=" + word.getId(); 
		
		
		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			int result = pstmt.executeUpdate();


				if (result > 0) {
					//System.out.println("Successfully updated Article to mark it as processed for word extract (unrefereneced) + ID " + id);
				} else {
				System.out.println("Error updating word classification");
				}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * This method updates the value of a ROOT_WORD AND sets value of ROOT_WORD_EXTRATED TO Y
	 * 
	 * @param word
	 */
	public static void updateWordRootWordAndTag(Word word) {
		
		if(word.getId() < 1 || word.getWord() == null || word.getRootWord() == null) {
			return;
		}
		
		String sql = "UPDATE " + Tables.WORDS_UNREFERENCED + " SET ROOT_WORD=\""+word.getRootWord()+"\", ROOT_WORD_EXTRACTED= \""+word.getIsRootWordExtracted()+"\" WHERE ID=" +word.getId();
		//System.out.println(sql);

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();)
				{
				int result= stmt.executeUpdate(sql);


			if(result > 0) {
				//System.out.println("Successfully updated word");
			} else {
				System.out.println("Could not update the word. Make sure the ID exists or there are no other issues");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void updateWords(List<Word> words) {
		if(words == null || words.isEmpty()) {
			return;
		}
		
		int count=0;
		for(Word word:words) {
			
			if(count%1000 == 0 ) {
				System.out.println("UPDATED: "+ count + " of " + words.size());
			}
			
			
			if(word.getWord().trim().length() == 0 || word.getWord().trim().length() > 24) { //deleting empty and longer sentences
				deleteRecordsByID(word.getId());
			} else if (word.isModified()){
				updateWord(word.getId(), word.getWord());
			} else {
				//System.out.println("Not Modified " + word );
			}
			
			count++;
		}
		
		

	}

	public static void updateWordsMarkAsCompound(List<Word> words) {
		
		if(words == null || words.isEmpty()) {
			return;
		}
		
		int count=0;
		for(Word word:words) {
			
			if(count%1000 == 0 ) {
				System.out.println("UPDATED: "+ count + " of " + words.size());
			}
			if("Y".equalsIgnoreCase(word.getIsCompoundWord())) {
				updateWordTagAsCompound(word.getId(), "Y");
				System.out.println("Found compound word " + word);
			}
			
			count++;
		}
		
	}

	public static void updateWordTagAsCompound(int id, String isCompoundWord) {

		String sql = "UPDATE " + Tables.WORDS_UNREFERENCED + " SET IS_COMPOUND_WORD=? WHERE ID=?";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, isCompoundWord);
			pstmt.setInt(2, id);
			int result = pstmt.executeUpdate();

			if(result > 0) {
				//System.out.println("Successfully updated word");
			} else {
				System.out.println("Could not update the word. Make sure the ID exists or there are no other issues");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//updateWordTagRootWords
	public static void updateWordTagRootWords(List<Word> words) {
		
		if(words == null || words.isEmpty()) {
			return;
		}
		
		int count=0;
		for(Word word:words) {
			
			if(count%1000 == 0 ) {
				System.out.println("UPDATED ROOT WORDS: "+ count + " of " + words.size());
			}
			if(word.getWord() != null && word.getRootWord() != null) {
				
				updateWordRootWordAndTag(word);
			}
			
			count++;
		}
		
	}


}
