package com.icodejava.research.nlp.summarizer;
//some idea based on
//https://github.com/bibhuticoder/nepali-summarizer/blob/master/js/summary.js
public class NepaliTextSummarizer {
	
	
	
	//SUMMARIZER 
//	public static string split_into_paragraphs(String content){   
//	  return(content.split("\n\n").map(function(p){
//	    return(p.trim())
//	  }));
//	}
//
//	function split_into_sentences(s){
//	  var s = s.split('।');
//	  s.pop();
//	  return(s);
//	}

//	function sentences_insersection(String sent1, String sent2){
//	  String [] s1 = set(sent1.split(" "));
//	  String [] s2 = set(sent2.split(" "));
//	  if(s1.length + s2.length === 0) return 0;
//	  return(intersection(s1, s2)/((s1.length+s2.length)/2));
//	}
//
//	function format_sentence(sent){
//	  var s = sent.replace(/\W+/g, "");
//	  return s;
//	}
//
//	public static String [] set(String [] arr){
//	  String [] n =[];
//	  for(var i=0; i<arr.length; i++){
//	    if(n.indexOf(arr[i]) < 0){
//	      n.push(arr[i]);
//	    }
//	  }
//	  return n;
//	}
//
//	function intersection(arr1, arr2){
//	  var l1 = arr1.length; 
//	  var inter = 0;
//	  for(var i=0; i<l1; i++){
//	    if(arr2.indexOf(arr1[i]) >= 0)inter++;
//	  }
//	  return inter;
//	}
//
//	function get_sentences_rank(content){
//	  var sentences = split_into_sentences(content);
//	  var len = sentences.length;  
//	  var values = [];
//	  for(var i=0; i<len; i++){
//	    values.push([]);
//	    for(var j=0; j<len; j++){
//	      values[i].push(null);
//	      values[i][j] = sentences_insersection(sentences[i], sentences[j]);
//	    }    
//	  }
//
//	  //build the dictionary
//	  var dict = {};
//	  for(var i=0; i<len; i++){   
//	    var score = 0; 
//	    for(var j=0; j<len; j++){
//	      if(i === j) continue;
//	      score += values[i][j]; 
//	    }
//	    dict[format_sentence(sentences[i])] = score;
//	  }
//
//	  return dict;
//	}
//
//	public static String get_best_sentence(String paragraph, String [] dict){
//	  String [] sentences = split_into_sentences(paragraph);
//	  //ignore short sentences
//	  if(sentences.length < 2) return "";
//	  //get best sentences according to sentence dictonary
//	  String best_sentence = "";
//	  var max_value = 0;
//	  for(var i = 0; i<sentences.length; i++){
//	    var s = sentences[i];
//	    var strip = format_sentence(s);
//	    if(dict[strip] > max_value){
//	      max_value = dict[strip];
//	      best_sentence = s;
//	    }
//	  }
//	  return best_sentence;
//	}
//
//	function get_summary(content){
//	  var paragraphs = split_into_paragraphs(content);
//	  var dict = get_sentences_rank(content);
//	  var summary = "";
//	  for(var i=0; i<paragraphs.length; i++){
//	    var s = get_best_sentence(paragraphs[i], dict);
//	    if(s){
//	      summary += "\n" + s + "। ";
//	    }
//	  }
//	  return summary;
//	}

}
