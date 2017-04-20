package com.icodejava.research.nlp.utils;

public class DevUnicode {

    public static void main (String args []) {
        //U+0900..U+097F (128 code points)

        String str = "\"क\", \"का\", \"कि\", \"की\", \"कु\", \"कू\", \"के\", \"कै\", \"को\", \"कौ\", \"कं\", \"क:\"" ;
    	String strEng = "\"ka\", \"kā\", \"ki\", \"kī\", \"ku\", \"kū\", \"kē\", \"kai\", \"ko\", \"kau\", \"kṁ\", \"ka:\"" ;
        //String str = "क, का, कि, की, कु, कू, के, कै, को, कौ, कं, क:" ;
        
        
        
        generateNP(str);
        
        generateEN(strEng);



    }

	private static void generateEN(String str) {
		String strOriginal = str;

		System. out.println(str);
        System. out.println(str.replaceAll("k" , "kh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "g" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "gh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ṅ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ch" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "chh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "j" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "jh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ñ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ṭ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ṭh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ḍ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ḍh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ṇ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "t" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "th" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "d" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "dh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "n" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "p" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ph" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "b" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "bh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "m" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "y" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "r" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "l" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "v" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "sh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "sh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "s" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "h" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "ksh" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "tr" ));
        str=strOriginal;
        System. out.println(str.replaceAll("k" , "gy" ));
	}
	
	private static void generateNP(String str) {
		String strOriginal = str;
        //कखगघङचछजझञटठडढणतथदधनपफबभमयरलवशषसहक्षत्रज्ञ
        //अआइईउऊएऐओऔअंअ:
        System. out.println(str);
        System. out.println(str.replaceAll("क" , "ख" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ग" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "घ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ङ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "च" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "छ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ज" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "झ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ञ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ट" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ठ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ड" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ढ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ण" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "त" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "थ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "द" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ध" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "न" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "प" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "फ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ब" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "भ" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "म" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "य" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "र" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ल" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "व" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "श" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ष" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "स" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ह" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "क्ष" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "त्र" ));
        str=strOriginal;
        System. out.println(str.replaceAll("क" , "ज्ञ" ));
	}

}