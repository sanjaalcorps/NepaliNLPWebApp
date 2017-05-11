package org.inepal.nlp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icodejava.research.nlp.HtmlTextExtractor;
import com.icodejava.research.nlp.domain.WebProcessingResult;
import com.icodejava.research.nlp.tokenizer.NepaliTokenizer;
import com.icodejava.research.nlp.tokenizer.NepaliTokenizer.Terminator;

/**
 * Servlet implementation class WebTokenizerServlet
 */
@WebServlet("/WebTokenizerServlet")
public class WebTokenizerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebTokenizerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String urlToExtractTextFrom = request.getParameter("website");
		String text = HtmlTextExtractor.extractTextFromWeb(urlToExtractTextFrom);
		
		WebProcessingResult result = new WebProcessingResult();
		result.setText(text);
		
		result.setSentences(NepaliTokenizer.tokenizeSentence(text, Terminator.NP));
		
		result.setWords(NepaliTokenizer.tokenizeWords(text));
		result.setWordFrequencies(NepaliTokenizer.getWordFrequencyMap(text));
		
		request.getSession().setAttribute("WebProcessingResult", result);
		
		String nextJSP = "jsp/web_tokenizer.jsp";
		response.sendRedirect(nextJSP);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
