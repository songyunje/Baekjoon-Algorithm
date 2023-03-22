import java.io.*;
import java.util.*;

public class Main {
	static int count,K,N;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim()," ");
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		merge_sort(arr);
		if(count<K)
			bw.write(String.valueOf(-1));
		else
			bw.write(sb.toString());
		br.close();
		bw.close();
	} // main
	
	static void merge_sort(int[] arr) {
		helpmerge(arr,0,arr.length-1);
	} // merge_sort
	
	static void helpmerge(int[] arr, int a, int b) {
		if(a<b) {
			int mid = (a+b)/2;
			helpmerge(arr,a,mid);
			helpmerge(arr,mid+1,b);
			merge(arr,a,mid,b);
		}
	} // helpmerge
	
	static void merge(int[] arr, int a, int mid, int c) {
		int x = a;
		int y = mid+1;
		int z = 0;
		int[] temp = new int[c-a+1];
		while(x<=mid && y<=c) {
			if(arr[x]<=arr[y]) 
				temp[z++]=arr[x++];
			else 
				temp[z++]=arr[y++];
		}
		
		while(x<=mid)
			temp[z++]=arr[x++];
		while(y<=c)
			temp[z++]=arr[y++];
		for(int i=0;i<temp.length;i++) {
			arr[a+i]=temp[i];
			count++;
			
			if(count==K) {
				for(int j=0;j<N;j++) {
					sb.append(arr[j]+" ");
				}
			}
		}
	} // merge
}