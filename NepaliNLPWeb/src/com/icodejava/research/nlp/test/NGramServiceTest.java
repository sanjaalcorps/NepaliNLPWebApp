package com.icodejava.research.nlp.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.icodejava.research.nlp.domain.Sentence;
import com.icodejava.research.nlp.services.NGramService;

public class NGramServiceTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void test_createBigramForwardWithNoStopWord() {
		Sentence input = new Sentence("उनीहरुलाई सघाउने साइकोलोजिस्ट, सामाजिक कार्यकर्ता, ‘अकुपेसनल थेरापिस्ट’ र ‘मेन्टल हेल्थ नर्स’ जरुरी हुन्छ");
		Sentence output = NGramService.createBigramForwardWithNoStopWord(input);

		System.out.println(output.getnGrams());

		fail("Not yet implemented");

	}

	@Test
	public void test_createBigramBackwardWithNoStopWord() {
		Sentence input = new Sentence("उनीहरुलाई सघाउने साइकोलोजिस्ट, सामाजिक कार्यकर्ता, ‘अकुपेसनल थेरापिस्ट’ र ‘मेन्टल हेल्थ नर्स’ जरुरी हुन्छ");
		Sentence output = NGramService.createBigramBackwardWithNoStopWord(input);

		System.out.println(output.getnGrams());

		fail("Not yet implemented");

	}

	@Test
	public void test_createTrigramForwardWithNoStopWord() {
		Sentence input = new Sentence("उनीहरुलाई सघाउने साइकोलोजिस्ट, सामाजिक कार्यकर्ता, ‘अकुपेसनल थेरापिस्ट’ र ‘मेन्टल हेल्थ नर्स’ जरुरी हुन्छ");
		Sentence output = NGramService.createTrigramForwardWithNoStopWord(input);

		System.out.println(output.getnGrams());

		fail("Not yet implemented");

	}

	@Test
	public void test_createTrigramBackwardWithNoStopWord() {
		Sentence input = new Sentence("उनीहरुलाई सघाउने साइकोलोजिस्ट, सामाजिक कार्यकर्ता, ‘अकुपेसनल थेरापिस्ट’ र ‘मेन्टल हेल्थ नर्स’ जरुरी हुन्छ");
		Sentence output = NGramService.createTrigramBackwardWithNoStopWord(input);

		System.out.println(output.getnGrams());

		fail("Not yet implemented");

	}

}
