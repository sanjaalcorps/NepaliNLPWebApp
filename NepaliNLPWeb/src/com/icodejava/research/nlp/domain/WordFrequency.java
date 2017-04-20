package com.icodejava.research.nlp.domain;
public class WordFrequency<T> implements Comparable<Integer> {

    String word;
    Integer frequency;

    public WordFrequency(String word, Integer frequency) {

        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {

        return word ;
    }

    public void setWord(String word) {

        this.word = word;
    }

    public Integer getFrequency() {

        return frequency ;
    }

    public void setFrequency(Integer frequency) {

        this.frequency = frequency;
    }

    @Override
    public int compareTo(Integer value) {

        return this .frequency .compareTo(value);
    }

    public String toString() {
        //return getWord() + "{"+getWord().length()+"}"+ " -> " + getFrequency();
        return getWord() +  " -> " + getFrequency() +"\n";
    }

}