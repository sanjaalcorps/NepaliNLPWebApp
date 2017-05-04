package com.icodejava.research.nlp.stemmer;

import java.util.ArrayList;
import java.util.List;

import com.icodejava.research.nlp.domain.CompoundWordEnding;
import com.icodejava.research.nlp.domain.Grammar;
import com.icodejava.research.nlp.utils.TextUtils;

/**
 * 
 * @author Kushal Paudyal www.sanjaal.com | www.inepal.org | www.icodejava.com
 * 
 *         Stemmer Class for Nepali Words
 * 
 *         Stemming is a process of finding the root word from a compound word.
 *         e.g. "स्थानलगायत" is stemmed to "स्थान"
 *
 */
public class NepaliStemmer {
	
	public static void main(String [] args) {
		getNepaliRootWord("समयभन्दा");
	}

	/**
	 * This method finds a root word for a given compound Nepali Word. 
	 * For example: "स्थानलगायत" is stemmed to "स्थान"
	 * 
	 * @param compoundWord
	 * @return root word
	 */
	public static String getNepaliRootWord(String compoundWord) {
		for (CompoundWordEnding dir : CompoundWordEnding.values()) {
			String cwe = dir.getNepaliWordEnding();

			if (compoundWord.endsWith(cwe) && isNotTheSameWord(compoundWord, cwe)
					&& isAllowedLength(compoundWord, cwe)) {
				compoundWord = TextUtils.replaceLast(compoundWord, cwe, "");
			}

		}

		compoundWord = compoundWord.trim();

		return compoundWord;
	}

    /**
     * Checks if two words are same. For example, we want to no more apply the
     * stemming rule if the word is लगायत although लगायत is a compound word
     * ending and would have been removed from other compound words
     * 
     * @param compoundWord
     * @param cwe
     * @return
     */
    private static boolean isNotTheSameWord(String compoundWord, String cwe) {
        return compoundWord.length() > cwe.length();
    }

	private static boolean isAllowedLength(String compoundWord, String cwe) {
		
		boolean allowed = true;
		
		String cweMatraReplaced = replaceMatras(cwe);
		
		if(cweMatraReplaced.length() == 1) {
			String matraReplacedWord = replaceMatras(TextUtils.replaceLast(compoundWord, cwe, "")); //TODO: Document this
			allowed = matraReplacedWord.length() > 2; //to prvent words like थुम्का being split as थुम् + का
			
		}
		
		return allowed;
	}

	/**
	 * This method takes a Nepali Word, repalces all the matras and returns the
	 * transformed word. e.g. ट्रान्सफर --> टरनसफर
	 * 
	 * @param word
	 * @return
	 */
	public static String replaceMatras(String word) {

		for (Character c : Grammar.SET_OF_MATRAS.toCharArray()) {
			word = word.replace(c + "", "");
		}

		return word;
	}
	
	/**
	 * 
	 * @param word
	 * @return
	 */
	public static List<String> getVerbVariations(String wordEndingInNU) {
	    List<String> verbVariations = new ArrayList<String>();
	    
	    if(wordEndingInNU == null) {
	        return verbVariations;
	    }
	    
	    String root = getVerbRoot(wordEndingInNU); //NU 
	    
	    //[चल्, चल्नु, चल्एँ, चल्यो, चल्एको, चल्एछ, चल्ए, चल्ईन, चल्ईस, चल्नुभयो, चल्ई, चल्ऊ, चल्यौ, चल्इछे, चल्एछ, चल्नोस, चल्नुस, चल्नुहोस, चल्नेछु, चल्नुहुनेछ, चल्नेछन, चल्न्छन, चल्न्छिन, चल्न्छु, चल्न्छे, चल्न्छ, चल्नेछौ, चल्नेछिन, चल्नेछ, चल्नुहुनेछ]

	    
	    verbVariations.add(root); //खा, रमा
	    verbVariations.add(wordEndingInNU); //खानु,रमाउनु
	    verbVariations.add(root + "एँ"); //खाएँ, रमाएँ
	    verbVariations.add(root + "यो"); //खायो, रमायो
	    verbVariations.add(root + "एको");  //खाएको, रमाएको
	    verbVariations.add(root + "एछ"); //खाएछ, रमाएछ
	    verbVariations.add(root + "ए");//खाए, रमाए
	    verbVariations.add(root + "ईन");//खाईन, रमाईन
	    verbVariations.add(root + "ईस"); //खाईस, रमाईस
	    verbVariations.add(wordEndingInNU + "भयो"); //खानुभयो, रमाउनुभयो
	    verbVariations.add(root + "ई"); // खाई, रमाई
	    verbVariations.add(root + "ऊ");//खाऊ, रमाऊ
	    verbVariations.add(root + "यौ"); //खायौ, रमायौ
	    verbVariations.add(root + "इछे"); //खाइछे, रमाइछे
	    verbVariations.add(root + "एछ"); //खाएछ, रमाएछ
	    
	    if(wordEndingInNU.endsWith("उनु")) {
	    	System.out.println("Here");
	    	verbVariations.add(root + "उनोस");//ramaunos
	    	verbVariations.add(root + "उनुस"); //Ramaunus
	    	verbVariations.add(root + "उनुहोस"); //ramaunuhos
	    	verbVariations.add(root + "उनेछु"); //ramaunechhu
		    verbVariations.add(root + "उनुहुनेछ");//ramaunuhunechha
		    verbVariations.add(root + "उनेछन");//ramaunechhan
		    verbVariations.add(root + "उँछन");//ramaunechhan
		    verbVariations.add(root + "उँछिन");//ramaunchhin
		    verbVariations.add(root + "उँछु"); //ramaunchhu
		    verbVariations.add(root + "उँछे"); //ramaunchhe
		    verbVariations.add(root + "उँछ"); //ramaunchha
		    verbVariations.add(root + "उनेछौ"); //ramaunechhau
		    verbVariations.add(root + "उनेछिन"); //ramaunechhin
		    verbVariations.add(root + "उनेछ"); //ramaunechha
		    verbVariations.add(root + "उनुहुनेछ"); //ramaunuhunechha

	    } else if(wordEndingInNU.endsWith("नु"))  {
	    	verbVariations.add(root + "नोस"); //खानोस
	    	verbVariations.add(root + "नुस"); //खानुस
	    	verbVariations.add(root + "नुहोस"); //खानुहोस
	    	verbVariations.add(root + "नेछु"); //खानेछु
		    verbVariations.add(root + "नुहुनेछ");//खानुहुनेछ
		    verbVariations.add(root + "नेछन");//खानेछन
		    verbVariations.add(root + "न्छन");//खान्छन
		    verbVariations.add(root + "न्छिन");//खान्छिन
		    verbVariations.add(root + "न्छु"); //खान्छु
		    verbVariations.add(root + "न्छे"); //खान्छे
		    verbVariations.add(root + "न्छ"); //खान्छ
		    verbVariations.add(root + "नेछौ"); //खानेछौ
		    verbVariations.add(root + "नेछिन"); //खानेछिन
		    verbVariations.add(root + "नेछ"); //खानेछ
		    verbVariations.add(root + "नुहुनेछ"); //खानुहुनेछ
	    }

	    
	    
	    //TODO: Implement the following
	    //KHAUNJEL, RAMAUNJEL, CHALUNJEN, THAGUNJEL
	    //khainu, ramainu, chalinu, thaginu
	    //khayera, ramayera, chalera, thagiyera
	    
	    
	    System.out.println(verbVariations);
	    return verbVariations;
	    
	}

    public static String getVerbRoot(String wordEndingInNU) {
        if(wordEndingInNU == null || !wordEndingInNU.endsWith("नु") || wordEndingInNU.indexOf(" ") >0) {
            System.out.println("Invalid Word or Word Ending " + wordEndingInNU + " Verb must end in: नु");
            return wordEndingInNU;
        }
        
        String wordWithoutNU ="";
        if(wordEndingInNU.endsWith("उनु")) {
            wordWithoutNU = TextUtils.replaceLast(wordEndingInNU, "उनु", "");
        } else if (wordEndingInNU.endsWith("नु")) {
            wordWithoutNU = TextUtils.replaceLast(wordEndingInNU, "नु", "");
        }
        
        System.out.println(wordWithoutNU);
        
        return wordWithoutNU;
    }

}
