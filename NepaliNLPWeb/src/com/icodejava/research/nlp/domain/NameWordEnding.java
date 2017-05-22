package com.icodejava.research.nlp.domain;

public enum NameWordEnding {
    
    KUMAR("कुमार"),
    PRASAD("प्रसाद"),
    BAHADUR("बहादुर"),
    KUMARI("कुमारी"),
    DEVI("देवी"),
    JANG("जंग"),
    MAYA("माया"),
    PRAKASH("प्रकाश"),
    MAAN("मान"),
    MATI("मती"),
    MANI("मणि"),
    RAJ("राज"),
    DEEP("दीप"),
    GOPAL("गोपाल"),
    NARAYAN("नारायण"),
    SHAMSHER("शमशेर");
    
    
    private String nepaliWordEnding;

    NameWordEnding(String nepaliWordEnding) {

        this.nepaliWordEnding = nepaliWordEnding;
    }

    public String getNepaliWordEnding() {

        return nepaliWordEnding;
    }

}
