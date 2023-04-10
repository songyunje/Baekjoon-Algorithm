import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][][] dp = new int[N+1][3][2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dp[i][0][0]=Math.max(dp[i-1][0][0], dp[i-1][1][0])+a;
			dp[i][0][1]=Math.min(dp[i-1][0][1], dp[i-1][1][1])+a;
			
			dp[i][1][0]=Math.max(Math.max(dp[i-1][0][0], dp[i-1][1][0]), dp[i-1][2][0])+b;
			dp[i][1][1]=Math.min(Math.min(dp[i-1][0][1], dp[i-1][1][1]), dp[i-1][2][1])+b;
			
			dp[i][2][0]=Math.max(dp[i-1][1][0], dp[i-1][2][0])+c;
			dp[i][2][1]=Math.min(dp[i-1][1][1], dp[i-1][2][1])+c;
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			if(dp[N][i][0]>max) max = dp[N][i][0];
			if(dp[N][i][1]<min) min = dp[N][i][1];
		}
		bw.write(String.valueOf(max+" "+min));
		br.close();
		bw.close();
	}
}