package com.icodejava.research.nlp.test;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icodejava.research.nlp.ngram.NGramGenerator;

public class NGramGeneratorTest {
	
	static String input = null;
	
	@Before
	public void setup() {
		input = "विगत अनुभवका आधारमा एउटा सानो मतदान केन्द्रमा मतदान अधिकृत, सहायक मतदान अधिकृत, कर्मचारी र सुरक्षाकर्मी गरी कम्तीमा ६ जना खटाइन्थ्यो";
	}
	
	@Test
	public void test_forward_bigrams() {
		String expected = "[विगत अनुभवका, अनुभवका आधारमा, आधारमा एउटा, एउटा सानो, सानो मतदान, मतदान केन्द्रमा, केन्द्रमा मतदान, मतदान अधिकृत, अधिकृत सहायक, सहायक मतदान, मतदान अधिकृत, अधिकृत कर्मचारी, कर्मचारी र, र सुरक्षाकर्मी, सुरक्षाकर्मी गरी, गरी कम्तीमा, कम्तीमा, जना, जना खटाइन्थ्यो]";
		String output = NGramGenerator.generateForwardBigrams(input).toString();
		Assert.assertThat(output, is(expected));
		
	}

	@Test
	public void test_backward_bigrams() {
		String expected = "[अनुभवका विगत, आधारमा अनुभवका, एउटा आधारमा, सानो एउटा, मतदान सानो, केन्द्रमा मतदान, मतदान केन्द्रमा, अधिकृत मतदान, सहायक अधिकृत, मतदान सहायक, अधिकृत मतदान, कर्मचारी अधिकृत, र कर्मचारी, सुरक्षाकर्मी र, गरी सुरक्षाकर्मी, कम्तीमा गरी, कम्तीमा, जना, खटाइन्थ्यो जना]";
		String output = NGramGenerator.generateBackwardBigrams(input).toString();
		Assert.assertThat(output, is(expected));
		
	}
	
	@Test
	public void test_skipBigrams_forward() {
		String expected = "[विगत आधारमा, अनुभवका एउटा, आधारमा सानो, एउटा मतदान, सानो केन्द्रमा, मतदान मतदान, केन्द्रमा अधिकृत,, मतदान सहायक, अधिकृत, मतदान, सहायक अधिकृत,, मतदान कर्मचारी, अधिकृत, र, कर्मचारी सुरक्षाकर्मी, र गरी, सुरक्षाकर्मी कम्तीमा, गरी ६, कम्तीमा जना, ६ खटाइन्थ्यो]";
		String output = NGramGenerator.generateSkipBigramsForward(input).toString();
		Assert.assertThat(output, is(expected));
	}
	
	@Test
	public void test_skipBigrams_backward() {
		String expected = "[खटाइन्थ्यो ६, जना कम्तीमा, ६ गरी, कम्तीमा सुरक्षाकर्मी, गरी र, सुरक्षाकर्मी कर्मचारी, र अधिकृत,, कर्मचारी मतदान, अधिकृत, सहायक, मतदान अधिकृत,, सहायक मतदान, अधिकृत, केन्द्रमा, मतदान मतदान, केन्द्रमा सानो, मतदान एउटा, सानो आधारमा, एउटा अनुभवका, आधारमा विगत]";
		String output = NGramGenerator.generateSkipBigramsBackward(input).toString();
		Assert.assertThat(output, is(expected));
	}
	
	

}
