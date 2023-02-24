import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[] x = new int[7];
		int[] y = new int[7];
		
		int cx=0;
		int cy=0;
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=6;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int d = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			switch(d){
			case 1: 
				cx+=v;
				break;
			case 2: 
				cx-=v;
				break;
			case 3: 
				cy-=v;
				break;
			case 4: 
				cy+=v;
				break;
			}
			
			x[i]=cx;
			y[i]=cy;
		}
		
		bw.write(String.valueOf(area(x,y)*K));
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	static int area(int[] a,int[] b) {
		int sum1=0;
		int sum2=0;
		for(int i=0;i<a.length-1;i++) {
			sum1+=a[i]*b[i+1];
			sum2+=b[i]*a[i+1];
		}

		return Math.abs(sum1-sum2)/2;
	}
}