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

import com.icodejava.research.nlp.domain.NGram;
import com.icodejava.research.nlp.domain.NGramType;

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
		String searchQuery = new String (request.getParameter("ngrams_search_query"));
		//String searchType = new String (request.getParameter("ngrams_search_location_type"));
		//String ngramType = new String (request.getParameter("ngrams_type"));
		
		//TODO: get limit parameter as a drop down value
		List<NGram> ngrams = new ArrayList<NGram>();
		
	    if (searchQuery != null) {
	    	
	    	//MOCKED: TEMPORARY
	    	NGram ngram = new NGram();
	    	ngram.setWords("अायातित औषधि");
	    	ngram.setType(NGramType.BIGRAM_FORWARD_NO_STOPWORDS);
	    	ngram.setFrequency(23);
	    	
	    	NGram ngram2 = new NGram();
	    	ngram2.setWords("अायातित");
	    	ngram2.setType(NGramType.BIGRAM_FORWARD_NO_STOPWORDS);
	    	ngram2.setFrequency(23);
	    	
	    	ngrams.add(ngram);
	    	ngrams.add(ngram2);
	    	//END OF MOCK: TEMOORARY. TODO: REMOVE THE BLOCK
	    	
	    	//words = WordsUnreferencedService.searchWords(searchQuery, searchType, 50); //TODO: remove hardcoding
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
