import java.io.*;
import java.util.*;
public class Main {
	static int N,M,min;
	static char[][] map;
	static class node{
		int x;
		int y;
		int key;
		int count;
		public node(int x, int y, int key, int count) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.count = count;
		}
	} // class node
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new char[N][M];
		visited = new boolean[N][M][64];
		int startx=0;
		int starty=0;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]-'0'==0) {
					startx=i;
					starty=j;
				}
			}
		} // map
		bfs(startx, starty);
		if(min==Integer.MAX_VALUE) bw.write(String.valueOf(-1));
		else bw.write(String.valueOf(min));
		br.close();
		bw.close();
	} // main 
	
	static void bfs(int x, int y) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(x,y,0,0));
		visited[x][y][0]=true;
		while(!q.isEmpty()) {
			node temp = q.poll();
			if(map[temp.x][temp.y]-'0'==1) {
				min=Math.min(min, temp.count);
				break;
			}
			for(int d=0;d<4;d++) {
				int nx = temp.x+dx[d];
				int ny = temp.y+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny][temp.key]) {
					if(map[nx][ny]=='#') continue;
					else if((map[nx][ny]-'a')>=0 && (map[nx][ny]-'a')<=6) {
						visited[nx][ny][temp.key]=true;
						int tkey = temp.key|1<<(map[nx][ny]-'a');
						visited[nx][ny][tkey]=true;
						q.add(new node(nx,ny,tkey,temp.count+1));
					}else if((map[nx][ny]-'A')>=0 && (map[nx][ny]-'A')<=6) {
						if((temp.key&(1<<(map[nx][ny]-'A')))>0) {
							visited[nx][ny][temp.key]=true;
							q.add(new node(nx,ny,temp.key,temp.count+1));
						}						
					}else {
						visited[nx][ny][temp.key]=true;
						q.add(new node(nx,ny,temp.key,temp.count+1));
					}
				}
			}
		}
	} // bfs
}