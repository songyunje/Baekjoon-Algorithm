import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count=0;
		int start=0;
		int end=N-1;
		
		while(start<end) {
			if(arr[start]+arr[end]>M) 
				end--;
			else if(arr[start]+arr[end]<M)
				start++;
			else {
				count++;
				start++;
				end--;
			}
		}
		
		bw.write(String.valueOf(count));
		br.close();
		bw.flush();
		bw.close();
				
	}
}