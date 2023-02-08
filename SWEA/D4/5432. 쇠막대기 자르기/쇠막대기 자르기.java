import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String str = br.readLine();
			
			int layer = 0;
			int num = 0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='(') {
					layer++;
				}
				else {
					if(str.charAt(i-1)=='(') {
						layer--;
						num+=layer;
					}
					else {
						layer--;
						num++;
					}
				}
			}
			bw.write("#"+(t+1)+" "+num+"\n");
			
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	
	}
}