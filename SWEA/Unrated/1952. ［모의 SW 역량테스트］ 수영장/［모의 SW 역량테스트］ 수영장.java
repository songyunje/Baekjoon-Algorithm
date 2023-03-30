import java.io.*;
import java.util.*;
public class Solution {
	static int[] cost=new int[4];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				cost[i]=Integer.parseInt(st.nextToken());
			} // cost 입력
			
			int[] dp = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=12;i++) {
				int temp = Integer.parseInt(st.nextToken());
				dp[i]=Math.min(dp[i-1]+temp*cost[0], dp[i-1]+cost[1]);
				if(i>=3) dp[i]=Math.min(dp[i-3]+cost[2], dp[i]);
				if(i==12) dp[i]=Math.min(dp[i], cost[3]);
			} //dp
			sb.append("#"+t+" "+dp[12]+"\n");
		} // test case
		bw.write(sb.toString());
		br.close();
		bw.close();
	} // main 
}