import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		for(int t=0;t<10;t++) {
			sb = new StringBuilder("#");
			st = new StringTokenizer(br.readLine()," ");
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[V+1];
			
			for(int i=1;i<V+1;i++) {
				arr[i]=i;
			}
			
			st = new StringTokenizer(br.readLine()," ");
			
			int[][] map = new int[V+1][V+1];
			
			for(int e=0;e<E;e++) {
				int i = index(arr, Integer.parseInt(st.nextToken()));
				int j = index(arr, Integer.parseInt(st.nextToken()));
				map[i][j]++;
			}
			
//			for(int i=0;i<V+1;i++) {
//				for(int j=0;j<V+1;j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			for(int a=0;a<V;a++) {
				for(int i=V;i>=0;i--) {
					int min = V;
					int none =0;
					for(int j=0;j<V+1;j++) {
						if(map[i][j]==1) {
							min = Math.min(min, index(arr,j)); 
						}	
					}
//					System.out.println(min);
					if(index(arr,i)>min)
						shift(arr,min,index(arr,i));
//					System.out.println(Arrays.toString(arr));
				}
			}
			
			
			sb.append((t+1)+" ");
			
			for(int i=1;i<V+1;i++) {
				sb.append(arr[i]+" ");
			}
			
			sb.append("\n");
			
			bw.write(sb.toString());
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
//	public static void main(String[] args) {
//		int[] array = {1,3,5,6,9,10};
//		
//		int ans = index(array,0,5,9);
//		System.out.println(ans);
//	}
	
	
	
	
	static int index(int[] arr, int key) {
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) 
				index=i;
		}
		return index;
	}
	
	
	
	static void shift(int[] arr, int a, int b) {
		int temp = arr[b];
		while(b>a) {
			arr[b]=arr[b-1];
			b--;
		}
		arr[a]=temp;
	}

}