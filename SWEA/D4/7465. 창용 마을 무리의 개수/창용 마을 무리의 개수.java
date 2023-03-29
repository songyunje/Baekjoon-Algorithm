import java.io.*;
import java.util.*;

public class Solution {
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			for(int i=1;i<N+1;i++) {
				parent[i]=i;
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			Set<Integer> set = new HashSet<>();
			for(int i=1;i<N+1;i++) {
				set.add(find(i));
			}
			
			sb.append("#"+t+" "+set.size()+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	} // main
	
	static int find(int a) {
		if(a==parent[a]) return a;
		else return parent[a]=find(parent[a]);
	} // find
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x>=y) parent[x]=find(b);
		else parent[y]=find(a);
	} // union
}