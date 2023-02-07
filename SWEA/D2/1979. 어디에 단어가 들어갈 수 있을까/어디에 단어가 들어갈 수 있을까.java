import java.io.BufferedReader;                                                      
import java.io.BufferedWriter;                                                      
import java.io.IOException;                                                         
import java.io.InputStreamReader;                                                   
import java.io.OutputStreamWriter;                                                  
import java.util.StringTokenizer;                                                   
                                                                                    
public class Solution {                                                                
	public static void main(String[] args) throws IOException {                     
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st;                                                         
		                                                                            
		int T = Integer.parseInt(br.readLine());                                    
		                                                                            
		for(int t=0;t<T;t++) {                                                      
			st = new StringTokenizer(br.readLine()," ");                            
			int N = Integer.parseInt(st.nextToken());                               
			int K = Integer.parseInt(st.nextToken());                               
			                                                                        
			int[][]	arr = new int[N][N];                                            
			                                                                        
			for(int i=0;i<N;i++) {                                                  
				st = new StringTokenizer(br.readLine()," ");                        
				for(int j=0;j<N;j++) {                                              
					arr[i][j]=Integer.parseInt(st.nextToken());                     
				}                                                                   
			}                                                                       
			                                                                        
			int count =0;                                                           
                                                                                    
			for(int r=0;r<N;r++) {                                                  
				int space1=0;                                                       
				int space2=0;                                                       
				for(int c=0;c<N;c++) {                                              
					if(arr[r][c]==1) {                                              
						space1++;                                                   
					}                                                               
					else {                                                          
						if(space1==K) {                                             
							count++;                                                
						}                                                           
						space1=0;                                                   
					}                                                               
					if(arr[c][r]==1) {                                              
						space2++;                                                   
					}                                                               
					else {                                                          
						if(space2==K) {                                             
							count++;                                                
						}                                                           
						space2=0;                                                   
					}                                                               
					                                                                
				}                                                                   
				if(space1==K) {                                                     
					count++;                                                        
				}                                                                   
				if(space2==K) {                                                     
					count++;                                                        
				}                                                                   
			}                                                                       
			  
			bw.write("#"+(t+1)+" "+count+"\n");                                     
			                                                                        
		}
		br.close();                                                                 
		bw.flush();                                                                 
		bw.close();                                                                 
	}                                                                               
}