import java.io.*;
import java.util.*;

public class Main {
	static int[] array;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		array = new int[N+1];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=1;i<N+1;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int type = Integer.parseInt(st.nextToken());
			int num =Integer.parseInt(st.nextToken());
			switch(type) {
			case 1 : 
				boy(num);
				break;
			case 2 :
				girl(num);
				break;
			}
		}
		
		for(int i=1;i<N+1;i++) {
			sb.append(array[i]+" ");
			if(i%20==0)
				sb.append("\n");
		}
		
		bw.write(String.valueOf(sb));
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	
	static void girl(int i) {
		change(i);
		int start = i-1;
		int end = i+1;
		while(start>=1 && end<=N && array[start]==array[end]) {
			change(start);
			change(end);
			start--;
			end++;
		}
	}
	
	static void boy(int i) {
		for(int n=1;n<N+1;n++) {
			if(n%i==0)
				change(n);
		}
	}
	
	static void change(int i) {
		if(array[i]==1)
			array[i]=0;
		else
			array[i]=1;
	}
}