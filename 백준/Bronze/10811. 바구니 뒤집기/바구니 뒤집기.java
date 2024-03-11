import java.io.*;
import java.util.*;

public class Main {
	static int[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			change(a, b);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<N+1; i++) {
			sb.append(list[i]+" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void change(int a, int b) {
		if ((b-a) % 2 == 0 ) {
			int end = b;
			for(int i=a; i<=((b+a)/2); i++) {
				list[0] = list[i];
				list[i] = list[end];
				list[end--] = list[0];
			}
		} else {
			int end = b;
			for(int i=a; i<=((b+a)/2); i++) {
				list[0] = list[i];
				list[i] = list[end];
				list[end--] = list[0];
			}
		}
	}

}