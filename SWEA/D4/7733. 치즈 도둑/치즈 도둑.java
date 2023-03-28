import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine()); // 한 변의 길이
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			} // map
			int max = 1;
			int start = 0;
			while(!scan()) {
				start++;
				eat(start);
				max = Math.max(max, count());
			}
			
			sb.append("#"+t+" "+max+"\n");
		} // test case
		bw.write(sb.toString());
		br.close();
		bw.close();
	} // main
	
	static void eat(int a) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==a) map[i][j]=0;
			}
		}
	} // eat
	
	static int count() {
		visited = new boolean[N][N];
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0 && !visited[i][j]) {
					count++;
					search(i,j);
				}
			}
		}
		return count;
	} // count
	
	static void search(int a, int b) {
		visited[a][b]=true;
		for(int d=0;d<4;d++) {
			int x = a+dx[d];
			int y = b+dy[d];
			if(x>=0 && x<N && y>=0 && y<N && !visited[x][y] && map[x][y] != 0) {
				search(x,y);
			}
		}
	} // search
	
	static Boolean scan() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] !=0) return false;
			}
		}
		return true;
	}
}