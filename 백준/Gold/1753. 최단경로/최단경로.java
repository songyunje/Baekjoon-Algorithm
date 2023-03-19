import java.io.*;
import java.util.*;

public class Main {
	static int V,E,start;
	static int[] distance;
	static boolean[] visited;
	static List<node>[] arr;
	static PriorityQueue<node> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine().trim());
		
		visited = new boolean[V+1];
		
		distance = new int[V+1];
		
		arr = new ArrayList[V+1];
		
		for(int i=0;i<V+1;i++) {
			arr[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
		
			arr[u].add(new node(v,w));
		}
		
		pq = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o1.w-o2.w;
			}	
		});
		
		dix(start);
		
		sb = new StringBuilder();
		
		for(int i=1;i<V+1;i++) {
			if(visited[i])
				sb.append(distance[i]+"\n");
			else
				sb.append("INF"+"\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
		
	} // main
	
	static void dix(int a) {
		distance[a]=0;
		pq.add(new node(a,0));
		while(!pq.isEmpty()) {
			node temp = pq.poll();
			if(!visited[temp.v]) {
				visited[temp.v]=true;
				for(node i : arr[temp.v]) {
					if(distance[i.v]>distance[temp.v]+i.w)
						distance[i.v]=distance[temp.v]+i.w;
					pq.add(new node(i.v,distance[i.v]));
				}
			}
		}
	} //dix
	
	static class node{
		int v;
		int w;
		public node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	} // node
}