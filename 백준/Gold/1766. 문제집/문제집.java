import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<Integer>[] arr;
	static int[] level;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=new ArrayList<>();
		}
		level = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[v].add(e);
			level[e]++;
		}
		bfs();
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	static void bfs() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1;i<=N;i++) {
			if(level[i]==0) pq.add(i);
		}
		while(!pq.isEmpty()) {
			int temp = pq.poll();
			if(!visited[temp]) {
				visited[temp]=true;
				sb.append(temp+" ");
				for(int i : arr[temp]) {
					level[i]--;
					if(level[i]==0) pq.add(i);
				}
			}
		}
	}
}