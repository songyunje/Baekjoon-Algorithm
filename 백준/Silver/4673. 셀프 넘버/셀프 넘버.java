import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] arr = new int[10036];
		arr[0]=1;
		for(int i=1;i<10000;i++) {
			arr[d(i)]=1;
		}
		for(int i=0;i<10001;i++) {
			if(arr[i] !=1) {
				System.out.println(i);
			}
		}
	}
	
	
	static int d(int n) {
		int sum=n;
		while(n>0) {
			sum+=n%10;
			n=n/10;
		}
		return sum;
	}
}