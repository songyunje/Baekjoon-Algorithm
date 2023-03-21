import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = 100001;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[L];
		int[] distance = new int[L];
		
		q.add(N);
		visited[N]=true;
		distance[N]=0;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(temp != 0) {
				for(int i=temp;i<L;i*=2) {
					if(!visited[i]) {
						visited[i]=true;
						q.add(i);
						distance[i]=distance[temp];					
					}
				}				
			}
			if((temp-1)>=0 && !visited[temp-1]) {
				visited[temp-1]=true;
				distance[temp-1]=distance[temp]+1;
				q.add(temp-1);
			}
			if((temp+1)<L && !visited[temp+1]) {
				visited[temp+1]=true;
				distance[temp+1]=distance[temp]+1;
				q.add(temp+1);
			}
		}
		bw.write(String.valueOf(distance[K]));
		br.close();
		bw.close();
	}
}