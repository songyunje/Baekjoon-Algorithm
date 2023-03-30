import java.io.*;
import java.util.*;
public class Solution {
	static int N,K;
	static List<Integer>[] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=1;t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new ArrayList[101];
			visited = new boolean[101];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<101;i++) {
				map[i]=new ArrayList<>();
			}
			for(int i=0;i<N/2;i++) {
				map[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			Queue<Integer> q = new LinkedList<>();
			q.add(K);
			visited[K]=true;
			
			int max = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				int tempmax=0;
				for(int s=0;s<size;s++) {
					int temp = q.poll();
					for(int i : map[temp] ) {
						if(!visited[i]) {
							visited[i]=true;
							q.add(i);
							tempmax=Math.max(tempmax, i);
						}
					}
				}
				if(tempmax !=0) max=tempmax;
			} // while
			
			sb.append("#"+t+" "+max+"\n");
		} // test case
		bw.write(sb.toString());
		br.close();
		bw.close();
	} // main
}