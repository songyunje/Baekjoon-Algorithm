import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			int ans=30;
			for(int i=1;i<11;i++) {
				Boolean state = true;
				for(int k=0;k<i;k++) {
					for(int j=0;j<str.length();j++) {
						if(j%i==k && str.charAt(j) != str.charAt(k))
							state=false;
					}
				}
				if(state) {
					ans=i;
					break;					
				}
			}	
			
			sb.append("#"+(t+1)+" "+ans+"\n");
			bw.write(sb.toString());
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}