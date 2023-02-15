import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}

		int ans = min(K,arr);
		
		bw.write(String.valueOf(ans));
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	static int min(int n, int[] arr) {
		int num=0;
		while(n>0) {
			for(int i=N-1; i>=0;i--) {
				if(n/arr[i] != 0) {
					num+=n/arr[i];
					n=n%arr[i];
				}	
			}
		}
		return num;
	}
}