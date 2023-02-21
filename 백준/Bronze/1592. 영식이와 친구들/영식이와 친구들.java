import java.io.*;
import java.util.*;

public class Main {
	static int count,M,N,L;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		count = -1;
		
		System.out.println(test(arr,0,L));
		
	}
	
	static int test(int[] array, int start, int num) {
		count++;
		array[start]++;
		if(array[start]==M)
			return count;
		else {	
			if(array[start]/2==0) {
				if((start-num)>=0)
					return test(array,start-num,num);
				else
					return test(array,start+array.length-num,num);
			}else {
				if((start+num)<array.length)
					return test(array,start+num,num);
				else
					return test(array,start-array.length+num,num);
			}
		}
	}
}