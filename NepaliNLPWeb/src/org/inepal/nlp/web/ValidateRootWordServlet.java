package org.inepal.nlp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.database.WordsUnreferencedDB;
import com.icodejava.research.nlp.domain.Word;
import com.icodejava.research.nlp.services.WordsUnreferencedService;
import com.icodejava.research.nlp.stemmer.NepaliStemmer;

/**
 * Servlet implementation class RandomWordsServlet
 */
@WebServlet("/ValidateRootWordServlet")
public class ValidateRootWordServlet extends AbstractNLPServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateRootWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Word> words = getWords(request);
		
		WordsUnreferencedService.updateWordRoot(words);
		
		WordsUnreferencedService.updateWordRootFromKnownRoots();
		
		int count = WordsUnreferencedService.getRootWordExtractionCount();
		
		
		String nextJSP = "jsp/word_root_validate.jsp?result=successful&count="+count;
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

				
				String wordValue = WordsUnreferencedDB.selectWordByID(id).getWord();
				word.setWord(wordValue);
				System.out.println();
				
				if (name.startsWith("word_root_correct_")) {
					word.setRootWord(NepaliStemmer.getNepaliRootWord(wordValue));
					word.setIsRootWordExtracted("Y");
					//System.out.println("Word Root Correct");
				} else if(name.startsWith("word_root_incorrect_")) {
					word.setRootWord(NepaliStemmer.getNepaliRootWord(wordValue));//so we know what is not correct
					word.setIsRootWordExtracted("Not Correct");
				}
				words.add(word);

				//System.out.println("Found: " + name + " " + value);
			}

		}
		
		return words;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
