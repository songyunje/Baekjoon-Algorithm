import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		for(int t=0;t<10;t++) {
			String str = br.readLine();
			sb = new StringBuilder("#");
			map = new int[100][100];
			
			for(int i=0;i<100;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<100;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int ans=Math.max(row(map), col(map));
			ans = Math.max(ans, diag(map));
			
			sb.append((t+1)+" "+ans+"\n");
			bw.write(String.valueOf(sb));
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	
	static int diag(int[][] arr) {
		int max = 0;
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0;i<arr.length;i++) {
			sum1+=arr[i][i];
			sum2+=arr[arr.length-1-i][i];
			}
		max=Math.max(max, sum1);
		max=Math.max(max, sum2);
		return max;
	}
	
	
	static int col(int[][] arr) {
		int max = 0;
		for(int c=0;c<arr[0].length;c++) {
			int sum = 0;
			for(int r=0;r<arr.length;r++) {
				sum+=arr[r][c];
			}
			max=Math.max(max, sum);
		}
		return max;
	}
	
	
	static int row(int[][] arr) {
		int max = 0;
		for(int[] row : arr) {
			int sum=0;
			for(int i=0;i<arr[0].length;i++) {
				sum+=row[i];
			}
			max=Math.max(max, sum);
		}
		return max;
	}
}