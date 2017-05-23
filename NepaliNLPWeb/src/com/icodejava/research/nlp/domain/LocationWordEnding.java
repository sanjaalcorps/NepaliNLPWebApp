package com.icodejava.research.nlp.domain;
/**
 * 
 * @author Kushal Paudyal
 * @web www.icodejava.com | www.inepal.org | www.sanjaal.com
 * @created 05/17/2017
 * @Modifie 05/22/2017
 *
 * Denotes Typical Word Endings (Suffixes) for Nepali Locations.
 */
public enum LocationWordEnding {

    BAAS_2("बास"),
    BAAS_1("वास"),
    BARA_1("बारा"),
    BARA_2("वारा"),
    BASTI("बस्ती"),
    BENSHI("बेंसी"),
    BESHI("बेसी"),
    BESHI_1("बेशी"),
    BESHI_2("वेशी"),
    CHAUR_1("चौर"),
    CHAUR_2("चउर"),
    CHULI("चुली"),
    CHURA("चुरा"),
    CHURI("चुरी"),
    DAHA("दह"),
    DHAM("धाम"),
    DHARA("धारा"),
    GANJA("गन्ज"),
    GAUN("गाउँ"),
    GHARI("घारी"),
    GHAT("घाट"),
    KAADAA("काडा"),
    KANDA("काँडा"),
    KHARKA("खर्क"),
    KHEL("खेल"),
    KHOLA("खोला"),
    KUNDA("कुण्ड"),
    MARA("मारा"),
    MARE("मारे"),
    MARGA("मार्ग"),
    MOD("मोड"),
    NAGAR("नगर"),
    NETA("नेट"),
    NIWAS("निवास"),
    PAANI("पानी"),
    POKHARI("पोखरी"),
    PUR("पुर"),
    PURI_1("पुरि"),
    PURI_2("पुरी"),
    RAJ("राज"),
    RATHA("रथा"),
    SHAHAR("शहर"),
    STHAL("स्थल"),
    TAR("टार"),
    TARI("टारी"),
    THAP("थाप"),
    THOK("थोक"),
    THAN("थान"),
	WANG("वांग");
    
    private String nepaliWordEnding;

    LocationWordEnding(String nepaliWordEnding) {

        this.nepaliWordEnding = nepaliWordEnding;
    }

    public String getNepaliWordEnding() {

        return nepaliWordEnding;
    }
}
