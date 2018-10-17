package PA2NLP.PA2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
public class csv {
	    public static void write(float[][] matrix, List<String> mergedf) throws FileNotFoundException{
	    	String filename = "matrix_visualise.csv";
	        PrintWriter pw = new PrintWriter(new File(filename));
	        StringBuilder sb = new StringBuilder();
	        
	        sb.append("Doc No.");
	        for(int i=0;i<mergedf.size();i++) {
	        	sb.append(',');
	        	sb.append(mergedf.get(i));
		        
	        }
	        sb.append('\n');
	        for(int i=0;i<matrix.length;i++) {
	        	sb.append(i);
	        	for(int j=0;j<mergedf.size();j++) {
	        		sb.append(',');
	        		sb.append(matrix[i][j]);
	    	      
	        	}
	        	sb.append('\n');
	        }
	       
	        pw.write(sb.toString());
	        pw.close();
	        System.out.println("Matrix output to file: "+filename+".csv");
	    }
	
}
