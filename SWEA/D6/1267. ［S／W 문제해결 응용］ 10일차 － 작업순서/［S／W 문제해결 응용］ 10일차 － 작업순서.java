import java.io.*;
import java.util.*;
public class Solution {
	static int V,E;
	static List<Integer>[] arr;
	static int[] level;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			arr = new ArrayList[V+1];
			for(int i=1;i<=V;i++) {
				arr[i]=new ArrayList<>();
			}
			level = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				level[b]++;
			}
			sb.append("#"+t+" "+top()+"\n");	
		}
		bw.write(sb.toString());
		br.close();
		bw.close();		
	} // main
	static String top() {
		StringBuilder tsb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=V;i++) {
			if(level[i]==0) q.add(i);
		}
		while(!q.isEmpty()) {
			int temp = q.poll();
			tsb.append(temp+" ");
			for(int i : arr[temp]) {
				level[i]--;
				if(level[i]==0) q.add(i);
			}
		}
		return tsb.toString();
	}
}