import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String st = br.readLine();
			int[] arr = new int[st.length()];
			
			for(int l=0;l<st.length();l++) {
				arr[l]=st.charAt(l)-'0';
			}
			
			int count=0;
			int sum=arr[0];
			for(int i=1;i<arr.length;i++) {
				if(sum<i) {
					count+=(i-sum);
					sum=i+arr[i];
				}
				else {
					sum+=arr[i];
				}
			}
			
			bw.write("#"+(t+1)+" "+count+"\n");
			
			
		}

		br.close();
		bw.flush();
		bw.close();
	}
}