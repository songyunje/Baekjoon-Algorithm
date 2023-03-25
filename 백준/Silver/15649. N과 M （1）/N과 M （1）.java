import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr,sel;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		per(0);
		bw.write(sb.toString());
		br.close();
		bw.close();

	}
	static void per(int a) {
		if(a==M) {
			for(int i=0;i<M;i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			sel[a]=arr[i];
			visited[i]=true;
			per(a+1);
			visited[i]=false;
		}
		
	}
}