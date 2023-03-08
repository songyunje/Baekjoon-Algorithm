import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		count=0;
		
		clean(row,column,direction);
		
		bw.write(String.valueOf(count));
		br.close();
		bw.close();
		
	}
	
	
	static void clean(int a, int b, int d) {
		if(map[a][b]==0) {
			map[a][b]=2;
			count++;
		}
		
		Boolean check = false;
		for(int i=1;i<=4;i++) {
			int nd =(4+d-i)%4;
			int nx = a+dx[nd];
			int ny = b+dy[nd];
			if(map[nx][ny]==0) {
				check=true;
				clean(nx,ny,nd);
				break;
			}	
		}
		if(!check) {
			int nx = a-dx[d];
			int ny = b-dy[d];
			if(map[nx][ny] != 1)
				clean(nx,ny,d);
			else
				return;
		}
	}
}