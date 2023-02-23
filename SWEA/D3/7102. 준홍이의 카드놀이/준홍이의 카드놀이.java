import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			sb = new StringBuilder("#"+(t+1)+" ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+M+1];
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++)
					arr[i+j]++;
			}
			int max = 0;
			for(int i=0;i<N+M+1;i++) {
				max = Math.max(max, arr[i]);
			}
			
			for(int i=0;i<N+M+1;i++) {
				if(arr[i]==max)
					sb.append(i+" ");
			}
			
			sb.append("\n");
			
			bw.write(sb.toString());
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}