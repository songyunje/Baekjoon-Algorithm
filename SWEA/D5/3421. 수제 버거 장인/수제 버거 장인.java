import java.io.*;
import java.util.*;
public class Solution {
	static int N,cnt;
	static int[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;	
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1;t<=T;t++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	cnt=0;
        	check = new int[N+1];

        	for(int m=0;m<M;m++) {
        		st = new StringTokenizer(br.readLine());
            	int v = Integer.parseInt(st.nextToken());
            	int e = Integer.parseInt(st.nextToken());
            	
            	check[v]=check[v]|(1<<e);
            	check[e]=check[e]|(1<<v);
        	}
        	burger(1,0);
        	
        	sb.append("#"+t+" "+cnt+"\n");
        } // testcase
        bw.write(sb.toString());
        br.close();
        bw.close();
	} // main
	static void burger(int a, int b) {
		if(a>N) {
			cnt++;
			return;
		}
		if((b&check[a])>0) burger(a+1,b);
		else {
			burger(a+1,b);
			burger(a+1,b|(1<<a));
		}
	} // burger

}