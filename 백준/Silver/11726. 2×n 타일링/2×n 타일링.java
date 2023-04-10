import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	static BigInteger[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		dp=new BigInteger[N+1];
		
		System.out.println(count(N).remainder(BigInteger.valueOf(10007)));
		
	}
	static BigInteger count(int a) {
		if(a<=2) return dp[a]=BigInteger.valueOf(a);
		else if(dp[a]!=null) return dp[a];
		else return dp[a]=count(a-1).add(count(a-2));
	}

}