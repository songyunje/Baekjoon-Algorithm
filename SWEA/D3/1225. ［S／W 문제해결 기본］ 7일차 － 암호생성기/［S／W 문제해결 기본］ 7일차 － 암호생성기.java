import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		for(int t=0;t<10;t++) {
			String str = br.readLine();
			sb = new StringBuilder("#"+(t+1)+" ");
			st = new StringTokenizer(br.readLine()," ");
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i=0;i<8;i++) {
				q.offer(Integer.parseInt(st.nextToken()));				
			}
			
			int num = 1;
			int a = Integer.MAX_VALUE;
			while(true) {
				a = q.poll();
				if(num>5)
					num=1;
				if(a-num > 0) {
					q.offer(a-num);					
				}else {
					q.offer(0);
					break;
				}
				num++;
			}
			
			for(int i=0;i<8;i++) {
				sb.append(q.poll()+" ");
			}
			bw.write(sb.toString()+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}