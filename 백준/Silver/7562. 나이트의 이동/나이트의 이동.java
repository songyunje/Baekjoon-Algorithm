import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] dx = {-2,-1,1,2,2,1,-1,-2};
		int[] dy = {1,2,2,1,-1,-2,-2,-1};
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			Queue<node> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			q.add(new node(sx,sy));
			
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int cnt = -1;
			outer : while(!q.isEmpty()) {
				cnt++;
				int size = q.size();
				for(int s=0;s<size;s++) {
					node temp = q.poll();
					if(temp.x==ex && temp.y==ey) break outer;
					if(!visited[temp.x][temp.y]) {
						visited[temp.x][temp.y]=true;
						for(int d=0;d<8;d++) {
							int nx = temp.x+dx[d];
							int ny = temp.y+dy[d];
							if(nx>=0 && nx<N && ny>=0 && ny<N) {
								q.add(new node(nx,ny));
							}
						}
					}
				}
			}
			sb.append(cnt+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	} // main
	static class node{
		int x;
		int y;
		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	} // class node
}