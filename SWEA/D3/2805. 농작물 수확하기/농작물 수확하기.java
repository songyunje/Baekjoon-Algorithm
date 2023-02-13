import java.io.*;
import java.util.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			
			int sum=0;
			for(int i=0;i<N;i++) {
				String st = br.readLine();
				for(int j=Math.abs(i-N/2);j<N-Math.abs(i-N/2);j++) {
					sum += (st.charAt(j)-'0');
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(sum);
			bw.write(String.valueOf(sb)+"\n");
	
			
		}
		
		br.close();
		bw.flush();
		bw.close();

	} 
}