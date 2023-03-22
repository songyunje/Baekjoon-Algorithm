import java.io.*;
import java.util.*;

public class Main {
	static int N,K,count;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count = 0;
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quick_sort(arr);
		
		if(count<K)
			bw.write(String.valueOf(-1));
		else
			bw.write(sb.toString());
		br.close();
		bw.close();
	} // main
	
	static void quick_sort(int[] arr) {
		helpquick(arr,0,arr.length-1);
	} // quick_sort
	
	static void helpquick(int[] arr, int a, int b) {
		if(a<b) {
			int q = partition(arr,a,b);
			helpquick(arr,a,q-1);
			helpquick(arr,q+1,b);
		}
	} // helpquick
	
	static int partition(int[] arr,int a,int b) {
		int x = arr[b];
		int i = a-1;
		for(int j=a;j<b;j++) {
			if(arr[j]<=x) {
				i++;
				swap(i,j);
			}
		}
		if(i+1 != b)
			swap(i+1,b);
		return i+1;
	} // partition
	
	static void swap(int a, int b) {
		count++;
		helpswap(arr,a,b);
	} // swap
	
	static void helpswap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
		
		if(count==K) 
			sb.append(arr[a]+" "+arr[b]);
	} // helpswap
}