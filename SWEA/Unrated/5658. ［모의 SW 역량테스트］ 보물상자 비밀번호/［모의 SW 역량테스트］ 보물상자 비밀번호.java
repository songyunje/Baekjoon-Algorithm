import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int n = N/4;
			
			int[] a = new int[N];
			
			String str = br.readLine().trim();
			
			for(int i=0;i<N;i++) {
				int temp = str.charAt(i)-'0';
				if(temp>10)
					a[i]=temp-7;
				else
					a[i]=temp;
			}
			
			int[] arr = new int[N];

			for(int i=0;i<N;i++) {
				int j=0;
				int temp=0;
				while(j<n) {
					temp+=a[(i+j)%N]*Math.pow(16, n-j-1);
					j++;
				}
				arr[i]=temp;
			}
			
			Arrays.sort(arr);
			
			sb = new StringBuilder("#"+t+" ");
			int cnt=0;
			for(int i=N-1;i>=0;i--) {
				if(i==N-1)
					cnt++;
				else {
					if(arr[i]==arr[i+1])
						continue;
					else
						cnt++;	
				}
				if(cnt==K)
					sb.append(arr[i]+"\n");
			}
			bw.write(sb.toString());
		}
		br.close();
		bw.close();
	}
}