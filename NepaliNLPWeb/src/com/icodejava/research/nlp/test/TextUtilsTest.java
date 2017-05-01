package com.icodejava.research.nlp.test;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

import com.icodejava.research.nlp.utils.TextUtils;

public class TextUtilsTest {

    @Test
    public void test_word_removal_middle_word() {
        String input = "उनी नेपाल आउनुसँग एउटो संयोग छ";
        String output = TextUtils.removeWord(input, "एउटो");
        String expected = "उनी नेपाल आउनुसँग संयोग छ";
        
        Assert.assertThat(output, is(expected));
    }
    
    @Test
    public void test_word_removal_starting_word() {
        String input = "उनी नेपाल आउनुसँग एउटो संयोग छ";
        String output = TextUtils.removeWord(input, "उनी");
        String expected = "नेपाल आउनुसँग एउटो संयोग छ";
        
        Assert.assertThat(output, is(expected));
    }
    
    @Test
    public void test_word_removal_ending_word() {
        String input = "उनी नेपाल आउनुसँग एउटो संयोग छ";
        String output = TextUtils.removeWord(input, "छ");
        String expected = "उनी नेपाल आउनुसँग एउटो संयोग";
        
        Assert.assertThat(output, is(expected));
    }
    
    @Test
    public void test_word_removal_multiple_occurrence() {
        String input = "उनी नेपाल आउनुसँग एउटो संयोग छ छ";
        String output = TextUtils.removeWord(input, "छ");
        String expected = "उनी नेपाल आउनुसँग एउटो संयोग";
        
        Assert.assertThat(output, is(expected));
    }

}
