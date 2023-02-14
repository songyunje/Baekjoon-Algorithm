import java.io.*;
import java.util.*;

public class Solution {
	static int d;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for(int t=0;t<10;t++) {
			StringBuilder sb = new StringBuilder("#");
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<100;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int n=0;n<N;n++) {
				grounding(arr);
			}
			sb.append((t+1)+" "+d+"\n");
			bw.write(String.valueOf(sb));
			
			
		}
	
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	
	static void grounding(int[] arr) {
		Arrays.sort(arr);
		arr[0]++;
		arr[99]--;
		d=Math.max(arr[99], arr[98])-Math.min(arr[0], arr[1]);
	}

}