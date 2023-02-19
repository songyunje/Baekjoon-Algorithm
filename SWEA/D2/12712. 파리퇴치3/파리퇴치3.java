import java.io.*;
import java.util.*;

public class Solution {
	static int T,N,M, ans;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[] dx2 = {-1,-1,1,1};
	static int[] dy2 = {-1,1,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			sb = new StringBuilder("#");
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
				
			ans = test(map,M);	
			
			sb.append((t+1)+" "+ans+"\n");
			bw.write(String.valueOf(sb));
			
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	
	}
	
	static int test(int[][] arr, int num) {
		int max = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				int sum1 = arr[i][j];
				int sum2 = arr[i][j];
				for(int k=0;k<4;k++) {
					for(int l=1;l<num;l++) {
						if((i+dx[k]*l)>=0 && (i+dx[k]*l)<arr.length && (j+dy[k]*l)>=0 && (j+dy[k]*l)<arr.length) {
							sum1+=arr[i+dx[k]*l][j+dy[k]*l];	
						}
						if((i+dx2[k]*l)>=0 && (i+dx2[k]*l)<arr.length && (j+dy2[k]*l)>=0 && (j+dy2[k]*l)<arr.length) {
							sum2+=arr[i+dx2[k]*l][j+dy2[k]*l];	
						}
					}
				}
				max = Math.max(max, sum1);
				max = Math.max(max, sum2);
			}
		}
		return max;
	}
}