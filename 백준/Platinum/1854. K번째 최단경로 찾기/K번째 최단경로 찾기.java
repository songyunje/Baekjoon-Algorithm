import java.io.*;
import java.util.*;

public class Main {
	static int n,m,k;
	static List<node>[] arr;
	static Queue<node> q;
	static PriorityQueue<Integer>[] distance; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine().trim()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		q = new LinkedList<>();
		distance = new PriorityQueue[n+1];
		
		for(int i=1;i<n+1;i++) {
			arr[i]=new ArrayList<>();
			distance[i]=new PriorityQueue<>(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}	
			});
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a].add(new node(b,c));
		}
		
		dix();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<n+1;i++) {
			if(distance[i].size()<k)
				sb.append(-1+"\n");
			else
				sb.append(distance[i].poll()+"\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
		
		
	} // main
	
	static void dix() {
		q.add(new node(1,0));
		distance[1].add(0);
		while(!q.isEmpty()) {
			node temp = q.poll();
			for(node n : arr[temp.v]) {
				if(distance[n.v].size()<k) {
					distance[n.v].add(temp.t+n.t);
					q.add(new node(n.v,temp.t+n.t));
				}
				else {
					if(distance[n.v].peek()>temp.t+n.t) {
						distance[n.v].poll();
						distance[n.v].add(temp.t+n.t);
						q.add(new node(n.v,temp.t+n.t));
					}
				}
			}
		}
	} // dix
	
	static class node{
		int v;
		int t;
		public node(int v, int t) {
			this.v = v;
			this.t = t;
		}
	} // node
}