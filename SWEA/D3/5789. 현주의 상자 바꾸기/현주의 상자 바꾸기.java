import java.io.*;
import java.util.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			for(int q=1;q<Q+1;q++) {
				st = new StringTokenizer(br.readLine()," ");
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				
				for(int i=L-1;i<R;i++) {
					arr[i]=q;
				}
			}
			
			bw.write("#"+(t+1)+" ");
			for(int i=0;i<N;i++) {
				bw.write(String.valueOf(arr[i]+" "));
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}
}