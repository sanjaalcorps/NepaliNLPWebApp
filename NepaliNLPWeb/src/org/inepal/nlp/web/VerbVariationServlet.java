package org.inepal.nlp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.stemmer.NepaliStemmer;

/**
 * Servlet implementation class WebTokenizerServlet
 */
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
		 * Need to set the request characeter encoding to UTF-8 to accept Unicode Devanagari search terms.
		 */
		request.setCharacterEncoding("UTF-8");
		
		String verb = request.getParameter("verb");
		System.out.println("Finding Verb Variations of " + verb);
		List<String> verbVariations = NepaliStemmer.getAffirmativeVerbVariations(verb);
		
		request.getSession().setAttribute("VerbVariationsResult", verbVariations);
		
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
