import java.io.*;
import java.util.*;

public class Main  {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int sum =0;
		
		if(N==1)
			sum=arr[0];
		else {
			for(int i=0;i<N;i++) {
				if(arr[i]<0) {
					if(i+1<N) {
						if(arr[i+1]<0) {
							sum+=arr[i]*arr[i+1];
							i++;
						}else if(arr[i+1]==0) {
							sum+=arr[i]*arr[i+1];
							break;
						}else if(arr[i+1]>0) {
							sum+=arr[i];
							break;
						}						
					}else {
						sum+=arr[i];
						break;
					}
				}else {
					break;
				}
			}
			
			for(int i=N-1;i>=0;i--) {
				if(arr[i]>0) {
					if(i-1>=0) {
						if(arr[i-1]>1) {
							sum+=arr[i-1]*arr[i];
							i--;
						}else if(arr[i-1]==1) {
							sum+=arr[i]+arr[i-1];
							i--;
						}else {
							sum+=arr[i];
							break;
						}	
					}else {
						sum+=arr[i];
						break;
					}
				}else {
					break;
				}
			}
		}
		
		bw.write(Integer.toString(sum));
		
		br.close();
		bw.flush();
		bw.close();
	}
}