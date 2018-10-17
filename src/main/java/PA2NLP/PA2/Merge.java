package PA2NLP.PA2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Merge {
	public static List<String> tolower(List<String> l){
		
		ListIterator<String> iterator = l.listIterator();   // makes it all lower case
	    while (iterator.hasNext())
	    {
	        iterator.set(iterator.next().toLowerCase());
	    }
		
		return l;
		
	}
	
	public static List<String> removeDuplicates(List<String>[] lol){ 	
		
		List<String> l = new ArrayList<String>(); 
		for(int i=0;i<lol.length;i++) {
			l.addAll(lol[i]);
		}
		ListIterator<String> iterator = l.listIterator();   // makes it all lower case
	    while (iterator.hasNext())
	    {
	        iterator.set(iterator.next().toLowerCase());
	    }
	    
	    Set<String> hs = new HashSet<String>();     //removes duplicates
	    hs.addAll(l);
	    l.clear();
	    l.addAll(hs);
	    
		return l;
		
	}
	
	public static List<String> remove_lowfreq(List<String>[] lol,List<String> l ,int f){
		List<String> x = new ArrayList<String>(); 
		for(int i =0;i<l.size();i++) {
			String key=l.get(i);
			int no_occ=0;
			for(int j=0;j<lol.length;j++) {
				no_occ+= Collections.frequency(lol[j], key);
			}
			if(no_occ>f) {
				x.add(key);
			}
				
		}
		
		return x;
		
	}
}
