package org.inepal.nlp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.domain.Sentence;
import com.icodejava.research.nlp.services.SentenceUnreferencedService;

/**
 * Servlet implementation class SentencesSearchServlet
 */
@WebServlet("/SentencesSearchServlet")
public class SentencesSearchServlet extends AbstractNLPServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see AbstractNLPServlet#AbstractNLPServlet()
     */
    public SentencesSearchServlet() {
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
		String searchQuery = request.getParameter("sentences_search_query");
		String searchType = request.getParameter("sentences_search_location_type");
		String searchLimit = request.getParameter("sentences_search_limit");
		
		if (searchLimit == null) {
			searchLimit = "50";
		}
		
		List<Sentence> sentences = new ArrayList<Sentence>();
		
	    if (searchQuery != null) {
	    	
	    	//MOCKED: TEMPORARY
	    	Sentence sentence = new Sentence();
	    	sentence.setValue("अायातित औषधि");
	    	
	    	Sentence sentence2 = new Sentence();
	    	sentence2.setValue("अायातित");
	    	
	    	sentences.add(sentence);
	    	sentences.add(sentence2);
	    	//END OF MOCK: TEMPORARY. TODO: REMOVE THE BLOCK
	    	
	  
	    	if(searchQuery != null && searchType != null && searchLimit != null)
	    	sentences = SentenceUnreferencedService.searchSentences(searchQuery, searchType, searchLimit); 
	    }

		
		/**
		 * Need to set the response character encoding to UTF-8 to server Unicode Devanagari in the response.
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("Search Result contains: "  + sentences.size() + " results");
		request.getSession().setAttribute("SentencesSearchResult",sentences);
		
		String nextJSP = "jsp/sentences_search.jsp";
		response.sendRedirect(nextJSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
