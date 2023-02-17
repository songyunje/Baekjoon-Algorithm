import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		
		for(int t=0;t<10;t++) {
			sb = new StringBuilder("#");
			String nothing = br.readLine();
			String target = br.readLine();
			String input = br.readLine();
			int count = 0;
			for(int i=0;i<input.length()+1-target.length();i++) {
				boolean check = true;
				for(int j=0;j<target.length();j++) {
					if(input.charAt(i+j) != target.charAt(j)){
						check=false;
					}
				}
				if(check)
					count++;
			}
	
			sb.append((t+1)+" "+count+"\n");
			bw.write(String.valueOf(sb));
		
		}
		
		br.close();
		bw.flush();
		bw.close();	
	}
}