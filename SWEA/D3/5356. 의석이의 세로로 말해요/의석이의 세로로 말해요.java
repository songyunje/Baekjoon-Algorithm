import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			sb = new StringBuilder("#"+(t+1)+" ");
			Character[][] map = new Character[5][15];
			
			for(int i=0;i<5;i++) {
				String str = br.readLine();
				for(int j=0;j<str.length();j++) {
					map[i][j]=str.charAt(j);
				}
			}
			
			for(int j=0;j<map[0].length;j++) {
				for(int i=0;i<map.length;i++) {
					if(map[i][j] != null) {
						sb.append(map[i][j]);
					}
				}
			}
			
			sb.append("\n");
			
			bw.write(sb.toString());

		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}