import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr,sel;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		sel = new int[M];
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		com(0,0);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	static void com(int a, int b) {
		if(b==M) {
			for(int i=0;i<M;i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		if(a>N-1) return;
		
		sel[b]=arr[a];
		com(a+1,b+1);
		com(a+1,b);
	}
}