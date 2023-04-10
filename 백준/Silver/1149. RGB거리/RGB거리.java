import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		
		for(int i=1;i<=N;i++) {
			int[] temp = new int[3];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				temp[j]=Integer.parseInt(st.nextToken());
			}
			dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+temp[0];
			dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+temp[1];
			dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+temp[2];
		}
		
		br.close();
		System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));
	}
}