package com.icodejava.research.nlp.domain;

import com.icodejava.research.nlp.stemmer.NepaliStemmer;

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
	private String isRootWordExtracted;
	private String needsCleaning;
	private String partOfSpeech;
	private String classification1;
	private String classification2;
	private String classification3;
	private String classification4;
	private String classification5;
	
	private boolean modified;
	private boolean isMarkedForDeletion;
	
	public Word() {
	}

	public Word(int id, String word, String verified) {
		this.id = id;
		this.word = word;
		this.verified = verified;
		this.modified = false;
	}

	public String getClassification1() {
		return classification1;
	}

	public String getClassification2() {
		return classification2;
	}

	public String getClassification3() {
		return classification3;
	}

	public String getClassification4() {
		return classification4;
	}

	public String getClassification5() {
		return classification5;
	}

	public int getId() {
		return id;
	}

	public String getIsCompoundWord() {
		return isCompoundWord;
	}

	public String getIsRootWordExtracted() {
		return isRootWordExtracted;
	}

	public String getNeedsCleaning() {
		return needsCleaning;
	}
	
	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public String getRootSplited() {
		String root = NepaliStemmer.getNepaliRootWord(word);
		return word + "-->" + root + " + " + word.replaceAll(root, "");
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

	public boolean isClassified() {
		
		return getClassification1() != null || getClassification2() != null || getClassification3() != null
				|| getClassification3() != null || getClassification4() != null || getClassification5() != null || getIsCompoundWord() != null;
	}

	public boolean isMarkedForDeletion() {
		return isMarkedForDeletion;
	}

	public boolean isModified() {
		return modified;
	}

	public void setClassification1(String classification1) {
		this.classification1 = classification1;
	}

	public void setclassification2(String classification2) {
		this.classification2 = classification2;
	}

	public void setClassification2(String classification2) {
		this.classification2 = classification2;
	}

	public void setclassification3(String classification3) {
		this.classification3 = classification3;
	}

	public void setClassification3(String classification3) {
		this.classification3 = classification3;
	}

	public void setclassification4(String classification4) {
		this.classification4 = classification4;
	}

	public void setClassification4(String classification4) {
		this.classification4 = classification4;
	}
	
	public void setclassification5(String classification5) {
		this.classification5 = classification5;
	}

	public void setClassification5(String classification5) {
		this.classification5 = classification5;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIsCompoundWord(String isCompoundWord) {
		this.isCompoundWord = isCompoundWord;
	}

	public void setIsRootWordExtracted(String isRootWordExtracted) {
		this.isRootWordExtracted = isRootWordExtracted;
	}

	public void setMarkedForDeletion(boolean isMarkedForDeletion) {
		this.isMarkedForDeletion = isMarkedForDeletion;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public void setNeedsCleaning(String needsCleaning) {
		this.needsCleaning = needsCleaning;
	}

	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
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

	public String toString() {
		return word;
	}



}
