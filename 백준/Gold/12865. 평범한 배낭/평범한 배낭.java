import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<good> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			q.add(new good(W,V));
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			good temp = q.poll();
			for(int j=1;j<=K;j++) {
				if(temp.w>j) dp[i][j]=dp[i-1][j];
				else dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-temp.w]+temp.v);
			}
		} // dp
		
		bw.write(String.valueOf(dp[N][K]));
		br.close();
		bw.close();
	} // main
	static class good{
		int w;
		int v;
		public good(int w, int v) {
			this.w = w;
			this.v = v;
		}
	} // good class
}