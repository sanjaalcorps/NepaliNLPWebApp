package com.icodejava.research.nlp.domain;
/**
 * 
 * @author Kushal Paudyal
 * www.sanjaal.com | www.inepal.org
 * 
 * This class provides an enumeration of majority of the compound word endings in Nepali Language.
 * 
 * Created On: 4/1/2017
 * Last Modified On: 4/8/2017
 *
 */

public enum CompoundWordEnding {
			KA("का"),
			KO("को"),
			KEE("की"),
			KAI("कै"),
			MA("मा"),
			JASTA("जस्ता"),
			JASTO("जस्तो"),
			JASTAI("जस्तै"),
			PASCHAT_1("पश्चात"),
			PASCHAT_2("पस्चात"),
			PASCHAT_3("पश्चात्"),
			MOOLAK_1("मुलक"),
			MOOLAK_2("मूलक"),
			POORBAK_1("पुर्बक"),
			POORBAK_2("पूर्बक"),
			POORBAK_3("पुर्वक"),
			POORBAK_4("पूर्वक"),
			PACHHI_1("पछि"),
			PACHHI_2("पछी"),
			SAKEKA("सकेका"),
			SAKEKO("सकेको"),
			BHANDAA("भन्दा"),
			KAARI("कारी"),//E.G. BINASKARI
			MUKHI("मुखी"),
			VIRUDDHA("विरुद्ध"),
			TIRA("तिर"),
			TEERA("तीर"),
			DWARA_1("द्वारा"),
			DWARA_2("द्धारा"),
			PARNE("पर्ने"),
		 	PURNA("पुर्ण"),
			POORNA("पूर्ण"), 
			BATA("बाट"),
			BATAI("बाटै"), 
			BARE("बारे"),
			BICH("बिच"),
			BIHIN("बिहिन"),
			BIHEEN("बिहीन"),
			BIHINAI("बिहिनै"),
			BIHEENAI("बिहीनै"),
			BHITRA("भित्र"),
			BHITRAI("भित्रै"),
			MADHYE("मध्ये"),
			MADHYAKA("मध्येका"),
			MADHYA("मध्य"),
			MADHYEKA("मध्यका"),
			MAJHA("माझ"),
			MAJHAI("माझै"),
			MATHI("माथि"),
			MATHIKO("माथिको"),
			MATHEE("माथी"),
			MATHEEKO("माथीको"),
			MARPHAT("मार्फत"),
			MARPHATAI("मार्फतै"),
			LAGAYATKA("लगायतका"),
			LAGAYAT("लगायत"),
			LAGAYATKO("लगायतको"),
			MAI("मै"),
			LAI("लाइ"),
			LAEE("लाई"),
			LE("ले"),
			VATA("वाट"),
			VARE("वारे"),
			VICH("विच"),
			VEECH("वीच"),
			VIHIN("विहिन"), 
			SANGA_1("सँग"),
			SANGA_2("संग"),
			SANGA_3("सङ्ग"),
			SANGAI_1("संगै"),
			SANGAI_2("सँगै"),
			SANGAI_3("सङ्गै"),
			SAMAKSHA("समक्ष"),
			SAMET("समेत"),
			SAMETAI("समेतै"),
			SAMMA("सम्म"),
			SAHIT("सहित"),
			SAHITAI("सहितै"),
			SAHITKA("सहितका"),
			SAATH("साथ"),
			SAATHAI("साथै"),
			STHIT("स्थित"), 
			HARU_1("हरु"),
			HARU_2("हरू"),
			HARUKA_1("हरुका"),
			HARUKA_2("हरूका"),
			HARUKO_1("हरुको"),
			HARUKO_2("हरूको"),
			HARUBAATA_1("हरुबाट"), 
			HARUBAATA_2("हरूबाट"), 
			HARUMA_1("हरुमा"), 
			HARUMA_2("हरूमा"),
			HARULAI_1("हरुलाई"), 
			HARULAI_2("हरूलाई"), 
			HARULE_1("हरुले"),
			HARULE_2("हरूले"),
			HARUDWARA_1("हरुद्धारा"),
			HARUDWARA_2("हरूद्धारा"),
			HARU_BICH_1("हरुबीच"),
			HARU_BICH_2("हरूबीच"),
			HARUSITA_1("हरुसित"),
			HARUSITA_2("हरूसित"),
			HARUSAMMA_1("हरुसम्म"),
			HARUSAMMA_2("हरूसम्म"),
			HARU_SANGA_1("हरुसंग"),
			HARU_SANGA_2("हरूसँग"),
			HARU_SANGA_3("हरुसंग"),
			HARU_SANGA_4("हरुसँग"),
			HARU_SANGA_KO_1("हरुसँगको"),
			HARU_SANGA_KO_2("हरुसंगको"),
			HARU_SANGA_KO_3("हरुसंगको"),
			HARU_SANGA_KO_4("हरुसँगको"),
			YOS_1("योस"),
			YOS_2("योस्"),
			JHAIN("झैं"),
			MAYA("मय"),
			SAHITKAA("सहितका"),
			BODH_1("बोध"),
			BODH_2("वोध"),
			PRATI("प्रति"),
			TARFA("तर्फ"),
			BEECH("बीच"),
			VIHEEN("विहीन"),
			KHALKO("खालको"),
			SANGAKO("संगको"),
			RAKHEKO("राखेको"),
			BHITRAMA("भित्रमा"),
			HARUKA("हरूका"),
			TARFAKO("तर्फको"),
			SAMMALE("सम्मले"),
			BHITRAKA("भित्रका"),
			DEKHI("देखि");
	
	//हरुलाई
	//कहाँ
	//पछिका
	//देखि
	//अनुसार
	//भएको
	//
	//भर
	private String nepaliWordEnding;

	CompoundWordEnding(String nepaliWordEnding) {

		this.nepaliWordEnding = nepaliWordEnding;
	}

	public String getNepaliWordEnding() {

		return nepaliWordEnding;
	}
	
}
