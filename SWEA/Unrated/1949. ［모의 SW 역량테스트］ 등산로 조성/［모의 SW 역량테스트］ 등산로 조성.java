import java.io.*;
import java.util.*;
public class Solution {
	static int N,K,max;
	static int[][] map;
	static boolean[][] visited;
	static class node{
		int x;
		int y;
		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;	
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1;t<=T;t++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	
        	map = new int[N][N];
        	visited = new boolean[N][N];
        	List<node> list = new ArrayList<>();
        	int maxh = 1;
        	for(int i=0;i<N;i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0;j<N;j++) {
        			map[i][j]=Integer.parseInt(st.nextToken());
        			if(map[i][j]==maxh) list.add(new node(i,j));
        			else if(map[i][j]>maxh) {
        				list.clear();
        				maxh=map[i][j];
        				list.add(new node(i,j));
        			}
        		}
        	} // map, 최고점 list
      	
        	max=1;
        	for(node n : list) {
        		visited[n.x][n.y]=true;
        		dfs(n.x,n.y,maxh,1,false);
        		visited[n.x][n.y]=false;
        	}
        	sb.append("#"+t+" "+max+"\n");
        } // test case
        bw.write(sb.toString());
        br.close();
        bw.close();
	} // main
	static void dfs(int x, int y, int val, int cnt, Boolean check) {
		max=Math.max(max, cnt);
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				if(map[nx][ny]<val && !visited[nx][ny]) {
					visited[nx][ny]=true;
					dfs(nx,ny,map[nx][ny],cnt+1,check);
					visited[nx][ny]=false;
				}
				else if(map[nx][ny]<(val+K) && !visited[nx][ny] && !check) {
					visited[nx][ny]=true;
					dfs(nx,ny,map[x][y]-1,cnt+1,!check);
					visited[nx][ny]=false;
				}
			}
		}

	} // run bfs
}