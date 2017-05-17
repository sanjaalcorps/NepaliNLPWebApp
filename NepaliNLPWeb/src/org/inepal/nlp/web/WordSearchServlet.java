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
        String searchQuery = request.getParameter("words_search_query");
        String searchType = request.getParameter("words_search_type");
        String verificationType = request.getParameter("words_verification_type");
        String searchLimit = request.getParameter("words_search_limit");

        if (searchLimit == null) {
            searchLimit = "50";
        }
		
		//TODO: get limit parameter as a drop down value
		List<Word> words = new ArrayList<Word>();
		
	    if (searchQuery != null && searchType !=null && verificationType!=null) {
	    	words = WordsUnreferencedService.searchWords(searchQuery, searchType, Integer.parseInt(searchLimit), verificationType);
	    }

		
		/**
		 * Need to set the resposne character encoding to UTF-8 to server Unicode Devanagari in the response.
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("Search Result contains: "  + words.size() + " results");
		request.getSession().setAttribute("wordSearchResult",words);
		
		String nextJSP = "jsp/word_classify.jsp";
	    response.sendRedirect(nextJSP);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
