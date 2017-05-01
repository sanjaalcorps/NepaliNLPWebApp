package com.icodejava.research.nlp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.icodejava.research.nlp.domain.NGram;
import com.icodejava.research.nlp.domain.Word;

/**
 * Database Utility to do CRUD operations on NGram object
 * @author Kushal Paudyal
 * Created On: 4/29/2017
 * Modified On: 4/29/2017
 *
 */
public class NGramsDB extends DBUtility {
    
    public static void insertOrUpdateNGrams(List<NGram> ngrams) {
        
        if(ngrams == null || ngrams.size() ==0) {
            return;
        }
        
        
        for(NGram ngram: ngrams) {
            
            //try to fetch from the databse to see if it already exists
            boolean alreadyExists = alreadyExists(ngram.getWords());
            
            if(alreadyExists) {
                //update frequency
                updateFrequency(ngram);
            } else {
                insertNGram(ngram);
            }
            
        }
        
        
        
        
        
        
    }
	
    
    
    private static void updateFrequency(NGram ngram) {
        // TODO Auto-generated method stub
        
    }



    private static void insertNGram(NGram ngram) {
        // TODO Auto-generated method stub
        
    }



    public static boolean alreadyExists(String ngram) {
        boolean alreadyExists = false;
        String sql = "SELECT ID FROM " +  Tables.NGRAM +" WHERE WORDS=\"" + ngram + "\"";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
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
    
    
    
    public static NGram selectNGramByWords(String words) {
        String sql = "SELECT * FROM " + Tables.NGRAM + " WHERE WORDS=" + words + " ORDER BY WORD ASC";

        NGram ngram = new NGram();
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
//
//            if (rs.next()) {
//                ngram.set
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

        return ngram;
    }

}
