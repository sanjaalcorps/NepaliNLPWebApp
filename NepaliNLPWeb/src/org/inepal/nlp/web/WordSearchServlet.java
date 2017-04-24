package org.inepal.nlp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.domain.Word;
import com.icodejava.research.nlp.services.WordsUnreferencedService;

/**
 * Servlet implementation class WordSearchServlet
 */
@WebServlet("/WordSearchServlet")
public class WordSearchServlet extends AbstractNLPServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see AbstractNLPServlet#AbstractNLPServlet()
     */
    public WordSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Need to set the request characeter encoding to UTF-8 to accept Unicode Devanagari search terms.
		 */
		request.setCharacterEncoding("UTF-8");
		String searchQuery = new String (request.getParameter("word_search_query"));
		String searchType = new String (request.getParameter("word_search_type"));
		//TODO: get limit parameter as a drop down value
		List<Word> words = new ArrayList<Word>();
		
	    if (searchQuery != null) {
	    	words = WordsUnreferencedService.searchWords(searchQuery, searchType, 50); //TODO: remove hardcoding
	    }

		
		/**
		 * Need to set the resposne character encoding to UTF-8 to server Unicode Devanagari in the response.
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("Search Result contains: "  + words.size() + " results");
		request.getSession().setAttribute("wordSearchResult",words);
		
		String nextJSP = "/jsp/word_classify.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextJSP);
        rd.forward(request, response);
		
		response.getWriter().append("Served at: " ).append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
