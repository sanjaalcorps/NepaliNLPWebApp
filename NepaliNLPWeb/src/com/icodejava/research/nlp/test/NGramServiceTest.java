package com.icodejava.research.nlp.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icodejava.research.nlp.domain.NGram;
import com.icodejava.research.nlp.domain.Sentence;
import com.icodejava.research.nlp.services.NGramService;

public class NGramServiceTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void test_createBigramForwardWithNoStopWord() {
		Sentence sentence = new Sentence("उनीहरुलाई सघाउने साइकोलोजिस्ट, सामाजिक कार्यकर्ता, ‘अकुपेसनल थेरापिस्ट’ र ‘मेन्टल हेल्थ नर्स’ जरुरी हुन्छ");
		List<Sentence> input = new ArrayList<Sentence>();
		input.add(sentence);
		List<NGram> output = NGramService.createBigramForwardWithNoStopWord(input);

		System.out.println(output);

		fail("Not yet implemented");

	}

	@Test
	public void test_createBigramBackwardWithNoStopWord() {
		Sentence sentence = new Sentence("उनीहरुलाई सघाउने साइकोलोजिस्ट, सामाजिक कार्यकर्ता, ‘अकुपेसनल थेरापिस्ट’ र ‘मेन्टल हेल्थ नर्स’ जरुरी हुन्छ");
		List<Sentence> input = new ArrayList<Sentence>();
		input.add(sentence);
		List<NGram> output = NGramService.createBigramBackwardWithNoStopWord(input);

		System.out.println(output);

		fail("Not yet implemented");

	}

	@Test
	public void test_createTrigramForwardWithNoStopWord() {
		Sentence sentence = new Sentence("उनीहरुलाई सघाउने साइकोलोजिस्ट, सामाजिक कार्यकर्ता, ‘अकुपेसनल थेरापिस्ट’ र ‘मेन्टल हेल्थ नर्स’ जरुरी हुन्छ");
		List<Sentence> input = new ArrayList<Sentence>();
		input.add(sentence);
		List<NGram> output = NGramService.createTrigramForwardWithNoStopWord(input);

		System.out.println(output);

		fail("Not yet implemented");

	}

	@Test
	public void test_createTrigramBackwardWithNoStopWord() {
		Sentence sentence = new Sentence("उनीहरुलाई सघाउने साइकोलोजिस्ट, सामाजिक कार्यकर्ता, ‘अकुपेसनल थेरापिस्ट’ र ‘मेन्टल हेल्थ नर्स’ जरुरी हुन्छ");
		List<Sentence> input = new ArrayList<Sentence>();
		input.add(sentence);
		List<NGram> output = NGramService.createTrigramBackwardWithNoStopWord(input);

		System.out.println(output);

		fail("Not yet implemented");

	}

}
