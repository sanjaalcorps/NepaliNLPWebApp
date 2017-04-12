package com.icodejava.research.nlp.domain;

public class Grammar {

	public static final String LETTERS = "कखगघङचछजझञटठडढणतथदधनपफबभमयरलवशषसहक्षत्रज्ञअआइईउऊएऐओऔअंअ:";
	public static final String NUMBERS = "१२३४५६७८९०";
	public static final String SET_OF_MATRAS = "ा ि ी ु ू ृ े ै ो ौ ं : ँ ॅ्" ;
	

	
	//khanu, khayen, khayeko, khanchhu, khanechhu, khayo, khayi, khayeki, khayis, khayou, khanubhayo, khanuhunchha, khanuhunechha, khai, khaidim, khanu paryo, khana parne, khanubhanda, khanasamet, khanasanga, khanasamma.khanaka, khanako, khanalai
	//khayekole, khaidinus, khana, khayidiyera, khaidiun, खाइयोस
	
	public static final String [] BIBHAKTI_PRATHAMA = new String [] {"ले", "बाट","वाट","द्वारा"};
	public static final String [] BIBHAKTI_DWITYA = new String [] {};
	public static final String [] BIBHAKTI_TRITIYA = new String [] {};
	public static final String [] BIBHAKTI_CHATURTHI = new String [] {};
	public static final String [] BIBHAKTI_PANCHAMA = new String [] {};
	public static final String [] BIBHAKTI_SHASHTHI = new String [] {};
	public static final String [] BIBHAKTI_SAPTAMI = new String [] {};

	
	/*
	अ० — अरबी 
	प० स० — परसर्ग  
	अ० क्रि० — अकर्मक क्रिया  
	पू० स० — पूर्वसर्ग  
	अङ्० — अङ्ग्रेजी   
	पोर्त० — पोर्तगाली  
	अ० मू० — अनुकरण मूल  
	प्रा० — प्राकृत  
	अव्य०  — अव्यय  
	प्रा० ने० — प्राचीन नेपाली  
	आ० ने० — आधुनिक नेपाली  
	प्रे० क्रि० — प्रेरणार्थक क्रिया  
	इ० — इत्यादि  
	फा० — फारसी  
	उडि० — उडिया  
	फ्रा० — फ्रान्सेली  
	उदा० — उदाहरण  
	फ्रे० — फ्रेन्च  
	उप० — उपसर्ग  
	ब० व० — बहुवचन  
	क० क्रि० — कर्मवाच्य क्रिया  
	बा० बो० — बालबोली  
	कथ्य० — कथ्य भाषा  
	भा० इ० — भारत–इरानेली 
	 क्रि० प० — क्रिया–पदावली  
	 भो० — भोजपुरी  
	 क्रि० वि० — क्रियाविशेषण  
	 भो० ब० — भोट–बर्मेली  
	 ग्री० — ग्रीक, ग्रीस, ग्रिसेली  
	 मग० — मगराँती  
	 चिनि० — चिनियाँ  
	 मरा० — मराठी  
	 जापा० — जापानी  
	 मै० — मैथिली  
	 डो० — डोटेली  
	 लि० — लिम्बू भाषा  
	 तामा० — तामाङ्गी  
	 वि० — विशेषण  
	 ति० रू० — तिर्यक् रूप  
	 विप० — विपरीतार्थक  
	 तु० — तुर्की, 
	 तुर्केली  
	 वि० बो० — विस्मयादिबोधक  
	 तुल० — तुलना, तुलनीय  
	 विभ० — विभक्ति  
	 था० — थारू  
	 सं० — संस्कृत  
	 दङ० — दङाली  
	 संक्षे० — सङ्क्षेपीकृत रूप  
	 दिव्य० — दिव्यउपदेश  
	 संयु० — संयुक्त  
	 द्वि० — द्वित्व  
	 संयो० — संयोजक 
	  धिमा० — धिमाल  
	  स० क्रि० — सकर्मक क्रिया 
	   ना० — नाम  
	   सर्व० — सर्वनाम  
	   ना० यो० — नामयोगी  
	   सात० — सातत्य  
	   निपा० — निपात  
	   स्त्री० — स्त्रीलिङ्ग  
	   ने० — नेपाली  
	   स्पे० — स्पेनिस  
	   नेवा० — नेवारी  
	   हि० — हिन्दी  
	   प० ने० — पश्चिम नेपाल  
	   हे० — हेर्नुहोस् "
	*/
	
	public static final String POS_ADJECTIVE = "ADJECTIVE"; //Bisheshan
	public static final String POS_ADVERB = "ADVERB"; //Kriya Bisheshan. E.g. Yo, Tyo, Tini, Uni
	public static final String POS_CONJUNCTION = "CONJUNCTION";
	public static final String POS_DETERMINER = "DETERMINER";
	public static final String POS_INJTERJECTION = "INTERJECTION"; //Anukaranatmak Shabda
	public static final String MORPHEME = "MORPHEME";
	public static final String POS_NOUN = "NOUN";//Naam or Sangya - Jaati Bachak, Byakti Bachak, samuha bachak, draba bachak, bhab bachak
	public static final String NUMERAL = "NUMERAL";
	public static final String PARTICLE = "PARTICLE";
	public static final String PHRASE = "PHRASE"; //Bakyanksha
	public static final String PREPOSITION = "PREPOSITION";
	public static final String POSTPOSITION = "POSTPOSITION";
	public static final String PRONOUN = "PRONOUN"; //Sarba Nam: Ma, Hami, Timi
	public static final String VERB = "VERB"; //Kriya
	
	
	public static boolean isMatra(Character c) {
		
		return SET_OF_MATRAS.indexOf(c) >= 0;
	}
	
	
	//Past Tense
	//Present Tense
	//Future Tense
	//Anukaranatmak
	//Idiom - Bakpaddhati
	
	/*
	 * CC Coordinating conjunction
CD Cardinal number
DT Determiner
EX Existential there
FW Foreign word
IN Preposition or subordinating conjunction
JJ Adjective
JJR Adjective, comparative
JJS Adjective, superlative
LS List item marker
MD Modal
NN Noun, singular or mass
NNS Noun, plural
NNP Proper noun, singular
NNPS Proper noun, plural
PDT Predeterminer
POS Possessive ending
PRP Personal pronoun
PRP$ Possessive pronoun
RB Adverb
RBR Adverb, comparative
RBS Adverb, superlative
RP Particle
SYM Symbol
TO to
UH Interjection
VB Verb, base form
VBD Verb, past tense
VBG Verb, gerund or present participle
VBN Verb, past participle
VBP Verb, non­3rd person singular present
VBZ Verb, 3rd person singular present
WDT Wh­determiner
WP Wh­pronoun
WP$ Possessive wh­pronoun
WRB Wh­adverb



कारक———————-एकवचन ———————बहुवचन
कर्ता ———————— ——————————– हरु
कर्म ————————-लाइ —————————-हरुलाई
करण ————————ल़े —————————— हरुले
सम्प्रदान ——————-लाई —————————-हरुलाई
अपादान ——————– बाट—————————— हरुबाट
संबंध ————————को ——————————-हरुको
अधिकरण——————-मा ——————————-हरुमा





	 */

}
