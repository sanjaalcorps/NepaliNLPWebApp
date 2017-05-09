package com.icodejava.research.nlp.test;
/**
 * @author Kushal Paudyal
 * @web www.icodejava.com | www.inepal.org| www.sanjaal.com
 * @Purpose: Testing NGramService.java
 * @Created: 5/1/2017
 * @Modified: 5/8/2017
  */
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
    public void test_monograms() {
        String expected = "[विगत, अनुभवका, आधारमा, एउटा, सानो, मतदान, केन्द्रमा, मतदान, अधिकृत, सहायक, मतदान, अधिकृत, कर्मचारी, र, सुरक्षाकर्मी, गरी, कम्तीमा, ६, जना, खटाइन्थ्यो]";
        String output = NGramGenerator.generateMonograms(input).toString();
        Assert.assertThat(output, is(expected));
    }

    @Test
    public void test_forward_bigrams_with_stop_words() {
        String expected = "[विगत अनुभवका, अनुभवका आधारमा, आधारमा एउटा, एउटा सानो, सानो मतदान, मतदान केन्द्रमा, केन्द्रमा मतदान, मतदान अधिकृत, अधिकृत सहायक, सहायक मतदान, मतदान अधिकृत, अधिकृत कर्मचारी, कर्मचारी र, र सुरक्षाकर्मी, सुरक्षाकर्मी गरी, गरी कम्तीमा, कम्तीमा ६, ६ जना, जना खटाइन्थ्यो]";
        String output = NGramGenerator.generateForwardBigramsWithStopWords(input).toString();
        Assert.assertThat(output, is(expected));

    }

    @Test
    public void test_backward_bigrams_with_stop_words() {
        String expected = "[अनुभवका विगत, आधारमा अनुभवका, एउटा आधारमा, सानो एउटा, मतदान सानो, केन्द्रमा मतदान, मतदान केन्द्रमा, अधिकृत मतदान, सहायक अधिकृत, मतदान सहायक, अधिकृत मतदान, कर्मचारी अधिकृत, र कर्मचारी, सुरक्षाकर्मी र, गरी सुरक्षाकर्मी, कम्तीमा गरी, ६ कम्तीमा, जना ६, खटाइन्थ्यो जना]";
        String output = NGramGenerator.generateBackwardBigramsWithStopWords(input).toString();
        Assert.assertThat(output, is(expected));

    }

    @Test
    public void test_skipBigrams_forward_with_stop_words() {
        String expected = "[विगत आधारमा, अनुभवका एउटा, आधारमा सानो, एउटा मतदान, सानो केन्द्रमा, मतदान मतदान, केन्द्रमा अधिकृत, मतदान सहायक, अधिकृत मतदान, सहायक अधिकृत, मतदान कर्मचारी, अधिकृत र, कर्मचारी सुरक्षाकर्मी, र गरी, सुरक्षाकर्मी कम्तीमा, गरी ६, कम्तीमा जना, ६ खटाइन्थ्यो]";
        String output = NGramGenerator.generateSkipBigramsForwardWithStopWords(input).toString();
        Assert.assertThat(output, is(expected));
    }

    @Test
    public void test_skipBigrams_backward_with_stop_words() {
        String expected = "[खटाइन्थ्यो ६, जना कम्तीमा, ६ गरी, कम्तीमा सुरक्षाकर्मी, गरी र, सुरक्षाकर्मी कर्मचारी, र अधिकृत, कर्मचारी मतदान, अधिकृत सहायक, मतदान अधिकृत, सहायक मतदान, अधिकृत केन्द्रमा, मतदान मतदान, केन्द्रमा सानो, मतदान एउटा, सानो आधारमा, एउटा अनुभवका, आधारमा विगत]";
        String output = NGramGenerator.generateSkipBigramsBackwardWithStopWords(input).toString();
        Assert.assertThat(output, is(expected));
    }

    @Test
    public void test_forward_bigrams_with_no_stop_words() {
        String expected = "[विगत अनुभवका, अनुभवका आधारमा, आधारमा सानो, सानो मतदान, मतदान केन्द्रमा, केन्द्रमा मतदान, मतदान अधिकृत, अधिकृत सहायक, सहायक मतदान, मतदान अधिकृत, अधिकृत कर्मचारी, कर्मचारी सुरक्षाकर्मी, सुरक्षाकर्मी कम्तीमा, कम्तीमा खटाइन्थ्यो]";
        String output = NGramGenerator.generateForwardBigramsWithNoStopWords(input).toString();
        Assert.assertThat(output, is(expected));

    }

    @Test
    public void test_backward_bigrams_with_no_stop_words() {
        String expected = "[अनुभवका विगत, आधारमा अनुभवका, सानो आधारमा, मतदान सानो, केन्द्रमा मतदान, मतदान केन्द्रमा, अधिकृत मतदान, सहायक अधिकृत, मतदान सहायक, अधिकृत मतदान, कर्मचारी अधिकृत, सुरक्षाकर्मी कर्मचारी, कम्तीमा सुरक्षाकर्मी, खटाइन्थ्यो कम्तीमा]";
        String output = NGramGenerator.generateBackwardBigramsWithNoStopWords(input).toString();
        Assert.assertThat(output, is(expected));

    }

    @Test
    public void test_skipBigrams_forward_with_no_stop_words() {
        String expected = "[विगत आधारमा, अनुभवका एउटा, आधारमा सानो, एउटा मतदान, सानो केन्द्रमा, मतदान मतदान, केन्द्रमा अधिकृत, मतदान सहायक, अधिकृत मतदान, सहायक अधिकृत, मतदान कर्मचारी, अधिकृत र, कर्मचारी सुरक्षाकर्मी, र गरी, सुरक्षाकर्मी कम्तीमा, गरी ६, कम्तीमा जना, ६ खटाइन्थ्यो]";
        String output = NGramGenerator.generateSkipBigramsForwardWithNoStopWords(input).toString();
        Assert.assertThat(output, is(expected));
    }

    @Test
    public void test_skipBigrams_backward_with_no_stop_words() {
        String expected = "[खटाइन्थ्यो ६, जना कम्तीमा, ६ गरी, कम्तीमा सुरक्षाकर्मी, गरी र, सुरक्षाकर्मी कर्मचारी, र अधिकृत, कर्मचारी मतदान, अधिकृत सहायक, मतदान अधिकृत, सहायक मतदान, अधिकृत केन्द्रमा, मतदान मतदान, केन्द्रमा सानो, मतदान एउटा, सानो आधारमा, एउटा अनुभवका, आधारमा विगत]";
        String output = NGramGenerator.generateSkipBigramsBackwardWithNoStopWords(input).toString();
        Assert.assertThat(output, is(expected));
    }

    @Test
    public void test_forward_trigrams_with_stop_words() {
        String expected = "[विगत अनुभवका आधारमा, अनुभवका आधारमा एउटा, आधारमा एउटा सानो, एउटा सानो मतदान, सानो मतदान केन्द्रमा, मतदान केन्द्रमा मतदान, केन्द्रमा मतदान अधिकृत, मतदान अधिकृत सहायक, अधिकृत सहायक मतदान, सहायक मतदान अधिकृत, मतदान अधिकृत कर्मचारी, अधिकृत कर्मचारी र, कर्मचारी र सुरक्षाकर्मी, र सुरक्षाकर्मी गरी, सुरक्षाकर्मी गरी कम्तीमा, गरी कम्तीमा ६, कम्तीमा ६ जना, ६ जना खटाइन्थ्यो]";
        String output = NGramGenerator.generateForwardTrigramsWithStopWords(input).toString();
        Assert.assertThat(output, is(expected));
    }

    @Test
    public void test_forward_trigrams_with_no_stop_words() {
        String expected = "[विगत अनुभवका आधारमा, अनुभवका आधारमा सानो, आधारमा सानो मतदान, सानो मतदान केन्द्रमा, मतदान केन्द्रमा मतदान, केन्द्रमा मतदान अधिकृत, मतदान अधिकृत सहायक, अधिकृत सहायक मतदान, सहायक मतदान अधिकृत, मतदान अधिकृत कर्मचारी, अधिकृत कर्मचारी सुरक्षाकर्मी, कर्मचारी सुरक्षाकर्मी कम्तीमा, सुरक्षाकर्मी कम्तीमा खटाइन्थ्यो]";
        String output = NGramGenerator.generateForwardTrigramsWithNoStopWords(input).toString();
        Assert.assertThat(output, is(expected));
    }

    @Test
    public void test_backward_trigrams_with_stop_words() {
        String expected = "[आधारमा अनुभवका विगत, एउटा आधारमा अनुभवका, सानो एउटा आधारमा, मतदान सानो एउटा, केन्द्रमा मतदान सानो, मतदान केन्द्रमा मतदान, अधिकृत मतदान केन्द्रमा, सहायक अधिकृत मतदान, मतदान सहायक अधिकृत, अधिकृत मतदान सहायक, कर्मचारी अधिकृत मतदान, र कर्मचारी अधिकृत, सुरक्षाकर्मी र कर्मचारी, गरी सुरक्षाकर्मी र, कम्तीमा गरी सुरक्षाकर्मी, ६ कम्तीमा गरी, जना ६ कम्तीमा, खटाइन्थ्यो जना ६]";
        String output = NGramGenerator.generateBackwardTrigramsWithStopWords(input).toString();
        Assert.assertThat(output, is(expected));
    }

    @Test
    public void test_backward_trigrams_with_no_stop_words() {
        String expected = "[आधारमा अनुभवका विगत, सानो आधारमा अनुभवका, मतदान सानो आधारमा, केन्द्रमा मतदान सानो, मतदान केन्द्रमा मतदान, अधिकृत मतदान केन्द्रमा, सहायक अधिकृत मतदान, मतदान सहायक अधिकृत, अधिकृत मतदान सहायक, कर्मचारी अधिकृत मतदान, सुरक्षाकर्मी कर्मचारी अधिकृत, कम्तीमा सुरक्षाकर्मी कर्मचारी, खटाइन्थ्यो कम्तीमा सुरक्षाकर्मी]";
        String output = NGramGenerator.generateBackwardTrigramsWithNoStopWords(input).toString();
        Assert.assertThat(output, is(expected));
    }
}
