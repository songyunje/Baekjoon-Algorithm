import java.io.*;
import java.util.*;

public class Solution {
	static int N,B,ans;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1;t<=T;t++) {
        	st = new StringTokenizer(br.readLine()," ");
        	N = Integer.parseInt(st.nextToken());
        	arr = new int[N];
        	ans = Integer.MAX_VALUE;
        	B = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine()," ");
        	for(int i=0;i<N;i++) {
        		arr[i]=Integer.parseInt(st.nextToken());
        	}
        	h(0,0);
        	sb.append("#"+t+" "+(ans-B)+"\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
	}
	static void h(int a, int b) {
		if(b>=B) ans = Math.min(ans, b);
		if(a>N-1) return;
		h(a+1,b);
		h(a+1,b+arr[a]);	
	}
}