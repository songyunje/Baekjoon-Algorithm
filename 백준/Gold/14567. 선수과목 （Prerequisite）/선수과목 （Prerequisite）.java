import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static List<Integer>[] arr;
	static int[] sem, indegree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		indegree = new int[N+1];
		sem = new int[N+1];
		for(int i=0;i<N+1;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			indegree[b]++;
		}
		dix(1);
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<N+1;i++) {
			sb.append(sem[i]+" ");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	} // main
	
	static void dix(int a) {
		int cnt=0;
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<N+1;i++) {
			if(indegree[i]==0) q.add(i);
		}
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for(int i=0;i<size;i++) {
				int temp = q.poll();
				sem[temp]=cnt;
				for(int n : arr[temp]) {
					indegree[n]--;
					if(indegree[n]==0) q.add(n);
				}
			}
		}
	} // dix
}