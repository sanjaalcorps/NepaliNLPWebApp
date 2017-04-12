package org.inepal.nlp.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.database.WordsUnreferencedDB;

/**
 * Servlet implementation class RandomWordsServlet
 */
@WebServlet("/RandomWordsServlet")
public class RandomWordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomWordsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			WordsUnreferencedDB.selectRandomRecords(100);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getWordIDs(request);

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	private void getWordIDs(HttpServletRequest request) {
		Enumeration params = request.getParameterNames();
	    for (; params.hasMoreElements(); ) {
	        // Get the name of the request parameter
	        String name = (String)params.nextElement();
	        if(name.startsWith("WORD_")) {

	        // Get the value of the request parameter
	        	String value = request.getParameter(name);
	        	
	        	System.out.println("Found: " + name + " " + value);
	        }

	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
