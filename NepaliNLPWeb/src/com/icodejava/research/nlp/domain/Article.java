package com.icodejava.research.nlp.domain;
/**
 * This class represents an article which could be from various source such as Web, or file.
 * @author Kushal Paudyal
 * www.icodejava.com | www.inepal.org
 *
 */

public class Article {
	private int id;
	private String html;
	private String text;
	private String title;

	public Article(int id, String html, String text, String title) {
		super();
		this.id = id;
		this.html = html;
		this.text = text;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
