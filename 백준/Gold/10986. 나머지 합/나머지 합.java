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
		
		long[] left = new long[M];
		
		st = new StringTokenizer(br.readLine()," ");
		
		long count = 0;
		long sum = 0;
		for(int i=1;i<N+1;i++) {
			sum+=Integer.parseInt(st.nextToken());
			if(sum%M==0) 
				count++;
			left[(int)(sum%M)]++;
		}
		
		for(int i=0;i<M;i++) {
			if(left[i]>=2)
			count+=left[i]*(left[i]-1)/2;
		}
		
		bw.write(String.valueOf(count));
		br.close();
		bw.flush();
		bw.close();
	}

}