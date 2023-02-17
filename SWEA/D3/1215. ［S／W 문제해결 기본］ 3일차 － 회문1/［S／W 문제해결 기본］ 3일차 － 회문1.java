import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		
		for(int t=0;t<10;t++) {
			sb = new StringBuilder("#");
			int L = Integer.parseInt(br.readLine());
			String str;
			Character[][] input = new Character[8][8];
			
			for(int i=0;i<8;i++) {
				str=br.readLine();
				for(int j=0;j<8;j++) {
					input[i][j]=str.charAt(j);
				}
			}

			int num = test(input,L);
			
			sb.append((t+1)+" "+num+"\n");
			bw.write(String.valueOf(sb));
		}
		br.close();
		bw.flush();
		bw.close();
	
	
	}


	
	static int test(Character[][] arr, int n) {
		int count=0;
		if(n==1) {
		 return 64;
		}
		else if(n != 1) {
			for(int i=0;i<8;i++) {
				for(int j=0;j<9-n;j++) {
					boolean srow=true;
					int k=0;
					while(k<n/2) {
						if(arr[i][j+k] != arr[i][j+n-1-k]) {
							srow=false;
						}
						k++;
					}
					if(srow)
						count++;
				}
			}
			
			for(int j=0;j<8;j++) {
				for(int i=0;i<9-n;i++) {
					boolean scol=true;
					int k=0;
					while(k<n/2) {
						if(arr[i+k][j] != arr[i+n-1-k][j]) {
							scol=false;
						}
						k++;
					}
					if(scol)
						count++;
				}
			}
		}
		return count;
	}
}