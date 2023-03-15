import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		num = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			arr[i]=new ArrayList<>();
		}
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			arr[V].add(E);
		}
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			visited[i]=true;
			dfs(i);
		}
		int max = 0;
		for(int i=1;i<N+1;i++) {
			max= Math.max(max, num[i]);
		}
		
		sb = new StringBuilder();
		
		for(int i=1;i<N+1;i++) {
			if(num[i]==max) {
				sb.append(i+" ");
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	static void dfs(int a) {
		num[a]++;
		for(int i : arr[a]) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i);
			}
		}
	}
}