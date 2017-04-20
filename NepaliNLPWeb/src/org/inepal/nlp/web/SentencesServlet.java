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

import com.icodejava.research.nlp.domain.Sentence;
import com.icodejava.research.nlp.services.SentenceUnreferencedService;

/**
 * Servlet implementation class SentencesServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SentencesServlet" })
public class SentencesServlet extends AbstractNLPServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentencesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Sentence> sentences = getSentences(request);
		
		SentenceUnreferencedService.updateSentenceVerification(sentences);
		
		int count = SentenceUnreferencedService.getVerifiedSentenceCount();

		String nextJSP = "jsp/sentence_valid.jsp?result=successful&count="+count;

		response.sendRedirect(nextJSP);
	}
	
	
	
	private List<Sentence> getSentences(HttpServletRequest request) {
		Enumeration params = request.getParameterNames();
		List<Sentence> sentences = new ArrayList<Sentence>();
		for (; params.hasMoreElements();) {
			// Get the name of the request parameter
			String name = (String) params.nextElement();
			System.out.println(name);
			if (name.startsWith("sentence_")) {

				int id = new Integer(name.substring(name.lastIndexOf("_") + 1).trim());
				System.out.println(id);

				// Get the value of the request parameter
				String value = request.getParameter(name);

				Sentence sentence = getSentenceById(sentences, id);
				if (sentence== null) {
					sentence = new Sentence(id, null);
				}

				
				if (name.startsWith("sentence_valid_")) {
					sentence.setVerified("Y");
				} else if (name.startsWith("sentence_invalid_")) {
					sentence.setVerified("N");
				} else if (name.startsWith("sentence_delete_")) {
					sentence.setMarkedForDeletion(true);
				}

				sentences.add(sentence);

				System.out.println("Found: " + name + " " + value);
			}

		}
		return sentences;

	}


}
