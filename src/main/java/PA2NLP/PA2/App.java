package PA2NLP.PA2;




import java.io.PrintWriter;
import java.util.*;

import edu.stanford.nlp.simple.*;


public class App 
{
		  public static void main(String[] args) throws Exception {
			  
			  
			    String prefix ="./data/";
			    String[] fileNames = {"C1/article01","C1/article02","C1/article03","C1/article04","C1/article05","C1/article06","C1/article07","C1/article08","C4/article01","C4/article02","C4/article03","C4/article04","C4/article05","C4/article06","C4/article07","C4/article08","C7/article01","C7/article02","C7/article03","C7/article04","C7/article05","C7/article06","C7/article07","C7/article08"};
			    Integer clusters=7;
			    Integer threshold_frequency=5;//fileNames.length;
			    int choice =1;  ///choose 1 for cosine distance, 2 for euclidean distance
			    
			    
			    List<String> x = new ArrayList<String>(); 	
			    int size=fileNames.length;
			    
			    
			    for(int i=0;i<size;i++) {
			    	x.add(readFile.Readfile(prefix+fileNames[i]+".txt"));
			    }
			  	
			  	
			  	List<String>[] ListofLists = new List[size];
			  	ListofLists=Preprocess.Start(x,size);
			  	List<String> merged = new ArrayList<String>();
			  	List<String> mergedf = new ArrayList<String>();
			  	merged=Merge.removeDuplicates(ListofLists);
			  	mergedf=Merge.remove_lowfreq(ListofLists, merged, threshold_frequency);
			  	List<String> mergedtoprint = new ArrayList<String>();
			  	mergedtoprint=Merge.remove_lowfreq(ListofLists, merged, 3);
			  	PrintWriter writer = new PrintWriter("topics.txt", "UTF-8");
			  	for(int i=0;i<mergedtoprint.size();i++) {
			  		writer.println(mergedtoprint.get(i));
			  	}
			  	writer.close();
			  	//System.out.println(mergedf);
			  	float[][] matrix = new float[size][mergedf.size()];
			  	matrix=Matrix.makedocm(mergedf,ListofLists);
			  	
			  	csv.write(matrix, mergedf);
			  	System.out.println();
			  	
			  	String d="";
			  	if(choice==1)
			  		d="cosine";
			  	else
			  		d="euclidean";
			  	System.out.println("Distance Metric selected: "+d);
			  	System.out.println("Total clusters selected: "+clusters);
			  	System.out.println();
			  	
			  	int[][] clustered_sets = new int[clusters][size];
			  	clustered_sets = kmeanspp.cluster(matrix,clusters,choice);
			  	System.out.println("Kmeans++ ");
			  	for(int j=0;j<clusters;j++) {
			  		System.out.print("cluster"+j+" : ");
				  	for(int i=0;i<size;i++){
				  		int key=clustered_sets[j][i];
				  		if(key!=-1)
				  	    System.out.print(fileNames[key]+"  ");
				  	} 
				  	System.out.println();
			  	}
			  	System.out.println();
			  	System.out.println();
			  	System.out.println();
			  	clustered_sets = kmeans.cluster(matrix,clusters);
			  	System.out.println("Kmeans ");
			  	for(int j=0;j<clusters;j++) {
			  		System.out.print("cluster"+j+" : ");
				  	for(int i=0;i<size;i++){
				  		int key=clustered_sets[j][i];
				  		if(key!=-1)
				  	    System.out.print(fileNames[key]+"  ");
				  	} 
				  	System.out.println();
			  	}
			  	System.out.println();
		        
		        
		  }
}