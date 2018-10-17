package PA2NLP.PA2;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.stanford.nlp.simple.*;

public class Preprocess {
	
	public static boolean has_(String x) {
		for(int i=0;i<x.length();i++) {
			if(x.charAt(i)=='_') {
				return true;
			}
		}
		return false;
	}

	public static List<String>[] Start(List<String> data, int size) throws IOException {
		
		List<String>[] Lem_Tok_List = new List[size];
		List<String>[] StopWords_List = new List[size];
		PrintWriter writer = new PrintWriter("lem_tok.txt", "UTF-8");
		PrintWriter writer2 = new PrintWriter("NER.txt", "UTF-8");

		for(int i=0;i<size;i++) {
			writer.println(" ");
			writer.println(" ");
			writer.println("Document "+i);
		  	writer.println(" ");
			List<String> l = new ArrayList<String>(); 
			l.addAll(Tokenize_Lemmatize((data.get(i)).replaceAll("[0-9]","")));
			Lem_Tok_List[i] = l;
			StopWords_List[i]=removeStopWords(Merge.tolower(l));
			
			for(int y=0;y<l.size();y++) {
				if(has_(l.get(y))) {
					writer2.println(l.get(y));
				}
			}
			
			Document doc = new Document(data.get(i));
	        for (Sentence sent : doc.sentences()) {
	        	List<String> toked = new ArrayList<String>();
	        	toked=sent.lemmas();
	        	for(int a=0;a<toked.size();a++)
	        		writer.print(toked.get(a)+" ");
	        }
	        
			//System.out.println(StopWords_List[i]);
			//System.out.println(StopWords_List[i]);
		}
		writer.close();
		writer2.close();
		//Sentence sent = new Sentence("Lucy Daniels is in  New York New York. I like Microsoft Corporation Limited. I like Mr.Raymord, John. are");
		//List<String> nerTags = sent.nerTags();  // [PERSON, O, O, O, O, O, O, O]
		//String firstPOSTag = sent.posTag(0);
		//System.out.println(nerTags);
		//System.out.println(sent.lemmas());
		//System.out.println(Join_NER(sent,sent.lemmas()));
		
		return StopWords_List;
		
		
	}
	
	public static List<String> Join_NER(Sentence s, List<String> l){   
        List<String> nerTags = s.nerTags();
        List<String> fin =new ArrayList<String>();
        Sentence sent = new Sentence("there");
        List<String> nex = sent.nerTags();
        int i =0;
        for(i=0;i<nerTags.size()-1;i++) {
        	if(nerTags.get(i)==nerTags.get(i+1) && nerTags.get(i)!=nex.get(0)) {
        		String finx=l.get(i);
        		for(int k=i+1;k<nerTags.size();k++) {
        			if(nerTags.get(i)==nerTags.get(k)) {
        				finx=finx+"_"+l.get(k);
        			}
        			else {
        				i=k-1;
        				break;
        			}
        		}
        		
        	fin.add(finx);
  
        	}
        	fin.add(l.get(i));
        }
        if(i==nerTags.size()-1)
        	fin.add(l.get(i));
        	
        
        return fin;
	}
		
	
	
	public static List<String> Tokenize_Lemmatize(String x){   
		List<String> l = new ArrayList<String>(); 
		List<String> NERed = new ArrayList<String>();
		Document doc = new Document(x);
        for (Sentence sent : doc.sentences()) {  
        	
        	NERed= Join_NER(sent,sent.lemmas());
        	l.addAll(NERed);    
        }
        
        return l;
	}
	
	public static List<String> removeStopWords(List<String> l){  
        //set,go
        final String[] stopWords = {"i","not","no","also","many","will","like","off","-lrb-","-rsb-","-rrb-","-lsb-","'s"," 's","a","about","above","after","again","against","all","am","an","and","any","are","as","at","be","because","been","before","being","below","between","both","but","by","could","did","do","does","doing","down","during","each","few","for","from","further","had","has","have","having","he","he’d","he’ll","he’s","her","here","here’s","hers","herself","him","himself","his","how","how’s","I","I’d","I’ll","I’m","I’ve","if","in","into","is","it","it’s","its","itself","let’s","me","more","most","my","myself","nor","of","on","once","only","or","other","ought","our","ours","ourselves","out","over","own","same","she","she’d","she’ll","she’s","should","so","some","such","than","that","that’s","the","their","theirs","them","themselves","then","there","there’s","these","they","they’d","they’ll","they’re","they’ve","this","those","through","to","too","under","until","up","very","was","we","we’d","we’ll","we’re","we’ve","were","what","what’s","when","when’s","where","where’s","which","while","who","who’s","whom","why","why’s","with","would","you","you’d","you’ll","you’re","you’ve","your","yours","yourself","yourselves"};
        l.removeAll(Arrays.asList(stopWords));
        final String[] punctuations= {"$"," `","`"," %","`","?","!",".","%", "-",":",";","''","'"," ''"," ``","``", "," ," ,","'",";","-","--","---",};
        l.removeAll(Arrays.asList(punctuations));
        final String[] letters= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        l.removeAll(Arrays.asList(letters));
        for(int j=0;j<letters.length;j++) {
        	letters[j].toUpperCase();
        }
        l.removeAll(Arrays.asList(letters));
        final String[] numbers= {"one","two","three","four","five","six","seven","eight","nine","ten","zero","nil","none"};
        l.removeAll(Arrays.asList(numbers));
        final String[] specwords= {"say","mr.","ms.","takenaka","with","without","thus","well","whether","try","want","must","let","want","go","whose","whom"};
        l.removeAll(Arrays.asList(specwords));
        return l;
	}
	
	public static String[] stopWords() throws IOException{
		String prefix ="/Users/inav/Desktop/data/StopWords.txt";
	    FileReader fr = new FileReader(prefix); 
		
		String data="";
	    int i; 
	    while ((i=fr.read()) != -1) 
	      data = data+((char) i); 
	    
	    fr.close();
	    List<String> l = new ArrayList<String>(); 
		Document doc = new Document(data);
        for (Sentence sent : doc.sentences()) {  
        	l.addAll(sent.lemmas());    
        }
        
        String[] arr = l.toArray(new String[l.size()]);
	    return arr;
	}
	//Tokenize
	//Remove StopWords
	//Lemmatize
	//NER
	//Return list of words
}
