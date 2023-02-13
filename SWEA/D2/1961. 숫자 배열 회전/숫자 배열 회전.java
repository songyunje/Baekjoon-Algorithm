import java.io.*;
import java.util.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String st = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j]=st.charAt(2*j)-'0';
				}
			}

			bw.write("#"+(t+1)+"\n");
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					bw.write(String.valueOf(arr[N-j-1][i]));
				}
				bw.write(" ");
				for(int j=0;j<N;j++){
					bw.write(String.valueOf(arr[N-i-1][N-j-1]));
				}
				bw.write(" ");
				for(int j=0;j<N;j++) {
					bw.write(String.valueOf(arr[j][N-i-1]));
				}
				bw.write("\n");
			}
			
			
			
			
		}
		
		br.close();
		bw.flush();
		bw.close();

	} 
}