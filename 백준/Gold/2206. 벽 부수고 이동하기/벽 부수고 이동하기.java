import java.io.*;
import java.util.*;
public class Main {
	static int N,M,min;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		} // map 
		
		bfs(0,0,1);
		if(min==Integer.MAX_VALUE) bw.write(String.valueOf(-1));
		else bw.write(String.valueOf(min));
		br.close();
		bw.close();
	} // main
	
	static void bfs(int x, int y, int k) {
		Queue<node> q = new LinkedList<>();
		int cnt=0;
		q.add(new node(x,y,k));
		outer : while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for(int s=0;s<size;s++) {
				node temp = q.poll();
				if(temp.x==N-1 && temp.y==M-1) {
					min=Math.min(min, cnt);
					break outer;
				}
				if(!visited[temp.x][temp.y][temp.k]) {
					visited[temp.x][temp.y][temp.k]=true;
					for(int d=0;d<4;d++) {
						int nx = temp.x+dx[d];
						int ny = temp.y+dy[d];
						if(nx>=0 && nx<N && ny>=0 && ny<M) {
							if(map[nx][ny]!=1) {
								q.add(new node(nx,ny,temp.k));
							}else {
								if(temp.k>0) q.add(new node(nx,ny,temp.k-1));
							}
						}
					}
					
				}
			}
		}
	} // bfs
	
	static class node{
		int x;
		int y;
		int k;
		public node(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}	
	} // class node
}