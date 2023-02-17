import java.io.*;
import java.util.*;

public class Solution  {
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			sb = new StringBuilder("#");
			
			boolean check = true;
			
			String str = br.readLine();
			
			for(int i=0;i<str.length()/2;i++) {
				if(str.charAt(i) != str.charAt(str.length()-1-i))
					check=false;
			}
			
			if(check) {
				sb.append((t+1)+" "+1+"\n");
				bw.write(String.valueOf(sb));
			}else {
				sb.append((t+1)+" "+0+"\n");
				bw.write(String.valueOf(sb));
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}