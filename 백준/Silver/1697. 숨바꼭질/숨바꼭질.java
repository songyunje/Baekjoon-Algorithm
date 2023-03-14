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
		
		boolean[] visited = new boolean[100001];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		Boolean check = true;
		
		int cnt = -1;
		
		while(check) {
			cnt++;
			int s = q.size();
			for(int i=0;i<s;i++) {
				int temp = q.poll();
				visited[temp]=true;
				if(temp==K) {
					check=false;
					break;
				}
				if(temp-1>=0 && !visited[temp-1]) 
					q.add(temp-1);
				if(temp+1<100001 && !visited[temp+1]) 
					q.add(temp+1);
				if(temp*2<100001 && !visited[temp*2])
					q.add(temp*2);
			}
		}
		bw.write(String.valueOf(cnt));
		br.close();
		bw.close();
	}
}