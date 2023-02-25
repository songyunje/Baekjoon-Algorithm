import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[3][N];
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[0][n]=n+1;
			arr[1][n]=Integer.parseInt(st.nextToken());
			arr[2][n]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(arr[1][i]*arr[2][j]>arr[2][i]*arr[1][j]) {
					swap(i,j);
				}
				else if(arr[1][i]*arr[2][j]==arr[2][i]*arr[1][j]) {
					if(arr[0][i]>arr[0][j])
						swap(i,j);
				}
			}
		}
		
		sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(arr[0][i]+" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void swap(int a, int b) {
		int temp0;
		int temp1;
		int temp2;
		
		temp0 = arr[0][a];
		temp1 = arr[1][a];
		temp2 = arr[2][a];
		
		arr[0][a] = arr[0][b];
		arr[1][a] = arr[1][b];
		arr[2][a] = arr[2][b];
		
		arr[0][b] = temp0;
		arr[1][b] = temp1;
		arr[2][b] = temp2;
	}

}