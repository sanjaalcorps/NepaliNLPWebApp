package org.inepal.nlp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.domain.NGram;
import com.icodejava.research.nlp.domain.NGramType;
import com.icodejava.research.nlp.services.NGramService;

/**
 * Servlet implementation class WordSearchServlet
 */
@WebServlet("/NGramsSearchServlet")
public class NGramsSearchServlet extends AbstractNLPServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see AbstractNLPServlet#AbstractNLPServlet()
     */
    public NGramsSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Need to set the request characeter encoding to UTF-8 to accept Unicode Devanagari search terms.
		 */
		request.setCharacterEncoding("UTF-8");
		String searchQuery = request.getParameter("ngrams_search_query");
		String searchType = request.getParameter("ngrams_search_location_type");
		String ngramType =  request.getParameter("ngrams_type");
		String searchLimit = request.getParameter("ngrams_search_limit");
		
		if(searchLimit == null) {
		    searchLimit = "50";
		}
		
		//TODO: get limit parameter as a drop down value
		List<NGram> ngrams = new ArrayList<NGram>();
		
		if(searchQuery != null && searchType != null && ngramType != null && searchLimit!=null) {
		    int searchLimitInt = Integer.parseInt(searchLimit);
		    ngrams = NGramService.searchForNGrams(searchQuery, searchType, ngramType, searchLimitInt);
		}
		
		/**
		 * Need to set the resposne character encoding to UTF-8 to server Unicode Devanagari in the response.
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("Search Result contains: "  + ngrams.size() + " results");
		request.getSession().setAttribute("NGramSearchResult",ngrams);
		
		String nextJSP = "jsp/ngrams_search.jsp";
		response.sendRedirect(nextJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
