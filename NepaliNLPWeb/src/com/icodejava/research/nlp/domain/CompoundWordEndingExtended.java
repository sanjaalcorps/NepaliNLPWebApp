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
    DUT("दूत"),
    RAAT("रात"),
    CHHAM("छाम"); 

    private String nepaliWordEnding;

    CompoundWordEndingExtended(String nepaliWordEnding) {

        this.nepaliWordEnding = nepaliWordEnding;
    }

    public String getNepaliWordEnding() {

        return nepaliWordEnding;
    }
}
