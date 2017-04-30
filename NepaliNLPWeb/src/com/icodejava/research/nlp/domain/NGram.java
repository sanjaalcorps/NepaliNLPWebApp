package com.icodejava.research.nlp.domain;
/**
 * This class represents an NGram object
 * https://en.wikipedia.org/wiki/N-gram
 * @author Kushal Paudyal
 * Created On: 4/29/2017
 * Modified On: 4/29/2017
 *
 */

public class NGram {
	
	public NGram() {
		super();
	}
	
    public NGram(String words) {
        super();
        this.words = words;
    }
	
	public NGram(String words, NGramType type) {
		super();
		this.words = words;
		this.type = type;
	}

	private String words;
	private NGramType type;

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public NGramType getType() {
		return type;
	}

	public void setType(NGramType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
	    return words;
	}

}
