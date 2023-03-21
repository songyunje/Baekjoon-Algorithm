import java.io.*;
import java.util.*;
public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			parent[i]=i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int c = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if(c==0) {
				combine(V,E);
			}
			
			if(c==1) {
					if(check(V,E))
						sb.append("YES"+"\n");
					else
						sb.append("NO"+"\n");
				}

		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static int find(int a) {
		if(a == parent[a]) {
			return a;
		}
		parent[a]=find(parent[a]);
		return parent[a];
	}
	
	static void combine(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x<=y)
			parent[y]=x;
		else
			parent[x]=y;
	}
	
	static Boolean check(int a, int b) {
		if(find(a)==find(b))
			return true;
		else
			return false;
	}
}