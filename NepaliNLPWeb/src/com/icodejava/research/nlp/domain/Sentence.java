package com.icodejava.research.nlp.domain;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
	int id;
	
	/**
	 * Flag representing if NGrams have been extracted.
	 */
	boolean isNGramsExtracted;
	
	/**
	 * Flag tracking if the sentence is modified.
	 */
	boolean modified;
	
	/**
	 * This flag is set if the sentence needs to be deleted from the database (e.g. grammatically incorrect sentence)
	 */
	boolean isMarkedForDeletion;
	
	/**
	 * String value of the sentence
	 */
	String value;
	
	/**
	 * Romanized representation of the sentence. Romanization follows ISO standard.
	 */
	String valueRomanizedISO;
	
	/**
	 * Romanized representation of the sentence. Romanization follows common (popular) usage
	 */
	
	String valueRomanizedStandard;
	
	String verified;

	int wordCount;
	
	List<NGram> nGrams;


	public Sentence() {
	}

	public Sentence(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public Sentence(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public List<NGram> getnGrams() {
	    if(nGrams == null) {
	        nGrams = new ArrayList<NGram>();
	    }
        return nGrams;
    }

	public String getValue() {
		return value;
	}

	public String getValueRomanizedISO() {
		return valueRomanizedISO;
	}

	public String getValueRomanizedStandard() {
		return valueRomanizedStandard;
	}

	public String getVerified() {
		return verified;
	}

	public int getWordCount() {
		return wordCount;
	}

	public boolean isMarkedForDeletion() {
		return isMarkedForDeletion;
	}

	public boolean isModified() {
		return modified;
	}

	public boolean isNGramsExtracted() {
		return isNGramsExtracted;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMarkedForDeletion(boolean isMarkedForDeletion) {
		this.isMarkedForDeletion = isMarkedForDeletion;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	private void setNGrams(List<NGram> nGrams) {
        this.nGrams = nGrams;
    }
	
	public void addNGrams(List<NGram> nGrams) {
	    getnGrams().addAll(nGrams);
	    
	}

	public void setNGramsExtracted(boolean isNGramsExtracted) {
		this.isNGramsExtracted = isNGramsExtracted;
	}

	public void setValue(String value) {
		this.value = value;
		this.modified = true;
	}

	public void setValueRomanizedISO(String valueRomanizedISO) {
		this.valueRomanizedISO = valueRomanizedISO;
	}

	public void setValueRomanizedStandard(String valueRomanizedStandard) {
		this.valueRomanizedStandard = valueRomanizedStandard;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

    public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

    @Override
	public String toString() {
		return id + " \t" + value;
	}

}
