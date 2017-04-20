package com.icodejava.research.nlp.domain;
/**
 * Represents the English parts-of-speech, encoded using the
 * de facto <a href="http://www.cis.upenn.edu/~treebank/">Penn Treebank
 * Project</a> standard.
 * 
 * @see <a href="ftp://ftp.cis.upenn.edu/pub/treebank/doc/tagguide.ps.gz">Penn Treebank Specification</a>
 */
public enum PartOfSpeech {
  ADJECTIVE( "JJ" ),
  ADJECTIVE_COMPARATIVE( ADJECTIVE + "R" ),
  ADJECTIVE_SUPERLATIVE( ADJECTIVE + "S" ),

  /* This category includes most words that end in -ly as well as degree
   * words like quite, too and very, posthead modi ers like enough and
   * indeed (as in good enough, very well indeed), and negative markers like
   * not, n't and never.
   */
  ADVERB( "RB" ),

  /* Adverbs with the comparative ending -er but without a strictly comparative
   * meaning, like <i>later</i> in <i>We can always come by later</i>, should
   * simply be tagged as RB.
   */
  ADVERB_COMPARATIVE( ADVERB + "R" ),
  ADVERB_SUPERLATIVE( ADVERB + "S" ),

  /* This category includes how, where, why, etc.
   */
  ADVERB_WH( "W" + ADVERB ),

  /* This category includes and, but, nor, or, yet (as in Y et it's cheap,
   * cheap yet good), as well as the mathematical operators plus, minus, less,
   * times (in the sense of "multiplied by") and over (in the sense of "divided
   * by"), when they are spelled out. <i>For</i> in the sense of "because" is
   * a coordinating conjunction (CC) rather than a subordinating conjunction.
   */
  CONJUNCTION_COORDINATING( "CC" ),
  CONJUNCTION_SUBORDINATING( "IN" ),
  CARDINAL_NUMBER( "CD" ),
  DETERMINER( "DT" ),

  /* This category includes which, as well as that when it is used as a
   * relative pronoun.
   */
  DETERMINER_WH( "W" + DETERMINER ),
  EXISTENTIAL_THERE( "EX" ),
  FOREIGN_WORD( "FW" ),

  LIST_ITEM_MARKER( "LS" ),

  NOUN( "NN" ),
  NOUN_PLURAL( NOUN + "S" ),
  NOUN_PROPER_SINGULAR( NOUN + "P" ),
  NOUN_PROPER_PLURAL( NOUN + "PS" ),

  PREDETERMINER( "PDT" ),
  POSSESSIVE_ENDING( "POS" ),

  PRONOUN_PERSONAL( "PRP" ),
  PRONOUN_POSSESSIVE( "PRP$" ),

  /* This category includes the wh-word whose.
   */
  PRONOUN_POSSESSIVE_WH( "WP$" ),

  /* This category includes what, who and whom.
   */
  PRONOUN_WH( "WP" ),

  PARTICLE( "RP" ),

  /* This tag should be used for mathematical, scientific and technical symbols
   * or expressions that aren't English words. It should not used for any and
   * all technical expressions. For instance, the names of chemicals, units of
   * measurements (including abbreviations thereof) and the like should be
   * tagged as nouns.
   */
  SYMBOL( "SYM" ),
  TO( "TO" ),

  /* This category includes my (as in M y, what a gorgeous day), oh, please,
   * see (as in See, it's like this), uh, well and yes, among others.
   */
  INTERJECTION( "UH" ),

  VERB( "VB" ),
  VERB_PAST_TENSE( VERB + "D" ),
  VERB_PARTICIPLE_PRESENT( VERB + "G" ),
  VERB_PARTICIPLE_PAST( VERB + "N" ),
  VERB_SINGULAR_PRESENT_NONTHIRD_PERSON( VERB + "P" ),
  VERB_SINGULAR_PRESENT_THIRD_PERSON( VERB + "Z" ),

  /* This category includes all verbs that don't take an -s ending in the
   * third person singular present: can, could, (dare), may, might, must,
   * ought, shall, should, will, would.
   */
  VERB_MODAL( "MD" ),

  /* Stanford.
   */
  SENTENCE_TERMINATOR( "." );

  private final String tag;

  private PartOfSpeech( String tag ) {
    this.tag = tag;
  }

  /**
   * Returns the encoding for this part-of-speech.
   * 
   * @return A string representing a Penn Treebank encoding for an English
   * part-of-speech.
   */
  public String toString() {
    return getTag();
  }

  protected String getTag() {
    return this.tag;
  }

  public static PartOfSpeech get( String value ) {
    for( PartOfSpeech v : values() ) {
      if( value.equals( v.getTag() ) ) {
        return v;
      }
    }

    throw new IllegalArgumentException( "Unknown part of speech: '" + value + "'." );
  }
}