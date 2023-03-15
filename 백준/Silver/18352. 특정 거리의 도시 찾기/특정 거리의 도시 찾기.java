import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] arr;
	static int[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		visited = new int[N+1];
		
		for(int i=1;i<N+1;i++) {
			arr[i]=new ArrayList<>();
			visited[i]=-1;
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			arr[V].add(E);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		visited[X]=0;
		int cnt=0;
		while(true) {
			if(cnt==K)
				break;
			cnt++;
			int s = q.size();
			for(int i=0;i<s;i++) {
				int temp = q.poll();
				for(int a : arr[temp]) {
					if(visited[a] == -1) {
						visited[a]=cnt;
						q.add(a);
					}	
				}
			}
		}
		Boolean check = false;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<N+1;i++) {
			if(visited[i]==K) {
				sb.append(i+"\n");
				check=true;
			}
		}
		
		if(check)
			bw.write(sb.toString());
		else
			bw.write(String.valueOf(-1));
		
		br.close();
		bw.close();
	}
}