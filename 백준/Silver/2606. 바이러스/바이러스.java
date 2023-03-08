import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] array;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
	
		int M = Integer.parseInt(br.readLine().trim());
		
		array = new ArrayList[N+1];
		visited = new boolean[N+1];
		ans=0;
		
		for(int i=0;i<N+1;i++) {
			array[i]=new ArrayList<>();
		}
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine().trim());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			array[v].add(e);
			array[e].add(v);
		}
		
		dfs(1);
		
		bw.write(String.valueOf(ans-1));
		br.close();
		bw.flush();
		bw.close();
		
	} //main
	
	
	static void dfs(int num) {
		if(visited[num])
			return;
		visited[num]=true;
		ans++;
		for(int i : array[num]) {
			if(!visited[i]) 
				dfs(i);
		}
	} //dfs
}
