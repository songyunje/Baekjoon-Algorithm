import java.io.*;
import java.util.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		

		for(int t=0;t<T;t++) {
			int max = 0;
			int mlt;
			int ans;
			StringBuilder sb = new StringBuilder("#");
			int N = Integer.parseInt(br.readLine());
			
			st= new StringTokenizer(br.readLine()," ");
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			if(arr.length==1) {
				max=arr[0];
			}
			
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					mlt = arr[i]*arr[j];
					String mltS = Integer.toString(arr[i]*arr[j]);
					int status=0;
					if(mltS.length()==1) {
						status=1;
					}
					else {
						for(int k=0;k<mltS.length()-1;k++) {
							if((mltS.charAt(k)-'0')<=(mltS.charAt(k+1)-'0')) {
								status=1;
							}
							else {
								status=0;
								break;
							}
						}
					}
					
					if(status==1) {
						max=Math.max(max, mlt);
					}
						
				}
			}
			if(max==0) {
				ans=-1;
			}
			else {
				ans=max;
			}
			
			sb.append((t+1)).append(" ").append(ans).append("\n");
			
			bw.write(String.valueOf(sb));
			
		}
		
		br.close();
		bw.flush();
		bw.close();

	} 
}