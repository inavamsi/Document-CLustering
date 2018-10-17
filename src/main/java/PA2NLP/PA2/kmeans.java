package PA2NLP.PA2;

import java.util.Random;
import java.util.concurrent.TimeUnit;



public class kmeans {
	
	public static int[][] cluster(float[][]matrix, Integer clusters) throws InterruptedException{
		//for (int i=0;i<matrix.length;i++) {
		//	for(int j=0;j<matrix.length;j++) {
		//		System.out.println(i+"_"+j+"    "+cosine_distance(matrix[i],matrix[j]));
		//	}
		//}
		//TimeUnit.SECONDS.sleep(100);
		int nodocs=matrix.length;
		int doclen=matrix[0].length;
		float[][] mean = new float[clusters][doclen];
		for(int i=0;i<clusters;i++) {
			int a = randomly(nodocs);
			for(int j=0;j<doclen;j++) {
				mean[i][j]=matrix[a][j];                   //intialize mean points
			}
			
		}
		int iter=0;
		int[][] clustered_sets2 = new int[clusters][nodocs];
		clustered_sets2=initialize(clustered_sets2);
		int[][] clustered_sets1 = new int[clusters][nodocs];
		while(iter++<20){
			//System.out.print(iteration++);
			
			clustered_sets1=initialize(clustered_sets1);
			
																		//for each doc find closest mean point
			for(int k=0;k<nodocs;k++) {
				int closest=closest_cluster(matrix[k],mean);
				//System.out.println(k+" is closeset to "+closest);
				for(int i=0;i<nodocs;i++) {
					if(clustered_sets1[closest][i]==-1) {
						clustered_sets1[closest][i]=k;
						break;
					}
				}
			}
			
			for(int j=0;j<clusters;j++) {
		  		//System.out.print("cluster"+j+" : ");
			  	for(int i=0;i<nodocs;i++){
			  		int key=clustered_sets1[j][i];
			  		//if(key!=-1)
			  	    //System.out.print(key);
			  	} 
			  	//System.out.println();
		  	}
			
			for(int i=0;i<clusters;i++) {                                  //calculate new means points
				if(clustered_sets1[i][0]==-1) {
					int a =randomly(nodocs);
					//System.out.println(i+" cluster has mean "+a);
					for(int j=0;j<doclen;j++) {
						mean[i][j]=matrix[a][j];
					}
				}
				else {
					int lenc=0;
					for(int a=0;a<nodocs;a++) {
						if(clustered_sets1[i][a]==-1) {
							break;
						}
						lenc++;
					}
					
					for(int k=0;k<doclen;k++) {
						mean[i][k]=0;
						for(int j=0;j<lenc;j++) {
							mean[i][k]+=matrix[j][k];
						}
						mean[i][k]/=lenc;
						//System.out.print(mean[i][k]+ " ");
					}
					//System.out.println();
				}
			}
			//for(int i=0;i<clusters;i++) {
			//	for(int j=0;j<doclen;j++) {
			//		System.out.print(mean[i][j]);                 //print mean points
			//	}
			//	System.out.println();
			//}
			//for(int j=0;j<clusters;j++) {
		  	//	System.out.print("cluster"+j+" : ");
			  ///	for(int i=0;i<nodocs;i++){
			  	//	int key=clustered_sets1[j][i];
			  	//	if(key!=-1)
			  	  //  System.out.print(key);
			  	//} 
			  	//System.out.println();
		  	//}
			boolean flag=true;
			
			for(int k=0;k<clusters;k++) {                                   //check if there is any change in clustering points
				for(int l=0;l<nodocs;l++) {
					if(clustered_sets1[k][l]!=clustered_sets2[k][l]) {
						flag=false;
						break;
					}
				}
			}
			int[] cl_size=new int[clusters];
			for(int i=0;i<clusters;i++) {
				cl_size[i]=0;
				for(int j=0;j<nodocs;j++) {
					if(clustered_sets1[i][j]==-1) {
						break;
					}
					cl_size[i]++;
				}
			}

			boolean within_size = true;
			for(int i=0;i<clusters;i++) {
				if(cl_size[i]< (int)nodocs*0.4/clusters) {//&& clusters!=3)||(cl_size[i]< (int)nodocs*0.8/clusters)) {
					within_size=false;
					break;
				}
			}
			
			if(flag || within_size || iter++==1000) { 													//return only if there is an iteration with no change in clusters.
			//	System.out.println(" ");
			//	System.out.println("****************************");
			//	System.out.println("   Returned");
				break;
			}
			                  
			for(int i=0;i<clusters;i++) {
				for(int j=0;j<nodocs;j++) {
					clustered_sets2[i][j]=clustered_sets1[i][j];
				}
			}

			//System.out.println("   next iter*********************");
		}
		return clustered_sets1;
	}

	public static int[][] initialize(int[][] m){
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				m[i][j]=-1;
			}
		}
		return m;
	}
	public static float[] findmean(float[][] matrix, int[] l) {
		int size=0;
		for(int i=0;i<l.length;i++) {
			if(l[i]==-1) {
				size=i;
				break;
			}
		}
		float[] mean = new float[matrix[0].length];
		for(int i=0;i<mean.length;i++) {
			mean[i]=0;
			for(int j=0;j<size;j++) {
				mean[i]+=matrix[i][j];
			}
			mean[i]/=size;
		}
		
		
		return null;
		
	}
	
	public static Integer closest_cluster(float[] vector, float[][] mean) {
		int min=0;
		float min_dist=cosine_distance(vector,mean[0]);
		for(int i=0;i<mean.length;i++) {
			float dist=cosine_distance(vector,mean[i]);
			if(dist<min_dist) {
				min_dist=dist;
				min=i;
			}
		}
				
		return min;
		
	}
	
	public static float euclidean_distance(float[] v1, float[]v2) {
		float distance =0;
		for(int i =0;i<v1.length;i++) {
			
			float diff=v1[i]*v1[i]-v2[i]*v2[i];
			distance+=Math.abs(diff);
		}
		
		return distance;
		
	}
	public static float cosine_distance(float[] v1, float[]v2) {
		double distance =0;
		double v1_sq=0;
		double v2_sq=0;
		double dot=0;
		for(int i =0;i<v1.length;i++) {
			v1_sq+=v1[i]*v1[i];
			v2_sq+=v2[i]*v2[i];
			dot+=v1[i]*v2[i];
			
		}
		v1_sq=Math.sqrt(v1_sq);
		v2_sq= Math.sqrt(v2_sq);
		distance=dot/(v1_sq*v2_sq);
		return (float) (1 - distance);
		
	}
	
	public static Integer randomly(Integer n){
		Random rn = new Random();
		int x = rn.nextInt(n);
		return x;
		
	}
}
