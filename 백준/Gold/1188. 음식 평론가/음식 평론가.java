import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N>M)
			N=N-M;
		
		int gcd = gcd(M,N);
		
		System.out.println((M/gcd-1)*gcd);
			
		

		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	static int gcd(int A, int B) {
		if(A%B==0)
			return B;
		else {
			return gcd(B,A%B);
		}
	}
}