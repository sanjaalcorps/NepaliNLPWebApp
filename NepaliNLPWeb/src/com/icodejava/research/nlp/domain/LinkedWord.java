package com.icodejava.research.nlp.domain;

public class LinkedWord {
	int id;
	String value;
	String value_romanized;
	int word_count;
	String verified;
	boolean modified;
	int frequency;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue_romanized() {
		return value_romanized;
	}

	public void setValue_romanized(String value_romanized) {
		this.value_romanized = value_romanized;
	}

	public int getWord_count() {
		return word_count;
	}

	public void setWord_count(int word_count) {
		this.word_count = word_count;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
