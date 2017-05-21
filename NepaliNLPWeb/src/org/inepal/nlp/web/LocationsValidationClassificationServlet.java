package org.inepal.nlp.web;
/**
 * @author Kushal Paudyal
 * @web www.icodejava.com | www.inepal.org | www.sanjaal.com
 * @Created 5/20/2017
 * @Modified 5/21/2017
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.domain.Word;
import com.icodejava.research.nlp.services.WordsUnreferencedService;

@WebServlet("/LocationsValidationClassificationServlet")
public class LocationsValidationClassificationServlet extends AbstractNLPServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationsValidationClassificationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Word> words = getWords(request);
		
		WordsUnreferencedService.updateWordsClassification(words);
		
		String nextJSP = "jsp/locations_validate_classify.jsp?result=successful";
		response.sendRedirect(nextJSP);
		
	}

    private List<Word> getWords(HttpServletRequest request) {
        Enumeration params = request.getParameterNames();
        List<Word> words = new ArrayList<Word>();
        for (; params.hasMoreElements();) {
            String name = (String) params.nextElement();
            if (name.startsWith("word_")) {

                int id = new Integer(name.substring(name.lastIndexOf("_") + 1).trim());

                Word word = getWordById(words, id);
                if (word == null) {
                    word = new Word(id, null, null);
                }

                boolean classified = false;
                if (name.startsWith("word_location_")) {
                    word.setClassification1("Location");
                    classified = true;
                }

                if (classified) {
                    word.setVerified("Y");
                }

                words.add(word);
            }

        }

        System.out.println("Found " + words.size() + " words");
        return words;

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
