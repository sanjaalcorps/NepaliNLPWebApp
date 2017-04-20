package com.icodejava.research.nlp.test;

import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
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
		map.put("क्षेत्रकाहरूकै", "");
		map.put("स्त्रीहरुमाथि", "स्त्री");
		map.put("क्रान्तिकारीहरुमा", "क्रान्तिकारी");

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

"टुकीकै",
"ओबामादेखि",
"संसद्सम्मै",
"देखापरेकै",
"अमेरिकाजस्तो",
"सम्भावनाहरूप्रति",
"सिपाहीहरूमध्ये",
"श्लोकहरूकै",
"नीकै",
"परिवारजनसंग",
"बेलेकै",
"संशोधनपूर्वकै",
"खेलेजस्तो",
"चौकीभित्रसमेत",
"छिरिक्कै",
"अप्लाइ",
"आत्माबिहिन",
"उचालेकै",
"भुकै",
"बेसहाराहरुलाइ",
"नागरिकहरुलाइ",
"पाण्डेज्युहरू",
"छिमेकीहरुसित",
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
														

	 

}
