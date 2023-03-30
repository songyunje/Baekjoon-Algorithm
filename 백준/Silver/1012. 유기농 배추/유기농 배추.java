import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[M][N];
			boolean[][] visited = new boolean[M][N];
			int count=0;
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y]=1;
			} // map 입력
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						Queue<node> q = new LinkedList<>();
						count++;
						q.add(new node(i,j));
						while(!q.isEmpty()) {
							node temp = q.poll();
							if(!visited[temp.x][temp.y]) {
								visited[temp.x][temp.y]=true;
								for(int d=0;d<4;d++) {
									int nx = temp.x+dx[d];
									int ny = temp.y+dy[d];
									if(nx>=0 && nx<M && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny]==1) q.add(new node(nx,ny));
								}	
							}
						}
					}
				}
			} // count
			
			sb.append(count+"\n");
		} // test case
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	static class node{
		int x;
		int y;
		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // node

}