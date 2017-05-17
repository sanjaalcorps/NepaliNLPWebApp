package com.icodejava.research.nlp.domain;

public enum LocationWordEnding {

    GHAT("घाट"),
    PUR("पुर"),
    CHAUR_1("चौर"),
    CHAUR_2("चउर"),
    TAR("टार"),
    MOD("मोड"),
    MARA("मारा"),
    MARGA("मार्ग"),
    THAN("थान"),
    GANJA("गन्ज"),
    KUNDA("कुण्ड"),
    GAUN("गाउँ"),
    KHOLA("खोला"),
    SHAHAR("शहर"),
    RAJ("राज"),
    TARI("टारी");
    
    private String nepaliWordEnding;

    LocationWordEnding(String nepaliWordEnding) {

        this.nepaliWordEnding = nepaliWordEnding;
    }

    public String getNepaliWordEnding() {

        return nepaliWordEnding;
    }
}
