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
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			for(int i=1;i<=n;i++) {
				parent[i]=i;
			}
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(k==0) union(a,b);
				else if(k==1) check(a, b);
			}
			sb.append("\n");
		} // test case
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
	
	static void check(int a, int b) {
		if(find(a)==find(b)) sb.append(1);
		else sb.append(0);
	} // check and add
}