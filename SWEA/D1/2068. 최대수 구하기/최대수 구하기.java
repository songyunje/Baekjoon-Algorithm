import java.io.*;
import java.util.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringBuilder sb = new StringBuilder("#");
			int max = 0;
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<10;i++) {
				max = Math.max(max, Integer.parseInt(st.nextToken()));
			}
			
			sb.append(t+1).append(" ").append(max).append("\n");
			bw.write(String.valueOf(sb));
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}