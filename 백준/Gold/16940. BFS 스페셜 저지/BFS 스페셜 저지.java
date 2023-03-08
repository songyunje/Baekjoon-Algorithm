import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static Queue<Integer> q;
	static boolean[] visited;
	static int[] a, order;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		
		arr = new ArrayList[N+1];
		q = new LinkedList<>();
		visited = new boolean[N+1];
		
		for(int i=0;i<N+1;i++) {
			arr[i]= new ArrayList<>();
		} // arr 초기화
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[v].add(e);
			arr[e].add(v);
		} // 간선 정보 입력
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		a = new int[N+1];
		order = new int[N+1];
		for(int i=1;i<=N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
			order[a[i]]=i;
		} // 방문 순서 입력
		
		for(int i=1;i<N+1;i++) {
			Collections.sort(arr[i], new Comparator<Integer>() {
				
				@Override
				public int compare(Integer o1, Integer o2) {
					return order[o1]-order[o2];
				}
			});
		}	// array 정렬
		
		q.add(1);
		bw.write(String.valueOf(bfs()));
		br.close();
		bw.close();
		
	} // main
	
	static int bfs() {
		int index=0;
		while(!q.isEmpty()){
			index++;
			int temp = q.poll();
			if(order[temp] != index) {
				return 0;				
			}
			visited[temp]=true;
			for(int i : arr[temp]) {
				if(!visited[i])
					q.add(i);
			}			
		}
		return 1;
	}  // bfs
}