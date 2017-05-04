package com.icodejava.research.nlp.test;

import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.icodejava.research.nlp.stemmer.NepaliStemmer;

public class NepaliStemmerTest {
	
	@Test
	public void test_root_word_extraction() {
		Map<String, String> map = new HashMap<String, String>();

		map.put("पहिलेभन्दा", "पहिले");
		map.put("समयभन्दा", "समय");
		map.put("खत्तमै", "खत्तमै");
		map.put("ठिक्कै", "ठिक्कै");
		map.put("दलहरुप्रति", "दल");
		map.put("आयुक्तसँगै", "आयुक्त");
		map.put("बन्नुनपर्ने", "बन्नुनपर्ने");
		map.put("दैनिकीजस्तै", "दैनिकी");
		map.put("सीमाअनुसार", "सीमा");
		map.put("चलेजस्तो", "चले");
		map.put("कांग्रेसएमालेबीच", "कांग्रेसएमाले");
		map.put("राज्यहरूमध्ये", "राज्य");
		map.put("चेलीबेटीहरूमध्य", "चेलीबेटी");
		map.put("भर्भर", "भर्भर");
		map.put("छिमेकीजस्तै", "छिमेकी");
		map.put("मालूमै", "मालूमै");
		map.put("उपस्थितहरू", "उपस्थित");
		map.put("जुलूमै", "जुलूमै");
		map.put("चालकबीचको", "चालक");
		map.put("कलकत्ताबीचको", "कलकत्ता");
		map.put("खेलाडीहरूकै", "खेलाडी");
		map.put("स्त्रीहरुमाथि", "स्त्री");
		map.put("क्रान्तिकारीहरुमा", "क्रान्तिकारी");
		map.put("आत्माबिहिन", "आत्मा");
		map.put("ओबामादेखि", "ओबामा");
		map.put("नागरिकहरुलाइ", "नागरिक");
		map.put("चौकीभित्रसमेत", "चौकी");
		map.put("संशोधनपूर्वकै", "संशोधन");
		map.put("संसद्सम्मै", "संसद्");
		map.put("पाण्डेज्युहरू", "पाण्डे");

		int failedCount = 0;
		boolean passed = true;
		for (String key : map.keySet()) {

			try {
				Assert.assertThat(NepaliStemmer.getNepaliRootWord(key), is(map.get(key)));
			} catch (Error e) {
				System.out.println((failedCount++) + " Failed " + key + " --> " + e.getMessage());
					passed = false;
				//Assert.fail((failedCount++) + " Failed " + key + " --> " + e.getMessage());
			}
		}
		
		if(!passed) {
			Assert.fail("Root Word Extraction Failed. See Console for Details");
		}
		
		/*

"छिमेकीहरुसित",


"टुकीकै",
"ओबामादेखि",
"देखापरेकै",
"सम्भावनाहरूप्रति",
"सिपाहीहरूमध्ये",
"श्लोकहरूकै",
"नीकै",
"परिवारजनसंग",
"बेलेकै",
"खेलेजस्तो",
"छिरिक्कै",
"अप्लाइ",
"उचालेकै",
"भुकै",
"बक्स्योस",
"शहिदहरुलाइ",
"हेरेकाहरुले",
"दिइस्योस्",
"चिनियाँहरुकै",
"तरकारीहरु",
"फोकाजस्तो",
"कन्टेनरवालाहरू",

"उपाध्यक्षहरूसमेत",
"जोगाइदिएकै",
"शङ्‌काहरू",
"स्ाँगसँगै",
"मिलेजस्तै",
"अवस्थामासमेत",
"अछामसम्मै",
"हकारी",
"पीडासँगसँगै",
"पाटनहरूमै",
"सचिवहरूसमेत",
"देखिदेखि",
"हिन्दुहरूकै",
"घटनाहरूमध्ये",
"बिर्र्तावालाहरूले",
"स्थापनासँगसँगै",
"सार्कस्तरमै",
"निर्वाचनआयुक्त",
"धम्कीहरूले",
"वुधवारे",
"उत्तीर्णहरूमध्ये",
"सुझावहरुमाथि",
"पसलेहरूका",
"समस्याहरूसँगै",
"टाँगमुन्तिर",
"सन्दर्भहरूसमेत",
"भुमिकाहरू",
"सुत्रेबित्तिकैदेखि",
"मन्त्रीज्यूहरुले",
"घरहरूमध्ये",
"पिएचडीसम्मै",
"हामीभित्रकै",
"ट्रान्सफरहरूझैं",
"मन्त्रीज्यूविरुद्ध"};*/

	}
	
	@Test
	public void test_repalce_matras_001() {
		String input = "मन्त्री";
		String output = NepaliStemmer.replaceMatras(input);
		
		Assert.assertThat(output, is("मनतर"));
	}
	
	@Test
	public void test_repalce_matras_002() {
		String input = "ट्रान्सफर";
		String output = NepaliStemmer.replaceMatras(input);
		
		Assert.assertThat(output, is("टरनसफर"));
	}
	
    @Test
    public void test_get_verb_root() {
        String input = "खानु";
        String output = NepaliStemmer.getVerbRoot(input);
        String expected = "खा";
        Assert.assertThat(output, is(expected));
        
    }
    @Test
    public void test_get_verb_variations_001_ending_in_nu() {
        String input = "खानु";
        String output = NepaliStemmer.getVerbVariations(input).toString();
        String expected = "[खा, खानु, खाएँ, खायो, खाएको, खाएछ, खाए, खाईन, खाईस, खानुभयो, खाई, खाऊ, खायौ, खाइछे, खाएछ, खानोस, खानुस, खानुहोस, खानेछु, खानुहुनेछ, खानेछन, खान्छन, खान्छिन, खान्छु, खान्छे, खान्छ, खानेछौ, खानेछिन, खानेछ, खानुहुनेछ]";
        Assert.assertThat(output, is(expected));
        
    }
    
    
    @Test
    public void test_get_verb_variations_002_ending_in_unu() {
        String input = "रमाउनु";
        String output = NepaliStemmer.getVerbVariations(input).toString();
        String expected = "[रमा, रमाउनु, रमाएँ, रमायो, रमाएको, रमाएछ, रमाए, रमाईन, रमाईस, रमाउनुभयो, रमाई, रमाऊ, रमायौ, रमाइछे, रमाएछ, रमाउनोस, रमाउनुस, रमाउनुहोस, रमाउनेछु, रमाउनुहुनेछ, रमाउनेछन, रमाउँछन, रमाउँछिन, रमाउँछु, रमाउँछे, रमाउँछ, रमाउनेछौ, रमाउनेछिन, रमाउनेछ, रमाउनुहुनेछ]";
        Assert.assertThat(output, is(expected));
        
    }
    
    @Test
    public void test_get_verb_variations_003_ending_in_half_letter_plus_nu() {
        String input = "चल्नु";
        String output = NepaliStemmer.getVerbVariations(input).toString();
        String expected = "[चल्, चल्नु, चल्एँ, चल्यो, चल्एको, चल्एछ, चल्ए, चल्ईन, चल्ईस, चल्नुभयो, चल्ई, चल्ऊ, चल्यौ, चल्इछे, चल्एछ, चल्नोस, चल्नुस, चल्नुहोस, चल्नेछु, चल्नुहुनेछ, चल्नेछन, चल्न्छन, चल्न्छिन, चल्न्छु, चल्न्छे, चल्न्छ, चल्नेछौ, चल्नेछिन, चल्नेछ, चल्नुहुनेछ]";

        Assert.assertThat(output, is(expected));
        
    }
														

	 

}
