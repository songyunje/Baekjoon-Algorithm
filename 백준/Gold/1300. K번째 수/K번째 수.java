import java.io.*;
import java.util.*;



public class Main  {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		

		int start = 1;
		int end = K;
		
		while(start<end) {
			int count = 0;
			int mid = (start+end)/2;
			for(int i=1;i<=N;i++) {
				count+=Math.min(mid/i, N);
			}
			if(count>=K) {
				end=mid;

			}
			else {
				start=mid+1;
			}
		}

		
		bw.write(String.valueOf(end));

		
		br.close();
		bw.flush();
		bw.close();
		
	}
}