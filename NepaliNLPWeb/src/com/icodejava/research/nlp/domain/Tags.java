package com.icodejava.research.nlp.domain;
/**
 * Represents Tags to be used in Natural Language Processing for Nepali Language
 * @author Kushal Paudyal
 * www.icodejava.com | www.inepal.org
 *
 */
public enum Tags {
	LOCATION("LOCATION", "Thaun", "ठाउँ"), 
	LOCATION_CITY("CITY", "Shahar", ""),
	PERSON("PERSON", "Byakti", "व्यक्ति"),
	MONTH("MONTH", "Mahina", "महिना"),
	LANGUAGE("LANGUAGE", "Bhasha", "भाषा"),
	ANIMAL("ANIMAL","Janawar", "जनावर"),
	BIRD("BIRD", "Chara", "चरा"),
	RIVER("RIVER", "Nadi", "नदी"),
	MOUNTAIN("MOUNTAIN", "Pahad", "पहाड"),
	PLANT("PLANT","Rukh-Biruwa", "रुख-बिरुवा"),
	AIRLINES("AIRLINES", "Airlines", "एयरलाइन्स");
	//COMPANY
	//NAME/SURNAME
	//RELIGION
	//Money
	//Date
	//Time
	//Movies
	//Entertainment
	//Festivals
	//GEOGRAPHY
	//echo "PHONE_NUMBER=((\+\d{1,2}\s?)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4})"
	//echo "EMAIL=([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?))"
	
	/*
	 Country
Place
Day
Mountains
Rivers
District
Animals
Flowers
Surnames
Names (Auto Generate name/surname combination)
Festivals
Famous People (kings, ministers, MoP, actors, actresses, doctors, business man)
Nepali Political Parties
Professions and Positions
Health Terms (body parts, disease, medicine)
Sports Terms
Food /Drinks/Kitchen
Politics
Agriculture
Technology (Phone/Computers etc)
Education
Movies
Transport
Legal
Trade
News
History
Culture
Nepali Companies
Music
ISPs
Adult
Literature
Types of Businesses
Nepali Colors
Religion


 १ भाषा
 २ इतिहास
 ३ राणा विरूद्ध संघर्ष
 ४ भूगोल
 ५ नेपालका नदीहरू
 ६ प्राकृतिक सम्पदा
 ७ अर्थतन्त्र
 ८ प्रशासनिक विभाजन
 ९ संस्कृति
 ९१ खाना
 १० शिक्षा
 १०१ नेपालका विश्वविद्यालयहरू
 ११ स्वास्थ्य
 १२ सेना तथा सुरक्षा अंग
 १३ संवैधानिक अङगहरू
 १४ राष्ट्रिय चिन्हहरू
	 */

	
	

	private String tagNepali;

	private String tagRomanized;
	private String tagEnglish;

	private Tags(String tagNepali, String tagRomanized, String tagEnglish) {
		this.tagNepali = tagNepali;
		this.tagRomanized = tagRomanized;
		this.tagEnglish = tagEnglish;
	}

	public String getTagNepali() {
		return tagNepali;
	}

	public String getTagRomanized() {
		return tagRomanized;
	}

	public String getTagEnglish() {
		return tagEnglish;
	}

}
