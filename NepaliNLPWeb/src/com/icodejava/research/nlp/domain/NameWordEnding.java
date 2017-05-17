package com.icodejava.research.nlp.domain;

public enum NameWordEnding {
    
    KUMAR("कुमार"),
    PRASAD("प्रसाद"),
    BAHADUR("बहादुर"),
    KUMARI("कुमारी"),
    DEVI("देवी"),
    MAYA("माया"),
    PRAKASH("प्रकाश"),
    MAAN("मान"),
    SHAMSHER("शमशेर");
    
    
    private String nepaliWordEnding;

    NameWordEnding(String nepaliWordEnding) {

        this.nepaliWordEnding = nepaliWordEnding;
    }

    public String getNepaliWordEnding() {

        return nepaliWordEnding;
    }

}
