import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(binary(N));
	}
	static BigInteger binary(int a) {
		if(a==1) return BigInteger.ZERO;
		if(a==2) return BigInteger.ONE;
		
		if(a%2==0) return binary(a-1).multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
		else return binary(a-1).multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(-1));
	}

}