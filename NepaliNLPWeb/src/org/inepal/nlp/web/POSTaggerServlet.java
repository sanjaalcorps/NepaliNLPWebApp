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
@WebServlet("/POSTaggerServlet")
public class POSTaggerServlet extends AbstractNLPServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public POSTaggerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Word> words = getWords(request);
		
		WordsUnreferencedService.updatePartsOfSpeech(words);
		String nextJSP = "jsp/pos_tagger.jsp?result=successful";
		response.sendRedirect(nextJSP);
		
	}

	private List<Word> getWords(HttpServletRequest request) {
		Enumeration params = request.getParameterNames();
		List<Word> words = new ArrayList<Word>();
		for (; params.hasMoreElements();) {
			// Get the name of the request parameter
			String name = (String) params.nextElement();
			if (name.startsWith("word_")) {

				int id = new Integer(name.substring(name.lastIndexOf("_") + 1).trim());
				System.out.println(id);

				// Get the value of the request parameter
				String value = request.getParameter(name);

				Word word = getWordById(words, id);
				if (word== null) {
					word = new Word(id, null, null);
				}

				if (name.startsWith("word_pos_")) {
					word.setPartOfSpeech(value);
					System.out.println("Set Parts of Speech as: " +  word.getPartOfSpeech());
				} else {
					System.out.println("POS Not Tagged");
				}


				words.add(word);

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
