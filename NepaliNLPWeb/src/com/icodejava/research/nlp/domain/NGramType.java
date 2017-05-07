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
	BIGRAM_FORWARD_NO_STOPWORD_REMOVED("BF_NSR"), 
	BIGRAM_BACKWARD_NO_STOPWORD_REMOVED("BB_NSR"), 
	TRIGRAM_FORWARD_NO_STOPWORD_REMOVED("TF_NSR"), 
	TRIGRAM_BACKWARD_NO_STOPWORD_REMOVED("TB_NSR"), 
	SKIP_BIGRAM_FORWARD_NO_STOPWPRD_REMOVED("SBF_NSR"), 
	SKIP_BIGRAM_BACKWARD_NO_STOPWORD_REMOVED("SBB_NSR"),
	//Does not contain stop words
	BIGRAM_FORWARD_WITH_STOPWORD_REMOVED("BF_WSR"), 
	BIGRAM_BACKWARD_WTIH_STOPWORD_REMOVED("BB_WSR"), 
	TRIGRAM_FORWARD_WITH_STOPWORD_REMOVED("TF_WSR"), 
	TRIGRAM_BACKWARD_WITH_STOPWORD_REMOVED("TB_WSR"), 
	SKIP_BIGRAM_FORWARD_WITH_STOPWPRD_REMOVED("SBF_WSR"), 
	SKIP_BIGRAM_BACKWARD_WITH_STOPWORD_REMOVED("SBB_WSR");
	
	private String tag;

	NGramType(String tag) {

		this.tag = tag;
	}

	public String getTag() {

		return tag;
	}

}
