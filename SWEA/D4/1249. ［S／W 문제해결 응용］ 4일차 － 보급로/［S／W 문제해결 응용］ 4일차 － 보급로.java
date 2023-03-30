import java.io.*;
import java.util.*;
public class Solution {
	static int N;
	static int[][] map, time;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			time = new int[N+1][N+1];
			visited = new boolean[N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					time[i][j]=Integer.MAX_VALUE;
				}
			}
			
			for(int i=1;i<=N;i++) {
				String str = br.readLine();
				for(int j=1;j<=N;j++) {
					map[i][j]=str.charAt(j-1)-'0';
				}
			} // map 입력
			
			djk();

			sb.append("#"+t+" "+time[N][N]+"\n");		
		} // test case
		bw.write(sb.toString());
		br.close();
		bw.close();
	} // main
	static void djk() {
		PriorityQueue<co> pq = new PriorityQueue<>(new Comparator<co>() {
			public int compare(co o1, co o2) {
				return o1.t-o2.t;
			}
		});
		
		pq.add(new co(1,1,0));
		time[1][1]=0;
		while(!pq.isEmpty()) {
			co temp = pq.poll();
			if(!visited[temp.x][temp.y]) {
				visited[temp.x][temp.y]=true;
				for(int d=0;d<4;d++) {
					int nx = temp.x+dx[d];
					int ny = temp.y+dy[d];					
					if(nx>=1 && nx<=N && ny>=1 && ny<=N) {
						if(time[nx][ny]>time[temp.x][temp.y]+map[nx][ny])
							time[nx][ny]=time[temp.x][temp.y]+map[nx][ny];
						pq.add(new co(nx,ny,time[nx][ny]));
					}
				}
			}
		} //while
	} // djk
	static class co{
		int x;
		int y;
		int t;
		public co(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	} // class coordinate
}