package com.icodejava.research.nlp.domain;
/**
 * @author Kushal Paduyal
 * www.sanjaal.com | www.icodejava.com | www.inepal.org
 * Represents single word object. Word could be atomic or molecular as long as it is a single word.
 */
public class Word {

	private int id;
	private String word;
	private String rootWord;
	private String valueRomanizedISOStandard;
	private String valueRomanizedCommon;
	private String verified;
	private String isCompoundWord;
	private String classfication1;
	private String classfication2;
	private String classfication3;
	private String classfication4;
	private String classfication5;
	
	private boolean modified;
	
	public Word(int id, String word, String verified) {
		this.id = id;
		this.word = word;
		this.verified = verified;
		this.modified = false;
	}

	public int getId() {
		return id;
	}

	public String getIsCompoundWord() {
		return isCompoundWord;
	}

	public String getRootWord() {
		return rootWord;
	}

	public String getValueRomanizedCommon() {
		return valueRomanizedCommon;
	}

	public String getValueRomanizedISOStandard() {
		return valueRomanizedISOStandard;
	}

	public String getVerified() {
		return verified;
	}

	public String getWord() {
		return word;
	}

	public boolean isModified() {
		return modified;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setIsCompoundWord(String isCompoundWord) {
		this.isCompoundWord = isCompoundWord;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public void setRootWord(String rootWord) {
		this.rootWord = rootWord;
	}

	public void setValueRomanizedCommon(String valueRomanizedCommon) {
		this.valueRomanizedCommon = valueRomanizedCommon;
	}

	public void setValueRomanizedISOStandard(String valueRomanizedISOStandard) {
		this.valueRomanizedISOStandard = valueRomanizedISOStandard;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getClassfication1() {
		return classfication1;
	}

	public void setClassfication1(String classfication1) {
		this.classfication1 = classfication1;
	}

	public String getClassfication2() {
		return classfication2;
	}

	public void setClassfication2(String classfication2) {
		this.classfication2 = classfication2;
	}

	public String getClassfication3() {
		return classfication3;
	}

	public void setClassfication3(String classfication3) {
		this.classfication3 = classfication3;
	}

	public String getClassfication4() {
		return classfication4;
	}

	public void setClassfication4(String classfication4) {
		this.classfication4 = classfication4;
	}

	public String getClassfication5() {
		return classfication5;
	}

	public void setClassfication5(String classfication5) {
		this.classfication5 = classfication5;
	}

	public String toString() {
		return word;
	}


}
