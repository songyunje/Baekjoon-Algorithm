import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int count = 0;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int n=0;n<N;n++) {
			int temp = Integer.parseInt(st.nextToken());
			if(pn(temp) && temp != 1) {
				count++;
			}
		}
		
		bw.write(String.valueOf(count));
		br.close();
		bw.close();
	}
	
	static Boolean pn(int a) {
		if(a<=2)
			return true;
		else {
			for(int i=2;i<=a/2;i++) {
				if(a%i ==0)
					return false;
			}
		}
		return true;
	}
}