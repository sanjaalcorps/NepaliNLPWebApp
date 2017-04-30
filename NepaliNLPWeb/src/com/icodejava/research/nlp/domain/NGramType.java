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
	//Contains Stop Words
	BIGRAM_FORWARD_NO_STOPWORD_REMOVED("BFNS"), 
	BIGRAM_BACKWARD_NO_STOPWORD_REMOVED("BBNS"), 
	TRIGRAM_FORWARD_NO_STOPWORD_REMOVED("TFNS"), 
	TRIGRAM_BACKWARD_NO_STOPWORD_REMOVED("TBNS"), 
	SKIP_BIGRAM_FORWARD_NO_STOPWPRD_REMOVED("SBFNS"), 
	SKIP_BIGRAM_BACKWARD_NO_STOPWORD_REMOVED("SBBNS"),
	//Does not contain stop words
	BIGRAM_FORWARD_WITH_STOPWORD_REMOVED("BFWS"), 
	BIGRAM_BACKWARD_WTIH_STOPWORD_REMOVED("BBWS"), 
	TRIGRAM_FORWARD_WITH_STOPWORD_REMOVED("TBNS"), 
	TRIGRAM_BACKWARD_WITH_STOPWORD_REMOVED("TBWS"), 
	SKIP_BIGRAM_FORWARD_WTIH_STOPWPRD_REMOVED("SBFWS"), 
	SKIP_BIGRAM_BACKWARD_WITH_STOPWORD_REMOVED("SBBWS");
	
	private String tag;

	NGramType(String tag) {

		this.tag = tag;
	}

	public String getTag() {

		return tag;
	}

}
