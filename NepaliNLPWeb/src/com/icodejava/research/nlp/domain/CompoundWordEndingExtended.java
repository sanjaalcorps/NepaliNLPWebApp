package com.icodejava.research.nlp.domain;
/**
 * This is extended compound word endings and are intended to be used for destemming during romanization only.
 * @author paudyals
 *
 */
public enum CompoundWordEndingExtended {
    
    
    KARAN("करण"),
    BIGYA("विज्ञ"),
    KARTA("कर्ता"),
    BADI("बादी"),
    BAD("बाद"),
    BAN("वाण"),
    DAAR("दार"),
    DATA("दाता"),
    DUT("दूत"),
    RAAT("रात"),
    CHHAM("छाम"),
    LYAND("ल्याण्ड"),
    PATH("पथ"),
	PATRA("पत्र"),
	SUTRA_1("सुत्र"),
	SUTRA_2("सूत्र"),
	GHAR("घर"),
	DAAN("दान"),
	ROG("रोग"),
	PAATRA("पात्र");
	
	  
	/*
   
	 */

    private String nepaliWordEnding;

    CompoundWordEndingExtended(String nepaliWordEnding) {

        this.nepaliWordEnding = nepaliWordEnding;
    }

    public String getNepaliWordEnding() {

        return nepaliWordEnding;
    }
}
