package com.icodejava.research.nlp.domain;

import java.util.List;
import java.util.Map;

public class WebProcessingResult {
	private String url;
	private String text;
	private List<String> sentences;

	private List<String> words;

	private Map<String, Integer> wordFrequencies;
	public Map<String, Integer> getWordFrequencies() {
		return wordFrequencies;
	}
	public void setWordFrequencies(Map<String, Integer> wordFrequencies) {
		this.wordFrequencies = wordFrequencies;
	}
	public List<String> getSentences() {
		return sentences;
	}
	public String getText() {
		return text;
	}

	public String getUrl() {
		return url;
	}

	public List<String> getWords() {
		return words;
	}

	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}
}
