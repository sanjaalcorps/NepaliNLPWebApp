package org.inepal.nlp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.database.WordsUnreferencedDB;
import com.icodejava.research.nlp.domain.Word;
import com.icodejava.research.nlp.services.WordsUnreferencedService;

/**
 * Servlet implementation class RandomWordsServlet
 */
@WebServlet("/WordsClassificationServlet")
public class WordsClassificationServlet extends AbstractNLPServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordsClassificationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Word> words = getWords(request);
		
		WordsUnreferencedService.updateWordsClassification(words);

		
		String nextJSP = "jsp/word_classify.jsp?result=successful";
		response.sendRedirect(nextJSP);
		
	}

	private List<Word> getWords(HttpServletRequest request) {
		Enumeration params = request.getParameterNames();
		List<Word> words = new ArrayList<Word>();
		for (; params.hasMoreElements();) {
			// Get the name of the request parameter
			String name = (String) params.nextElement();
			System.out.println(name);
			if (name.startsWith("word_")) {

				int id = new Integer(name.substring(name.lastIndexOf("_") + 1).trim());
				System.out.println(id);

				// Get the value of the request parameter
				String value = request.getParameter(name);

				Word word = getWordById(words, id);
				if (word== null) {
					word = new Word(id, null, null);
				}

				if (name.startsWith("word_root_")) {
					word.setIsCompoundWord("N");
				} else if (name.startsWith("word_derived_")) {
					word.setIsCompoundWord("Y");
				} else if (name.startsWith("word_person_")) {
					word.setClassification1("Person");
				} else if (name.startsWith("word_firstname_")) {
					word.setClassification2("First Name");
				} else if (name.startsWith("word_surname_")) {
					word.setClassification3("Surname");
				} else if (name.startsWith("word_location_")) {
					word.setClassification1("Place");
				} else if (name.startsWith("word_english_")) {
					word.setClassification5("English");
				} else if (name.startsWith("word_sports_")) {
					word.setClassification1("Sports");
				} else if (name.startsWith("word_politics_")) {
					word.setClassification1("Politics");
				}

				words.add(word);

				System.out.println("Found: " + name + " " + value);
			}

		}
		return words;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
