import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		int temp;
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
			temp=arr[i];
			int next = Integer.parseInt(st.nextToken());
			for(int j=0;j<next;j++) {
				arr[i-j]=arr[i-j-1];
			}
			arr[i-next]=temp;
		}
		
		for(int i=0;i<N;i++) {
			sb.append(arr[i]+" ");
		}
		
		bw.write(String.valueOf(sb));
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}