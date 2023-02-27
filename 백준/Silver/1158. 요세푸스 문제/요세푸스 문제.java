import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		int num=1;
		while(num<N+1) {
			q.offer(num++);
		}
		StringBuilder sb = new StringBuilder("<");
		
		int count=0;
		while(!q.isEmpty()) {
			count++;
			if(count==K) {
				sb.append(q.poll());
				if(!q.isEmpty())
					sb.append(", ");
				count=0;
			}else {
				q.offer(q.poll());				
			}
		}
		
		sb.append(">");
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();	
	}

}