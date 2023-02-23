import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			q.offer(Integer.parseInt(br.readLine()));
		}
		

		int min = 0;
		
		while(q.size()>1) {
			int a = q.poll();
			int b = q.poll();
			
			min+=(a+b);
			q.offer(a+b);	
		}

		
		System.out.println(min);
	}
}