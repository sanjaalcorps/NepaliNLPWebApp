package com.icodejava.research.nlp.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.icodejava.research.nlp.domain.NGram;
import com.icodejava.research.nlp.domain.NGramType;

/**
 * Database Utility to do CRUD operations on NGram object
 * @author Kushal Paudyal
 * Created On: 4/29/2017
 * Modified On: 4/29/2017
 *
 */
public class NGramsDB extends DBUtility {
    
    public static final String DATABASE_URL = "jdbc:sqlite:E:/NLP_DB/npl3.db";//SHADOWED FROM PARENT
    
    public static void insertOrUpdateNGrams(Connection conn, List<NGram> ngrams) {
        Instant start = Instant.now();
        if (ngrams == null || ngrams.size() == 0) {
            return;
        }

        

            for (NGram ngram : ngrams) {

                // try to fetch from the database to see if it already exists
                boolean alreadyExists = alreadyExists(conn, ngram);

                if (alreadyExists) {
                    // update frequency
                    updateFrequency(ngram);
                } else {
                    ngram.setFrequency(1);// First occurrence
                    insertNGram(ngram);
                }
            }
      

        Instant end = Instant.now();
        System.out.println("Time taken to insert or update: " + Duration.between(start, end) + "(" + ngrams.size() + ")");

    }
	
    
    
    private static void updateFrequency(NGram ngram) {
        if (ngram == null || ngram.getWords() == null) {
            return;
        }

        String sql = "UPDATE " + Tables.NGRAM + " SET FREQUENCY=FREQUENCY+1 WHERE WORDS=\"" + ngram + "\" AND NGRAM_TYPE=\"" + ngram.getType().getTag() + "\"";
        
        //System.out.println(sql);

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            int result = pstmt.executeUpdate();

            if (result > 0) {
                //System.out.println("Successfully updated frequency for NGRAM " + ngram.getWords());
            } else {
                System.out.println("Could not update the NGRAM. Make sure the ID exists or there are no other issues" + ngram.getWords());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void insertNGram(NGram ngram) {

        String sql = "INSERT INTO "+ Tables.NGRAM + " (WORDS, FREQUENCY, NGRAM_TYPE, CREATED_DATE, UPDATED_DATE) VALUES(?, ?,?, ?, ?)";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ngram.getWords());
            pstmt.setInt(2, ngram.getFrequency());
            pstmt.setString(3, ngram.getType().getTag());
            
            Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
            pstmt.setDate(4, currentDate);
            pstmt.setDate(5, currentDate);
            
            int result = pstmt.executeUpdate();
            
            if(result < 0) {
                System.out.println("There was some error inserting NGRAM " + ngram.getWords());
            }

        } catch (Exception e) {
            //GRACEFUL
            e.printStackTrace();
        }
    }



    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }



    public static boolean alreadyExists(Connection conn, NGram ngram) {
        boolean alreadyExists = false;
        String sql = "SELECT ID FROM " +  Tables.NGRAM +" WHERE WORDS=\"" + ngram + "\" AND NGRAM_TYPE=\"" + ngram.getType().getTag() + "\"";

        try (//Connection conn = (conn1 !=null)?conn1: getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                alreadyExists = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return alreadyExists;
    }

    public static List<NGram> searchForNGrams(String searchTerm, String searchType, String ngramType, int searchLimit) {
        List<NGram> searchResult =  new ArrayList<NGram>();
        String sql = "SELECT * FROM " +  Tables.NGRAM +" WHERE WORDS LIKE ? AND NGRAM_TYPE = ? LIMIT ? ORDER BY FREQUENCY DESC";
        
        boolean isAnyNGramTypeSearch = false;
        if("{ANY}".equalsIgnoreCase(ngramType)) {
            isAnyNGramTypeSearch = true;
            sql = "SELECT * FROM " +  Tables.NGRAM +" WHERE WORDS LIKE ? LIMIT ?";
        }
        
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            String wordsLike = "%" + searchTerm + "%"; //anywhere
            
            if("start".equalsIgnoreCase(searchType)) {
                wordsLike = searchTerm + "%";
            } else if ("end".equalsIgnoreCase(searchType)) {
                wordsLike = "%" + searchTerm;
            }

            pstmt.setString(1, wordsLike);
            
            if(!isAnyNGramTypeSearch) {
                pstmt.setString(2, NGramType.valueOf(ngramType).getTag());
                pstmt.setInt(3, searchLimit);
            } else {
                pstmt.setInt(2, searchLimit);
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                NGram ngram = new NGram();
                ngram.setId(rs.getInt("ID"));
                ngram.setWords(rs.getString("WORDS"));
                ngram.setVerified(rs.getString("VERIFIED"));
                ngram.setFrequency(rs.getInt("Frequency"));
                
                searchResult.add(ngram);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return searchResult;
    }

}
