package com.icodejava.research.nlp.database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
* @author sqlitetutorial.net
*/
public class DBUtility {
	
	static { 
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public static final String DATABASE_URL = "jdbc:sqlite:C:/Users/paudyals/Desktop/NLP/nlpdb/npl2.db";

    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     * @throws ClassNotFoundException 
     */
    public static void createNewDatabase() throws ClassNotFoundException {
    	
    	Class.forName("org.sqlite.JDBC");

        try (Connection conn = DriverManager.getConnection(DATABASE_URL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createNewDatabase(String databaseURL) throws ClassNotFoundException {
    	
    	Class.forName("org.sqlite.JDBC");

        try (Connection conn = DriverManager.getConnection(databaseURL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void createNewTable(String sql) {
    	
    	createNewTable(DATABASE_URL, sql);

    }
    
    public static void createNewTable(String databaseURL, String sql) {


        try (Connection conn = DriverManager.getConnection(databaseURL);
                Statement stmt = conn.createStatement()) {
            // create a new table
            //System.out.println("SQL to create new table\n" + sql );
            boolean result = stmt.execute(sql);
            if(result) {
            	System.out.println("The table has been successfully created");
            } else {
            	System.out.println("Table Already Exists. Table Creation Skipped.");
            }

            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


	public static void deleteAllRecords(String tableName) {
		
		deleteAllRecords(DATABASE_URL, tableName);
	
	}
	
	public static void deleteAllRecords(String databaseURL, String tableName) {
		
		 String sql = "DELETE FROM " + tableName;
		 
	     try (Connection conn = DriverManager. getConnection(databaseURL);
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	
	         int result = pstmt.executeUpdate();
	         
	         if(result > 0) {
	        	 System.out.println("Records Deleted Successfully");
	         }
	
	     } catch (SQLException e) {
	         System.out.println(e.getMessage());
	     }
	
	}
	
    public static int getRowCount(String table){
    	return getRowCount(DATABASE_URL, table);
    }
    
    public static int getRowCount(String databseUrl, String table){
    	int rowCount = 0;
        String sql = "SELECT count(*) FROM "+ table;

        try (Connection conn = DriverManager.getConnection( databseUrl);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            if (rs.next()) {
                System. out.println("\n=================\nTotal Row Count in "+table+" table " + (rowCount = rs.getInt(1))+"\n=================");
            }
        } catch (SQLException e) {
            System. out.println(e.getMessage());
        }
        
        return rowCount;
    }



}