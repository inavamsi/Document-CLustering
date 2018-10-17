package PA2NLP.PA2;

import java.util.Collections;
import java.util.List;

public class Matrix {
	public static float[][] makedocm(List<String> l, List<String>[] docs){
		float[][] matrix = new float[docs.length][l.size()];
		for(int i=0;i<docs.length;i++) {
			for(int j=0;j<l.size();j++) {
				matrix[i][j]=Collections.frequency(docs[i], l.get(j));

			}
		}
		
		for(int j=0;j<l.size();j++) {
			int word_in_docs=0;
			for(int i=0;i<docs.length;i++) {
				if(matrix[i][j]!=0) {
					word_in_docs+=1;
				}
			}
			for(int i=0;i<docs.length;i++) {
				if(word_in_docs==1) {
					matrix[i][j]=1/docs.length;
				}
				else {
					matrix[i][j]=matrix[i][j]/word_in_docs;
				}
			}
		}
		
		
		return matrix;
		
	}


}
