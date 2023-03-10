import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] lecture = new int[N];
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		int max = 0;
		int sum = 0;
		for(int i=0;i<N;i++) {
			lecture[i]=Integer.parseInt(st.nextToken());
			sum +=lecture[i];
			if(lecture[i]>max)
				max = lecture[i];
		} 
		
		int left = max;
		int right = sum;
		
		while(left<=right) {
			int mid = (left+right)/2;
			int temp = 0;
			int cnt = 0;
			for(int i=0;i<N;i++) {
				if(temp+lecture[i]>mid) {
					cnt++;
					temp=0;
				}
				temp+=lecture[i];
			}
			if(temp != 0)
				cnt++;
			
			if(cnt>M)
				left = mid+1;
			else
				right = mid-1;
		}
	
		bw.write(String.valueOf(left));
		br.close();
		bw.close();
		
	} // main

}