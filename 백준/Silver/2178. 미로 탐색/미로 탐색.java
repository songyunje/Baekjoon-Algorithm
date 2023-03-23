import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		for(int i=1;i<=N;i++) {
			String str = br.readLine().trim();
			for(int j=1;j<=M;j++) {
				map[i][j]=str.charAt(j-1)-'0';
			}
		}
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(1,1));
		while(!q.isEmpty()) {
			node temp = q.poll();
			for(int d=0;d<4;d++) {
				int nx = temp.x+dx[d];
				int ny = temp.y+dy[d];
				if(nx>=1 && nx<=N && ny>=1 && ny<=M && !(nx == 1 && ny == 1) && map[nx][ny]==1) {
					q.add(new node(nx,ny));
					map[nx][ny]=map[temp.x][temp.y]+1;
				}
			}
		}

		bw.write(String.valueOf(map[N][M]));
		br.close();
		bw.close();
	}
	static class node{
		int x;
		int y;
		public node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}