import java.io.*;
import java.util.*;



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T= Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine()," ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int d = 1;
			
			for(int i=0;i<N;i++){
				if(arr[i]/M*K < i+1) {
					d=0;
					break;
				}
			}
			
			if(d==0) {
			bw.write("#"+(t+1)+" Impossible"+"\n");
			}else {
				bw.write("#"+(t+1)+" Possible"+"\n");
			}

		}


		br.close();
		bw.flush();
		bw.close();
		
	}
}