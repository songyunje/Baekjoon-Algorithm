import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		arr = new int[str.length()];
		
		for(int i=0;i<str.length();i++) {
			arr[i]=str.charAt(i)-'0';
		}
		
		for(int i=0;i<arr.length;i++) {
			int max = arr[i];
			int index = i;
			for(int j=i+1;j<arr.length;j++) {
				if(max<arr[j]) {
					max = arr[j];
					index = j;
				}
			}
			swap(i,index);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]);
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void swap(int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}
}