package com.icodejava.research.nlp.domain;
/**
 * 
 * @author Kushal Paudyal
 * @web www.icodejava.com | www.inepal.org | www.sanjaal.com
 * @created 05/17/2017
 * @Modifie 05/22/2017
 *
 */
public enum NameWordEnding {
    
    KUMAR("कुमार"),
    PRASAD("प्रसाद"),
    BAHADUR("बहादुर"),
    KUMARI("कुमारी"),
    DEVI("देवी"),
    JANG("जंग"),
    JEET("जीत"),
    MAYA("माया"),
    PRAKASH("प्रकाश"),
    MAAN("मान"),
    MATI("मती"),
    MANI("मणि"),
    RAJ("राज"),
    DEEP("दीप"),
    GOPAL("गोपाल"),
    NARAYAN("नारायण"),
    SINGHA("सिंह"),
    NDRA("न्द्र"),
    BABU("बाबु"),
    RAM("राम"),
    LAL("लाल"),
    SHAMSHER("शमशेर");
    
    private String nepaliWordEnding;

    NameWordEnding(String nepaliWordEnding) {

        this.nepaliWordEnding = nepaliWordEnding;
    }

    public String getNepaliWordEnding() {

        return nepaliWordEnding;
    }

}
