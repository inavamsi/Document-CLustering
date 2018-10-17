package PA2NLP.PA2;

import java.io.*; 
public class readFile 
{ 
  public static String Readfile(String fileName) throws Exception 
  { 
    // pass the path to the file as a parameter 
	
    FileReader fr = new FileReader(fileName); 
	
	String data="";
    int i; 
    while ((i=fr.read()) != -1) 
      data = data+((char) i); 
    
    fr.close();
    return data;
  } 
} 