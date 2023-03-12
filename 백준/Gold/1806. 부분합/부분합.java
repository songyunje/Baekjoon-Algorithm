import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine().trim()," ");
		

		for(int i=1;i<N+1;i++) {
			sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());;
		}
		
		
		int start = 0;
		int end = 0;
		int min = N;
		Boolean check = false;
		while(start<=end && end<N+1){
			int temp = sum[end]-sum[start];
			if(temp<S) {
				end++;
			}else if(temp>=S) {
				if(end-start<min)
					min = end-start;
				check=true;
				start++;
			}
		}
		if(check)
			bw.write(String.valueOf(min));
		else
			bw.write(String.valueOf(0));
		
		br.close();
		bw.close();
	} // main

}