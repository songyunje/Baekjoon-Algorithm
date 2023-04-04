import java.io.*;
import java.util.*;
public class Main {
	static int K,W,H,min;
	static int[][] map;	
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[] sdx = {-2,-1,1,2,2,1,-1,-2};
	static int[] sdy = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		min=Integer.MAX_VALUE;
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bfs(0,0,K);
		
		br.close();
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	static void bfs(int x, int y, int k) {
		int cnt=-1;
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0,k));
		outer : while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for(int s=0;s<size;s++) {
				node temp = q.poll();
				if(!visited[temp.x][temp.y][temp.k]) {
					visited[temp.x][temp.y][temp.k]=true;
					if(temp.x==H-1 && temp.y==W-1) {
						min=Math.min(min, cnt);
						break outer;
					}
					for(int d=0;d<4;d++) {
						int nx = temp.x+dx[d];
						int ny = temp.y+dy[d];
						if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]!=1) {
							q.add(new node(nx,ny,temp.k));
						}
					}
					if(temp.k>0) {
						for(int d=0;d<8;d++) {
							int nx = temp.x+sdx[d];
							int ny = temp.y+sdy[d];
							if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]!=1) {
								q.add(new node(nx,ny,temp.k-1));
							}
						}	
					}
				}
				
			}
		}
	}
	static class node {
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