package org.inepal.nlp.web;
/**
 * @author Kushal Paudyal
 * @Created 05/11/2017
 * @Modified 05/11/2017
 * 
 * Servlet serving the Verb Variation Feature
 * Character Encoding set to UTF8 to support Devanagari Characters
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.stemmer.NepaliStemmer;

@WebServlet("/VerbVariationServlet")
public class VerbVariationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerbVariationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Need to set the request character encoding to UTF-8 to accept Unicode Devanagari search terms.
		 */
		request.setCharacterEncoding("UTF-8");
		
		String verb = request.getParameter("verb");
		System.out.println("Finding Verb Variations of " + verb);
		
		request.getSession().setAttribute("verb", verb); //put the query word in session
		request.getSession().setAttribute("VerbVariationsResultAffirmative", NepaliStemmer.getAffirmativeVerbVariations(verb));
		request.getSession().setAttribute("VerbVariationsResultNegative", NepaliStemmer.getNegativeVerbVariations(verb));
		
		
		String nextJSP = "jsp/verb_variations.jsp";
		response.sendRedirect(nextJSP);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
