import java.io.*;
import java.time.format.ResolverStyle;
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
			
			Set<Integer> set = new HashSet<>();
			for(int i=0;i<N;i++) {
				int j=0;
				int temp=0;
				while(j<n) {
					temp+=a[(i+j)%N]*Math.pow(16, n-j-1);
					j++;
				}
				set.add(temp);
			}
			
			List<Integer> list = new ArrayList<>(set);
			
			Collections.sort(list, Collections.reverseOrder());
			
			sb = new StringBuilder("#"+t+" ");
			
			sb.append(list.get(K-1)+"\n");
	
			bw.write(sb.toString());
		}
		br.close();
		bw.close();
	}
}