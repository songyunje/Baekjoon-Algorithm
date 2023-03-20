import java.io.*;
import java.util.*;

public class Main {
	static int[] distance;
	static boolean[] visited;
	static List<node>[] arr;
	static PriorityQueue<node> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());
		
		arr = new ArrayList[N+1];
		distance = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1;i<N+1;i++) {
			arr[i]=new ArrayList<>();
			distance[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arr[U].add(new node(V,C));
		}
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>(new Comparator<node>() {

			@Override
			public int compare(node o1, node o2) {
				return o1.c-o2.c;
			}
		});
		
		dix(start);
		
		bw.write(String.valueOf(distance[end]));
		br.close();
		bw.close();
		
	}
	
	
	static void dix(int a) {
		distance[a]=0;
		pq.add(new node(a,0));
		
		while(!pq.isEmpty()) {
			node temp = pq.poll();
			if(!visited[temp.v]) {
				visited[temp.v]=true;
				for(node n : arr[temp.v]) {
					if(distance[n.v]>distance[temp.v]+n.c)
						distance[n.v]=distance[temp.v]+n.c;
					pq.add(new node(n.v,distance[n.v]));
				}
			}
		}
	} // dix
	
	static class node{
		int v;
		int c;
		public node(int v, int c) {
			this.v = v;
			this.c = c;
		}
	} // node
}