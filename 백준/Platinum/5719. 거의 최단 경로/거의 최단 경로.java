import java.io.*;
import java.util.*;

public class Main {
	static class node{
		int v;
		int p;
		public node(int v, int p) {
			this.v = v;
			this.p = p;
		}
	}
	static boolean[] visited;
	static int[] distance;
	static List<node>[] arr;
	static PriorityQueue<node> pq;
	static List<Integer>[] parent;
	static boolean[][] use;
	static int N,M,S,D;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine().trim()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0)
				break;
			
			st = new StringTokenizer(br.readLine().trim()," ");
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N];
			distance = new int[N];
			arr = new ArrayList[N];
			parent = new ArrayList[N];
			use = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				arr[i] = new ArrayList<>();
				parent[i] = new ArrayList<>();
				distance[i]=Integer.MAX_VALUE;
			}
			
			pq = new PriorityQueue<>(new Comparator<node>() {
				public int compare(node o1, node o2) {
					return o1.p-o2.p;
				}	
			});
			
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				arr[U].add(new node(V,P));
			}
			
			dix(S);

			back();
			
			for(int i=0;i<N;i++) {
				distance[i]=Integer.MAX_VALUE;
				visited[i]=false;
			}

			
			dix(S);
			
			if(distance[D]==Integer.MAX_VALUE)
				bw.write(String.valueOf(-1)+"\n");
			else
				bw.write(String.valueOf(distance[D])+"\n");
			
			
		} // testcase
		
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
				for(node n : arr[temp.v]) {
					if(!use[temp.v][n.v]) {
						if(distance[n.v]==distance[temp.v]+n.p)
							parent[n.v].add(temp.v);
						else if(distance[n.v]>distance[temp.v]+n.p) {
							distance[n.v]=distance[temp.v]+n.p;
							parent[n.v].clear();
							parent[n.v].add(temp.v);
							pq.add(new node(n.v,distance[n.v]));
						}
					}
				}
			}
		}
	} //dix
	
	static void back() {
		Queue<Integer> q = new LinkedList<>();
		q.add(D);
		visited = new boolean[N];
		visited[D]=true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i : parent[temp]) {
				use[i][temp]=true;
				if(!visited[i]) {
					visited[i]=true;
					q.add(i);
				}	
			}
		}
	} // back
}