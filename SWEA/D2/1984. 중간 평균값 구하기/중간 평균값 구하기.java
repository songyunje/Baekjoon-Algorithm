import java.io.*;
import java.util.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringBuilder sb = new StringBuilder("#");
			int max = 0;
			int min = 10000;
			double sum = 0;
			int[] arr = new int[10];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<10;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<10;i++) {
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
			}
			for(int i=0;i<10;i++) {
				if((arr[i] != max) && (arr[i] != min))
					sum+=arr[i];
			}
			long ans = Math.round(sum/8);
			
			sb.append(t+1).append(" ").append(ans).append("\n");
			bw.write(String.valueOf(sb));
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}