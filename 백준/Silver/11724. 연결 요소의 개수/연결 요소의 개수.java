import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for(int i=0;i<N+1;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		int count=0;
		for(int i=1;i<N+1;i++) {
			if(!visited[i]) {
				count++;				
				dfs(i);
			}
		}
		bw.write(String.valueOf(count));
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int v) {
		if(visited[v])
			return;
		visited[v]=true;
		
		for(int i : list[v]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
}