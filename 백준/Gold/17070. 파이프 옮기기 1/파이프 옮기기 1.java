import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int ans;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<N+1;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		ans=0;
		move(1,2,0);
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	
	
	
	static void move(int r, int c, int d) {
		if(r==N &&c==N) {
			ans++;
			return;
		}
		
		switch(d) {
			case 0: if(c+1<=N && map[r][c+1]==0) {
						move(r,c+1,0);
						}
					break;
			case 1: if(r+1<=N && map[r+1][c]==0) {
						move(r+1,c,1);
						}
					break;
			case 2: if(c+1<=N && map[r][c+1]==0) {
						move(r,c+1,0);
						}
					if(r+1<=N && map[r+1][c]==0) {
						move(r+1,c,1);
						}
					break;
		}
		if(c+1<=N && map[r][c+1]==0 && r+1<=N && map[r+1][c]==0 && map[r+1][c+1]==0) {
			move(r+1,c+1,2);
		}
	}
}