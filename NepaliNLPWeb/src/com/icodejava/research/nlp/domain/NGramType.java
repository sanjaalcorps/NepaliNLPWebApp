package com.icodejava.research.nlp.domain;
/**
 * This class represents the NGramType
 * https://en.wikipedia.org/wiki/N-gram
 * @author Kushal Paudyal
 * Created On: 4/29/2017
 * Modified On: 4/29/2017
 *
 */
public enum NGramType {
	
	MONOGRAM("M"), 
	BIGRAM_FORWARD_WITH_STOPWORD("BFWS"), 
	BIGRAM_FORWARD_NO_STOPWORD("BFNS"), 
	BIGRAM_BACKWARD_WTIH_STOPWORD("BBWS"), 
	BIGRAM_BACKWARD_NO_STOPWORD("BBNS"), 
	TRIGRAM_FORWARD_WITH_STOPWORD("TBNS"), 
	TRIGRAM_FORWARD_NO_STOPWORD("TFNS"), 
	TRIGRAM_BACKWARD_WITH_STOP_WORD("TBWS"), 
	TRIGRAM_BACKWARD_NO_STOP_WORD("TBNS"), 
	SKIP_BIGRAM_FORWARD_WTIH_STOPWPRD("SBFWS"), 
	SKIP_BIGRAM_FORWARD_NO_STOPWPRD("SBFNS"), 
	SKIP_BIGRAM_BACKWARD_WITH_STOPWORD("SBBWS"),
	SKIP_BIGRAM_BACKWARD_NO_STOPWORD("SBBNS");
	
	private String representation;

	NGramType(String representation) {

		this.representation = representation;
	}

	public String getRepresentation() {

		return representation;
	}

}
