import java.io.*;
import java.util.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		

		for(int t=0;t<T;t++) {
			int max = -1;
			int mlt;
			StringBuilder sb = new StringBuilder("#");
			int N = Integer.parseInt(br.readLine());
			
			st= new StringTokenizer(br.readLine()," ");
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			if(N==1) {
				max=arr[0];
			}
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					mlt = arr[i]*arr[j];
					if(check(mlt)) {
						max=Math.max(max, mlt);
					}
				}
			}
	
		
			sb.append((t+1)).append(" ").append(max).append("\n");
			
			bw.write(String.valueOf(sb));
			
		}
		
		br.close();
		bw.flush();
		bw.close();

	} 
	
	public static boolean check(int num) {
		int a=9;
		int b;
		while(num>0) {
			
			b=num%10;
			if(b>a) {
				return false;
			}
			num=num/10;
			a=b;
		}
		return true;
	}
}