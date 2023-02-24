import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] S = new long[N+1];
		
		st = new StringTokenizer(br.readLine()," ");
		S[1]=Integer.parseInt(st.nextToken());
		for(int i=2;i<N+1;i++) {
			S[i]=S[i-1]+Integer.parseInt(st.nextToken());
		}
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(S[end]-S[start-1])+"\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}
}