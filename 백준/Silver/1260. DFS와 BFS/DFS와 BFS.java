import java.io.*;
import java.util.*;

public class Main {
	static int N,M,V;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static StringBuilder dsb,bsb;
	static Queue<Integer> q; 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		for(int m=1;m<M+1;m++) {
			st=new StringTokenizer(br.readLine().trim());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[v].add(e);
			list[e].add(v);
		}
		for(int i=1;i<N+1;i++) {
			Collections.sort(list[i]);
		}

		dsb=new StringBuilder();
		bsb=new StringBuilder();
		
		visited = new boolean[N+1];
		
		dfs(V);
		
		visited = new boolean[N+1];
		q = new LinkedList<>();
		
		bfs();
		
		bw.write(dsb.toString()+"\n"+bsb.toString());
		br.close();
		bw.flush();
		bw.close();
		
	
	}
	
	static void dfs(int a) {
		if(visited[a])
			return;
		dsb.append(a+" ");
		visited[a]=true;
		for(int i : list[a]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs() {
		q.add(V);
		while(!q.isEmpty()) {
			int num=q.poll();
			if(visited[num])
				continue;
			bsb.append(num+" ");
			visited[num]=true;
			for(int i : list[num]) {
				if(!visited[i])
					q.add(i);
			}
		}
	}
}