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
import com.icodejava.research.nlp.utils.DevanagariUnicodeToRomanEnglish;

/**
 * Servlet implementation class RandomWordsServlet
 */
@WebServlet("/ValidateRomanizationServlet")
public class ValidateRomanizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateRomanizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Word> words = getWords(request);
		
		WordsUnreferencedService.romanizeAndSaveWords(words);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nextJSP = "jsp/word_roman_validate.jsp?result=successful";
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//		dispatcher.forward(request,response);
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

				if (name.startsWith("word_romanized_")) {
					word.setValueRomanizedISOStandard("***SHOULD_ROMANIZE");
					System.out.println("Should Romanize");
				}
				words.add(word);

				System.out.println("Found: " + name + " " + value);
			}

		}
		
		return words;

	}

	private Word getWordById(List<Word> words, int id) {
		Word aWord = null;
		for(Word word:words) {
			if (word.getId() == id) {
				aWord = word;
				break;
			}
		}
		return aWord;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
