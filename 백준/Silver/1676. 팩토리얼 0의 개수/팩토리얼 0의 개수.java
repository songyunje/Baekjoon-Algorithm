import java.io.*;
import java.util.*;
public class Main {
	static int two,five;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		two = 0;
		five = 0;
		for(int i=1;i<=N;i++) {
			ten(i);
		}
		System.out.println(Math.min(two,five));
	}
	static void ten(int a) {
		int temp = a;
		while(temp>=2 && temp%2==0) {
			temp=temp/2;
			two++;
		}
		while(temp>=5 && temp%5==0) {
			temp=temp/5;
			five++;
		}
	}
}