import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<node>[] arr;
	static int[] degree;
	static int[] distance;
	static PriorityQueue<node> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		arr = new ArrayList[N+1];
		degree = new int[N+1];
		distance = new int[N+1];
		pq = new PriorityQueue<>(new Comparator<node>() {
			public int compare(node o1, node o2) {
				return o2.t-o1.t;
			}	
		});
		
		for(int i=0;i<N+1;i++) {
			arr[i]=new ArrayList<>();
			distance[i]=Integer.MIN_VALUE;
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int T = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			if(L==0) {
				arr[0].add(new node(i,T));
				degree[i]++;
			}
			for(int l=0;l<L;l++) {
				arr[Integer.parseInt(st.nextToken())].add(new node(i,T));
				degree[i]++;
			}
		}

		for(int i=0;i<N+1;i++) {
			if(distance[i]==Integer.MIN_VALUE)
		   		dix(i);
		}
		
		Arrays.sort(distance);
		
		bw.write(String.valueOf(distance[N]));
		br.close();
		bw.close();	
	} // main
	
	static void dix(int a) {
		pq.add(new node(a,0));
		distance[a]=0;
		while(!pq.isEmpty()) {
			node temp = pq.poll();
			for(node n : arr[temp.v]) {
				if(distance[n.v]<distance[temp.v]+n.t) {
					distance[n.v]=distance[temp.v]+n.t;
				}
				if(--degree[n.v]==0) {
					pq.add(new node(n.v,distance[n.v]));
				}
			}
		}
		
	} // dix

	static class node{
		int v;
		int t;
		public node(int v, int t){
			this.v=v;
			this.t=t;
		}
	} // node
}