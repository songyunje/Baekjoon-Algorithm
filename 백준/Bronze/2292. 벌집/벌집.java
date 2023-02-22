import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		
		int n = 0;
		while(true) {
			n++;

			if(N<=3*n*n-3*n+1) {
				System.out.println(n);
				break;
			}	
		}
	}

}