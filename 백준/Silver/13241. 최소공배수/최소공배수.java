import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long gcd = gcd(A,B);
		
		long ans = A*B/gcd;
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	static long gcd(long a, long b) {
		if(a%b==0)
			return b;
		else {
			return gcd(b,a%b);
		}
	}
}