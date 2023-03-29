import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int temp = N/5;
		
		switch(N%5) {
		case 0 : System.out.println(temp); break;
		case 1 : if(temp>=1) System.out.println(temp+1);
				else System.out.println(-1); break;
		case 2 : if(temp>=2) System.out.println(temp+2);
				else System.out.println(-1); break;
		case 3 : System.out.println(temp+1); break;
		case 4 : if(temp>=1) System.out.println(temp+2);
		        else System.out.println(-1); break;
		}
	}

}