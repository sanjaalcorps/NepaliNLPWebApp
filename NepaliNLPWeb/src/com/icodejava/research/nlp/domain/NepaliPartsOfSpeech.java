package com.icodejava.research.nlp.domain;

public enum NepaliPartsOfSpeech {
	
	  ADJECTIVE( "JJ" , "" , "" ),
	  ADJECTIVE_COMPARATIVE( "JJR" , "" , "" ),
	  ADJECTIVE_SUPERLATIVE( "JJS" , "" , "" ),
	  ADVERB( "RB" , "" , "" ),
	  ADVERB_COMPARATIVE( "RBR" , "" , "" ),
	  ADVERB_SUPERLATIVE( "RBS" , "" , "" ),
	  ADVERB_WH( "WRB" , "" , "" ),
	  CONJUNCTION_COORDINATING( "CC" , "" , "" ),
	  CONJUNCTION_SUBORDINATING( "IN" , "" , "" ),
	  CARDINAL_NUMBER( "CD" , "" , "" ),
	  DETERMINER( "DT" , "" , "" ),
	  DETERMINER_WH( "WDT" , "" , "" ),
	  EXISTENTIAL_THERE( "EX" , "" , "" ),
	  FOREIGN_WORD( "FW" , "" , "" ),
	  LIST_ITEM_MARKER( "LS" , "" , "" ),
	  NOUN( "NN" , "" , "" ),
	  NOUN_PLURAL( "NNS" , "" , "" ),
	  NOUN_PROPER_SINGULAR( "NNP" , "" , "" ),
	  NOUN_PROPER_PLURAL( "" , "" , "" ),
	  PREDETERMINER( "PDT" , "" , "" ),
	  POSSESSIVE_ENDING( "POS" , "" , "" ),
	  PRONOUN_PERSONAL( "PRP" , "" , "" ),
	  PRONOUN_POSSESSIVE( "PRP$" , "" , "" ),
	  PRONOUN_POSSESSIVE_WH( "WP$" , "" , "" ),
	  PRONOUN_WH( "WP" , "" , "" ),
	  PARTICLE( "RP" , "" , "" ),
	  SYMBOL( "SYM" , "" , "" ),
	  TO( "TO" , "" , "" ),
	  INTERJECTION( "UH" , "" , "" ),
	  VERB( "VB" , "" , "" ),
	  VERB_PAST_TENSE( "VBD" , "" , "" ),
	  VERB_PARTICIPLE_PRESENT( "VBG" , "" , "" ),
	  VERB_PARTICIPLE_PAST( "VBN" , "" , "" ),
	  VERB_SINGULAR_PRESENT_NONTHIRD_PERSON( "VBP" , "" , "" ),
	  VERB_SINGULAR_PRESENT_THIRD_PERSON( "VBZ" , "" , "" ),
	  VERB_MODAL( "MD" , "" , "" ),
	  SENTENCE_TERMINATOR( "।", "" , "" ),
	  SENTENCE_TERMINATOR_QUESTION_MARK("?","",""),
	  SENTENCE_TERMINATOR_EXCLAMATION_MARK("!","","");	
	  

	  private final String tag;

	  private NepaliPartsOfSpeech( String tag, String nepaliName, String nepaliTag ) {
	    this.tag = tag;
	  }

	  public String toString() {
	    return getTag();
	  }

	  public String getTag() {
	    return this.tag;
	  }

	  public static NepaliPartsOfSpeech get( String value ) {
	    for( NepaliPartsOfSpeech v : values() ) {
	      if( value.equals( v.getTag() ) ) {
	        return v;
	      }
	    }

	    throw new IllegalArgumentException( "Unknown part of speech: '" + value + "'." );
	  }

}
