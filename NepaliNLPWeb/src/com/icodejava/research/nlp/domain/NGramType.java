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
	BIGRAM_FORWARD_WITH_STOPWORDS("BF_WS"), 
	BIGRAM_BACKWARD_WITH_STOPWORDS("BB_WS"), 
	TRIGRAM_FORWARD_WITH_STOPWORDS("TF_WS"), 
	TRIGRAM_BACKWARD_WITH_STOPWORDS("TB_WS"), 
	SKIP_BIGRAM_FORWARD_WITH_STOPWORDS("SBF_WS"), 
	SKIP_BIGRAM_BACKWARD_WITH_STOPWORDS("SBB_WS"),
	//Does not contain stop words
	BIGRAM_FORWARD_NO_STOPWORDS("BF_NS"), 
	BIGRAM_BACKWARD_NO_STOPWORDS("BB_NS"), 
	TRIGRAM_FORWARD_NO_STOPWORDS("TF_NS"), 
	TRIGRAM_BACKWARD_NO_STOPWORDS("TB_NS"), 
	SKIP_BIGRAM_FORWARD_NO_STOPWORDS("SBF_NS"), 
	SKIP_BIGRAM_BACKWARD_NO_STOPWORDS("SBB_NS");
	
	private String tag;

	NGramType(String tag) {

		this.tag = tag;
	}

	public String getTag() {

		return tag;
	}

}
