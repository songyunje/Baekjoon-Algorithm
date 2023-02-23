import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int count,K,N,ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		int[] array = new int[N];
		
		for(int i=0;i<N;i++) {
			array[i]= sc.nextInt();
		}
		
		count=0;
		
		merge_sort(array);
		
		if(count<K)
			ans= -1;
		
		System.out.println(ans);
		
	}
	
	
	
	static void merge_sort(int[] arr) {
		helpmerge_sort(arr,0,arr.length-1);
	}
	
	static void helpmerge_sort(int[] arr, int a, int b) {
		if(a<b) {
			int mid  = (a+b)/2;
			helpmerge_sort(arr,a,mid);
			helpmerge_sort(arr,mid+1,b);
			merge(arr, a, mid, b);
		}
		
	}
	
	static void merge(int[] arr,int a, int mid, int c){
		int i = a;
		int j = mid+1;
		int k = 0;
		int[] tmp = new int[c-a+1];
		
		while(i<=mid && j<=c) {
			if(arr[i]<=arr[j]) {
				tmp[k++]=arr[i++];
			}else {
				tmp[k++]=arr[j++];
			}
		}
		
		while(i<=mid) {
			tmp[k++]=arr[i++];
		}
		while(j<=c) {
			tmp[k++]=arr[j++];
		}
		
		for(int t=0;t<tmp.length;t++) {
			arr[a+t]=tmp[t];
			count++;
			if(count==K)
				ans=tmp[t];
		}
	}
	

}