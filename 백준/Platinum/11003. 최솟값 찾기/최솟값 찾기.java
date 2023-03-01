import java.io.*;
import java.util.*;

public class Main {
	static class input{
		int index;
		int value;
		
		public input(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Deque<input> q = new LinkedList<>();
		
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) {
			input next = new input(i,Integer.parseInt(st.nextToken()));
			while(!q.isEmpty() && q.getLast().value>next.value) {
				q.removeLast();
			}
			q.add(next);
			if(q.peek().index<=i-L)
				q.removeFirst();
			
			sb.append(q.peek().value+" ");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}