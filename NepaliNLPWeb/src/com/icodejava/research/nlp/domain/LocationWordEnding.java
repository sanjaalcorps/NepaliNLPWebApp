package com.icodejava.research.nlp.domain;

public enum LocationWordEnding {

    BASTI("बस्ती"),
    BENSHI("बेंसी"),
    BESHI("बेसी"),
    BESHI_1("बेशी"),
    BESHI_2("वेशी"),
    CHAUR_1("चौर"),
    CHAUR_2("चउर"),
    DHAM("धाम"),
    GANJA("गन्ज"),
    GAUN("गाउँ"),
    GHAT("घाट"),
    KHARKA("खर्क"),
    KHEL("खेल"),
    KHOLA("खोला"),
    KUNDA("कुण्ड"),
    MARA("मारा"),
    MARGA("मार्ग"),
    MOD("मोड"),
    NAGAR("नगर"),
    NIWAS("निवास"),
    POKHARI("पोखरी"),
    PUR("पुर"),
    PURI_1("पुरि"),
    PURI_2("पुरी"),
    RAJ("राज"),
    SHAHAR("शहर"),
    TAR("टार"),
    TARI("टारी"),
    THAN("थान"),
    VASTI("बस्ती");
    
    private String nepaliWordEnding;

    LocationWordEnding(String nepaliWordEnding) {

        this.nepaliWordEnding = nepaliWordEnding;
    }

    public String getNepaliWordEnding() {

        return nepaliWordEnding;
    }
}
