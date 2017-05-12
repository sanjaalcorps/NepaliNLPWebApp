package com.icodejava.research.nlp.utils;
/**
 * @author Kushal Paudyal
 * Created on 08/15/2015
 *
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
 
public class FileUtilities {
 
    private FileUtilities() {
 
    }
 
    public static void main(String args[]) throws FileNotFoundException, IOException {
        trimLineSpacesInFile("src/com/icodejava/research/nlp/data/classifier/food.txt");
    }
 
    /**
     * This method shows how to read a file as bytes []
     */
    public static byte[] loadFile(String fileName) throws FileNotFoundException, IOException {
 
        File file = new File(fileName);
        int length = (int) file.length();
 
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
 
        return bytes;
 
    }
 
    /**
     * This method shows how to write byte [] into a file.
     */
    public static void writeFile(String fileName, byte[] content) throws IOException {
 
        File file = new File(fileName);
 
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
 
        writer.write(content);
 
        writer.flush();
 
        writer.close();
 
    }
 
    /**
     * This method shows how you can read a UTF8 file in Java.
     */
    public static String readUTF8File(String fileName) {
 
        String content = "";
 
        try {
 
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
 
            String line;
            while ((line = in.readLine()) != null) {
 
                //System.out.println(line);
                content += line;
                 
 
            }
 
            in.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
    
    /**
     * Reads a file line by line and returns an arraylist of lines
     * @param fileName
     * @return
     */
    public static List<String> readUTF8FileAsList(String fileName) {
    	 
        List<String> content = new ArrayList<String>();
 
        try {
 
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
 
            String line;
            while ((line = in.readLine()) != null) {
 
                //System.out.println(line);
                content.add(line); 
 
            }
 
            in.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
    
    /**
     * Reads a file line by line and returns an arraylist of lines, and also does not contain duplicates
     * @param fileName
     * @return
     */
    public static List<String> readUTF8FileAsUniqueList(String fileName) {
    	 
        List<String> content = new ArrayList<String>();
 
        try {
 
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
 
            String line;
            while ((line = in.readLine()) != null) {
 
                //System.out.println(line);
            	if(!content.contains(line)) {
            		content.add(line); 
            	}
 
            }
 
            in.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
 
    /**
     * This method show how to write UTF8 content to the file system.
     */
    public static void writeUTF8File(String fileName, String content) {
 
        try {
 
            File fileDir = new File(fileName);
 
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir),"UTF8"));
 
            out.append(content);
            out.flush();
            out.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    
    /**
     * This method show how to appends UTF8 content to the file system.
     */
    public static void writeUTF8FileAppend(String fileName, String content) {
 
    	try(FileWriter fw = new FileWriter(fileName, true);
    		    BufferedWriter bw = new BufferedWriter(fw);
    		    PrintWriter out = new PrintWriter(bw))
    		{
    		    out.println(content);
    		    //more code
    		} catch (IOException e) {
    		    e.printStackTrace();
    		}
    }
    
    /**
     * Reads a file as a list of lines.
     * Trims the line
     * Writes the list back the file
     * @param fileName
     */
    public static void trimLineSpacesInFile(String fileName) {
    	List<String> lines = readUTF8FileAsList(fileName);
    	String content = new String();
    	int lineCount = 0;
    	for(String line: lines) {
    		if(lineCount == 0) {
    			content = line.trim();
    		} else{
    			content +="\n"+line.trim();
    		}
    		
    		lineCount++;
    	}
    	
    	writeUTF8File(fileName, content);
    	
    	System.out.println("Successfully Trimmed Line Spaces in file: " + fileName);
    }
    
    /**
     * Returns a list of all the files that are in a folder (does not go inside subfolder)
     */
    public List<String> getFilesInAFolder(String folderName) {

        List<String> results = new ArrayList<String>();

        File[] files = new File(folderName).listFiles();
        // If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        return results;
    }
 
}