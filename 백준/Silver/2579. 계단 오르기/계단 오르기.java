import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		int[] dp = new int[N + 1];
 
		int pre=0;
		int temp=0;
		for (int i = 1; i <= N; i++) {
			pre=temp;
			temp = Integer.parseInt(br.readLine());
			if(i==1) dp[1]=temp;
			else if(i==2) dp[2]= dp[1]+temp;
			else dp[i]=Math.max(dp[i-2], dp[i-3]+pre)+temp;
		}
		
		System.out.println(dp[N]);

	}
 
}