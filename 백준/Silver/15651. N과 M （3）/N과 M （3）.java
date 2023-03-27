import java.io.*;
import java.util.*;
public class Main {
	static int N,M;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel=new int[M];
		
		run(0);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	static void run(int a) {
		if(a==M) {
			for(int i=0;i<M;i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=N;i++) {
			sel[a]=i;
			run(a+1);
		}	
	}
}