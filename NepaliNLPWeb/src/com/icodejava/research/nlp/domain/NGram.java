package com.icodejava.research.nlp.domain;

import java.sql.Date;

/**
 * This class represents an NGram object
 * https://en.wikipedia.org/wiki/N-gram
 * @author Kushal Paudyal
 * Created On: 4/29/2017
 * Modified On: 4/29/2017
 *
 */

public class NGram {
	
    private String words;
    private NGramType type;
    private int id;
    private String verified;
    private String romanISO;
    private String romanCommon;
    private Date ceatedDate;
    private Date updatedDate;
    
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

	public Date getCeatedDate() {
        return ceatedDate;
    }

	public int getId() {
        return id;
    }

	public String getRomanCommon() {
        return romanCommon;
    }

	public String getRomanISO() {
        return romanISO;
    }
	
	public NGramType getType() {
		return type;
	}

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public String getVerified() {
        return verified;
    }

    public String getWords() {
		return words;
	}

    public void setCeatedDate(Date ceatedDate) {
        this.ceatedDate = ceatedDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRomanCommon(String romanCommon) {
        this.romanCommon = romanCommon;
    }

    public void setRomanISO(String romanISO) {
        this.romanISO = romanISO;
    }

    public void setType(NGramType type) {
		this.type = type;
	}

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public void setWords(String words) {
		this.words = words;
	}

    @Override
	public String toString() {
	    return words;
	}

}
