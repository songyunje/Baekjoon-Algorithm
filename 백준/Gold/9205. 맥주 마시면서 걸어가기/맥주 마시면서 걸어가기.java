import java.io.*;
import java.util.*;

public class Main {
	static class node{
		public int x;
		public int y;
		
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int n;
	static boolean[] visited;
	static node[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc=0;tc<T;tc++) {
			
			n = Integer.parseInt(br.readLine().trim());

			arr = new node[n+2];
			visited = new boolean[n+1];
			
			for(int p=0;p<n+2;p++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				int tx = Integer.parseInt(st.nextToken());
				int ty = Integer.parseInt(st.nextToken());
				arr[p]=new node(tx, ty);
			}
			
			if(bfs())
				bw.write("happy"+"\n");
			else
				bw.write("sad"+"\n");
		
		} // tc
		
		br.close();
		bw.close();
		
	} // main
	
	static Boolean bfs() {
		Queue<node> q = new LinkedList<>();
		node start = arr[0];
		node end = arr[n+1];
		
		q.add(start);
		
		while(!q.isEmpty()) {
			node temp = q.poll();
			
			if(distance(temp, end)<=1000)
				return true;
			for(int i=1;i<n+1;i++) {
				if(!visited[i] && distance(temp,arr[i])<=1000) {
					visited[i]=true;
					q.add(arr[i]);
				}
			}
		}
		return false;
	} // bfs
	
	static double distance(node n1, node n2) {
		return Math.abs(n1.x-n2.x)+Math.abs(n1.y-n2.y);
	} // distance
}