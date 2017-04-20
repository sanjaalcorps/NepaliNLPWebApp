package com.icodejava.research.nlp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WebsitesDB extends DBUtility {

	/*
	 * ID
	 * DOMAIN
	 * URL
	 * CREATED_DATE
	 * CRAWLED_DATE
	 */
	
	public static void main(String args[]) {
		// createWebsitesTable();
		// deleteAllRecords(Tables.WEBSITES);
		// deleteRecordsByID(6);
		 //deleteRecordsByDomain("https://www.mysansar.com");
		// deleteRecordsByURL("http://www.sanjaal.com/test/test.php");//NOT
		// TESTED
		// insertWebsite("http://www.sanjaal.com/",
		// "http://www.sanjaal.com/test/test.php");
		// selectAllWebsites();
		 // selectUncrawledWebsites("http://www.mysansar.com", 10);
		//selectDistinctDomains();
		//updateSiteCrawledDate(-1);

	}

	public static void printRowCountByDomain() {
		String sql = "SELECT DOMAIN, COUNT(*) FROM WEBSITES GROUP BY DOMAIN ORDER BY 2 DESC";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			System.out.println("\n===============TOTAL WEBSITES BY DOMAIN===============");

			while (rs.next()) {
				System.out.println(rs.getString(1) +" ("+rs.getInt(2)+")");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void printRowCountByDomainUncrawled() {
		String sql = "SELECT DOMAIN, COUNT(*) FROM WEBSITES WHERE CRAWLED_DATE IS NULL GROUP BY DOMAIN ORDER BY 2 DESC";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			System.out.println("\n==============================");

			while (rs.next()) {
				System.out.println(rs.getString(1) +" ("+rs.getInt(2)+")");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createWebsitesTable() {
		String sql = "CREATE TABLE IF NOT EXISTS WEBSITES (\n" 
					+ " ID integer PRIMARY KEY AUTOINCREMENT,\n"
					+ " DOMAIN text NOT NULL,\n" 
					+ " URL text NOT NULL,\n" 
					+ " CREATED_DATE DATE NOT NULL, \n" 
					+ " CRAWLED_DATE DATE);";

		createNewTable(sql);
	}

	public static int insertWebsite(String domain, String url) {
		int rowID = -1;
		if (alreadyExists(domain, url)) {
			return rowID;
		}

		String sql = "INSERT INTO WEBSITES (DOMAIN, URL, CREATED_DATE) VALUES(?,?,?)";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, domain);
			pstmt.setString(2, url);
			pstmt.setDate(3, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			pstmt.executeUpdate();

			// Get Article ID back
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select seq from sqlite_sequence where name=\"WEBSITES\"");

			//System.out.println("Inserted Record ID: " + (rowID = rs.getInt(1)));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowID;
	}

	public static void deleteRecordsByID(int id) {

		String sql = "DELETE FROM WEBSITES WHERE ID=" + id;

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.executeUpdate();

			System.out.println("Successfully Deleted record");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void deleteRecordsByDomain(String domain) {

		String sql = "DELETE FROM WEBSITES WHERE DOMAIN=\"" + domain + "\"";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			int count = pstmt.executeUpdate();

			System.out.println("Successfully Deleted records: " +  count);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public static void deleteRecordsByURL(String url) {

		String sql = "DELETE FROM WEBSITES WHERE URL=\"" + url + "\"";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.executeUpdate();

			System.out.println("Successfully Deleted record");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void selectAllWebsites() {
		String sql = "SELECT * FROM WEBSITES";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getInt("ID") + "\t" + rs.getString("DOMAIN") + "\t" + rs.getString("URL") + "\t"
						+ rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static List<String> selectDistinctDomains() {
		String sql = "SELECT DISTINCT DOMAIN FROM WEBSITES";
		
		List<String> domains = new ArrayList<String>();

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				domains.add(rs.getString("DOMAIN"));
				//System.out.println(rs.getString("DOMAIN"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return domains;
	}
	

	
	public static List<String> selectUncrawledWebsites(String domain, int howMany) {
		String sql = "SELECT URL FROM WEBSITES WHERE DOMAIN=\""+domain+"\" AND CRAWLED_DATE IS NULL LIMIT " + howMany;
		
		List<String> urls = new ArrayList<String>();

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getString("URL"));
				
				//System.out.println(rs.getInt("ID") + "\t" + rs.getString("DOMAIN") + "\t" + rs.getString("URL") + "\t" + rs.getString("CREATED_DATE") +"\t" +  rs.getString("CRAWLED_DATE"));
				urls.add(rs.getString("URL"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return urls;
	}
	
	public static int getSiteID(String site) {
		int siteId = -1;
		String sql = "SELECT ID FROM WEBSITES WHERE URL = \"" + site +"\"";
		

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				siteId = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return siteId;
	}
	
	

	public static boolean alreadyExists(String domain, String url) {
		boolean alreadyExists = false;
		String sql = "SELECT * FROM WEBSITES WHERE DOMAIN=\"" + domain + "\" AND URL=\"" + url + "\"";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				//System.out.println("Record Already Exists");
				alreadyExists = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return alreadyExists;
	}

	public static void updateSiteCrawledDate(int siteID) {
		String sql = "UPDATE WEBSITES SET CRAWLED_DATE=\""+ new java.sql.Date(Calendar.getInstance().getTime().getTime()) +"\" WHERE ID=" + siteID + "";
		System.out.println(sql);

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			int result  = pstmt.executeUpdate();

			
			if(result > 0) {
			
				System.out.println("Successfully Updated Crawled Date On site ID" + siteID );
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		
	}

	public static void printCrawledSitesCount() {
		String sql = "SELECT COUNT(*) FROM WEBSITES WHERE CRAWLED_DATE IS NOT NULL";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			

			if (rs.next()) {
				System.out.println("Crawled Sites Count: " + rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void printUncrawledSitesCount() {
		String sql = "SELECT COUNT(*) FROM WEBSITES WHERE CRAWLED_DATE IS NULL";

		try (Connection conn = DriverManager.getConnection(DATABASE_URL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			

			if (rs.next()) {
				System.out.println("Uncrawled Sites Count: " + rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}



}
