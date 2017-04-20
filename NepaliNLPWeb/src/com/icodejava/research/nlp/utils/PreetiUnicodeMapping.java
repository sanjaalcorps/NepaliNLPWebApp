package com.icodejava.research.nlp.utils;

public class PreetiUnicodeMapping {

    public static final String [] preetiCharacterSet = { "ç", "˜" , "." , "'m" , "]m" , "Fmf" , "Fm", ")" , "!" ,
        "@", "#" , "$" , "%" , "^" , "&" , "*" , "(" , "k|m" , "em" , "km" , "Qm" ,
        "qm", "N˜" , "¡" , "¢" , "1" , "2" , "4" , ">" , "?" , "B" , "I" , "Q" , "ß" ,
        "q", "„" , "‹" , "•" , "›" , "§" , "°" , "¶" , "¿" , "Å" , "Ë" , "Ì" , "Í" ,
        "Î", "Ý" , "å" , "6«" , "7«" , "8«" , "9«" , "Ø" , "|" , "8Þ" , "9Þ" , "S" ,
        "s", "V" , "v" , "U" , "u" , "£" , "3" , "ª" , "R" , "r" , "5" , "H" , "h" ,
        "‰", "´" , "~" , "`" , "6" , "7" , "8" , "9" , "0" , "T" , "t" , "Y" , "y" ,
        "b", "W" , "w" , "G" , "g" , "K" , "k" , "ˆ" , "A" , "a" , "E" , "e" , "D" ,
        "d", "o" , "/" , "N" , "n" , "J" , "j" , "Z" , "z" , "i" , ":" , ";" , "X" ,
        "x", "cf‘" , "c‘f" , "cf}" , "cf]" , "cf" , "c" , "O{" , "O" , "pm" , "p" ,
        "C", "P]" , "P" , "f‘" , "\"" , "'" , "+" , "f" , "[" , "\\" , "]" , "}" ,
        "F", "L" , "M" , "्ा" , "्ो" , "्ौ" , "अो" , "अा" , "आै" , "आे" , "ाो" ,
        "ाॅ", "ाे" , "ंु" , "ेे" , "अै" , "ाे" , "अे" , "ंा" , "अॅ" , "ाै" , "ैा" ,
        "ंृ", "ँा" , "ँू" , "ेा" , "ंे" };

    public static final String [] unicodeCharacterSet = { "ॐ", "ऽ" , "।" , "m'" , "m]" , "mfF" , "mF", "०" , "१" ,
        "२", "३" , "४" , "५" , "६" , "७" , "८" , "९" , "फ्र" , "झ" , "फ" , "क्त" ,
        "क्र", "ल" , "ज्ञ्" , "द्घ" , "ज्ञ" , "द्द" , "द्ध" , "श्र" , "रु" , "द्य" ,
        "क्ष्" , "त्त" , "द्म" , "त्र" , "ध्र" , "ङ्घ" , "ड्ड" , "द्र" , "ट्ट" ,
        "ड्ढ", "ठ्ठ" , "रू" , "हृ" , "ङ्ग" , "त्र" , "ङ्क" , "ङ्ख" , "ट्ठ" , "द्व" ,
        "ट्र", "ठ्र" , "ड्र" , "ढ्र" , "्य" , "्र" , "ड़" , "ढ़" , "क्" , "क" ,
        "ख्", "ख" , "ग्" , "ग" , "घ्" , "घ" , "ङ" , "च्" , "च" , "छ" , "ज्" , "ज" ,
        "झ्", "झ" , "ञ्" , "ञ" , "ट" , "ठ" , "ड" , "ढ" , "ण्" , "त्" , "त" , "थ्" ,
        "थ", "द" , "ध्" , "ध" , "न्" , "न" , "प्" , "प" , "फ्" , "ब्" , "ब" , "भ्" ,
        "भ", "म्" , "म" , "य" , "र" , "ल्" , "ल" , "व्" , "व" , "श्" , "श" , "ष्" ,
        "स्", "स" , "ह्" , "ह" , "ऑ" , "ऑ" , "औ" , "ओ" , "आ" , "अ" , "ई" , "इ" , "ऊ" ,
        "उ", "ऋ" , "ऐ" , "ए" , "ॉ" , "ू" , "ु" , "ं" , "ा" , "ृ" , "्" , "े" , "ै" ,
        "ँ", "ी" , "ः" , "" , "े" , "ै" , "ओ" , "आ" , "औ" , "ओ" , "ो" , "ॉ" , "ो" ,
        "ुं", "े" , "अ‍ै" , "ो" , "अ‍े" , "ां" , "अ‍ॅ" , "ौ" , "ौ" , "ृं" , "ाँ" ,
        "ूँ", "ो" , "ें" };


    public static void main (String args []) {
//        String somePreetiText= "tkfO{+sf] sDKo\"6/df lk|tL kmG6 5" ;
//        System. out.println(convertToUnicode(somePreetiText));
        /*String someUnicodeMapping="तपाईंको कम्प्यूटरमा प्रिती फन्ट छ";*/
        
			String bigText = FileUtilities.readUTF8File("C:\\Users\\paudyals\\Desktop\\shabdakosh_full_text.txt").toString();
			
			String converted = convertToUnicode(bigText);
			
			System.out.println("Loaded");
			FileUtilities.writeUTF8FileAppend("C:\\Users\\paudyals\\Desktop\\shabdakosh_full_text_converted.txt", converted);

			System.out.println("Converted and Wrote to file");

    }


    public static String convertToUnicode(String legacyText) {
        //document.getElementById("unicode_text").value = "You have chosen SIMPLE TEXT in Preeti to convert into Unicode.";
        String modified_substring = legacyText;
        int text_size = legacyText.length();
        String processed_text = "";

        int sthiti1 = 0;
        int sthiti2 = 0;
        int chale_chalo = 1;

        int max_text_size = 6000;
        while (chale_chalo == 1) {
            sthiti1 = sthiti2;
            if (sthiti2 < (text_size - max_text_size)) {
                sthiti2 += max_text_size;
                while (legacyText.charAt(sthiti2) != ' ' ) {
                    sthiti2--;
                }
            } else {
                sthiti2 = text_size;
                chale_chalo = 0;
            }
            modified_substring = legacyText.substring(sthiti1, sthiti2);
            modified_substring = Replace_Symbols(modified_substring);
            processed_text += modified_substring;

        }
        return processed_text;
    }

        public static String Replace_Symbols(String modified_substring) {
            int array_one_length = preetiCharacterSet.length;

            if (modified_substring != "" ) {
                for (int input_symbol_idx = 0; input_symbol_idx < array_one_length; input_symbol_idx++) {
                    int idx = 0;
                    while (idx != -1) {
                        modified_substring = modified_substring.replace(preetiCharacterSet [input_symbol_idx],unicodeCharacterSet[input_symbol_idx]);
                        idx = modified_substring.indexOf(preetiCharacterSet [input_symbol_idx]);
                    }
                }

                //TODO USE REPLACE ALL
                int position_of_i = modified_substring.indexOf("l");
                while (position_of_i != -1) {
                    String charecter_next_to_i = modified_substring.charAt(position_of_i + 1)+"" ;
                    String charecter_to_be_replaced = "l" + charecter_next_to_i;
                    modified_substring = modified_substring.replace(charecter_to_be_replaced, charecter_next_to_i + "ि");
                    position_of_i = modified_substring.indexOf( "l",position_of_i + 1);

                    //test
                }


                int position_of_wrong_ee = modified_substring.indexOf("ि्");
                while (position_of_wrong_ee != -1) {
                    String consonent_next_to_wrong_ee = modified_substring.charAt(position_of_wrong_ee + 2)+"" ;
                    String charecter_to_be_replaced = "ि्"+ consonent_next_to_wrong_ee;
                    modified_substring = modified_substring.replace(
                    charecter_to_be_replaced, "्"+ consonent_next_to_wrong_ee + "ि");
                    position_of_wrong_ee = modified_substring.indexOf("ि" ,position_of_wrong_ee + 2);
                }

                position_of_wrong_ee = modified_substring.indexOf( "िं्");
                while (position_of_wrong_ee != -1) {
                    String consonent_next_to_wrong_ee = modified_substring.charAt(position_of_wrong_ee + 3) + "" ;
                    String charecter_to_be_replaced = "िं्"+ consonent_next_to_wrong_ee;
                    modified_substring = modified_substring.replace(
                            charecter_to_be_replaced, "्"
                                    + consonent_next_to_wrong_ee + "िं");
                    position_of_wrong_ee = modified_substring.indexOf("िं" ,position_of_wrong_ee + 3);
                }
                String set_of_matras = "ा ि ी ु ू ृ े ै ो ौ ं : ँ ॅ" ;
                int position_of_R = modified_substring.indexOf("{");
                while (position_of_R > 0) {
                    int probable_position_of_half_r = position_of_R - 1;
                    String charecter_at_probable_position_of_half_r = modified_substring.charAt(probable_position_of_half_r)+"" ;
                    while (!set_of_matras.contains(charecter_at_probable_position_of_half_r)) {
                        probable_position_of_half_r = probable_position_of_half_r - 1;
                        charecter_at_probable_position_of_half_r = modified_substring.charAt(probable_position_of_half_r)+"" ;
                    }
                    String charecter_to_be_replaced = modified_substring.substring(probable_position_of_half_r,(position_of_R - probable_position_of_half_r));
                    String new_replacement_string = "र्" + charecter_to_be_replaced;
                    charecter_to_be_replaced = charecter_to_be_replaced + "{";
                    modified_substring = modified_substring.replace(charecter_to_be_replaced, new_replacement_string);
                    position_of_R = modified_substring.indexOf( "{");
                }
                modified_substring = modified_substring.replaceAll( "=", "." );
                modified_substring = modified_substring.replaceAll( "_", ")" );
                modified_substring = modified_substring.replaceAll( "Ö", "=" );
                modified_substring = modified_substring.replaceAll( "Ù", ";" );
                modified_substring = modified_substring.replaceAll( "…", "‘" );
                modified_substring = modified_substring.replaceAll( "Ú", "’" );
                modified_substring = modified_substring.replaceAll( "Û", "!" );
                modified_substring = modified_substring.replaceAll( "Ü", "%" );
                modified_substring = modified_substring.replaceAll( "æ", "“" );
                modified_substring = modified_substring.replaceAll( "Æ", "”" );
                modified_substring = modified_substring.replaceAll( "±", "+" );
                modified_substring = modified_substring.replaceAll( "-", "(" );
                modified_substring = modified_substring.replaceAll( "<", "?" );
            }

            return modified_substring;

        }
}