package org.inepal.nlp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.domain.Word;

import com.icodejava.research.nlp.domain.Sentence;

public abstract class AbstractNLPServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public AbstractNLPServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	public Word getWordById(List<Word> words, int id) {
		Word aWord = null;
		for(Word word:words) {
			if (word.getId() == id) {
				aWord = word;
				break;
			}
		}
		return aWord;
	}
	

	public Sentence getSentenceById(List<Sentence> sentences, int id) {
		Sentence aSentence = null;
		for(Sentence sentence:sentences) {
			if (sentence.getId() == id) {
				aSentence = sentence;
				break;
			}
		}
		return aSentence;
	}
}