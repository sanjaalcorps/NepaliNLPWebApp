package com.icodejava.research.nlp.services;

import java.util.List;

import com.icodejava.research.nlp.utils.DevanagariUnicodeToRomanEnglish;
import com.icodejava.research.nlp.utils.FileUtilities;

public class RomanizationService {
    
    public static void main(String args []) {
        romizeWordsAndStore("src/com/icodejava/research/nlp/sources/temp/temp_romanization.txt");
    }

    private static void romizeWordsAndStore(String fileName) {
        List<String> words = FileUtilities.readUTF8FileAsList(fileName);
        
        for(String word:words) {
            
            
            
            
            WordsUnreferencedService.updateRomanizationISO(word, DevanagariUnicodeToRomanEnglish.convertWord(word));
        }
    }

}
