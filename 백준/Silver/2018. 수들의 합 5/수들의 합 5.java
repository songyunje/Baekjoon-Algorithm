import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count=1; 
		
		int start=1;
		int end=1;
		
		int sum=1;
		
		while(end != N) {
			if(sum>N) {
				sum-=start;
				start++;
			}else if(sum<N) {
				sum+=end+1;
				end++;
			}else {
				count++;
				sum+=end+1;
				end++;
			}
			
		}
		
		System.out.println(count);
	}

}