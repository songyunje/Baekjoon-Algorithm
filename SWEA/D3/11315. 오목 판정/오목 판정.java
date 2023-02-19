import java.io.*;
import java.util.*;

public class Solution {
	static int T,N;
	static String ans;
	static Character[][] map;
	static int[] dx = {0,0,0,0,0};
	static int[] dy = {0,1,2,3,4};
	static int[] dx2 = {0,1,2,3,4};
	static int[] dy2 = {0,1,2,3,4};
	static int[] dx3 = {0,1,2,3,4};
	static int[] dy3 = {0,0,0,0,0};
	static int[] dx4 = {0,-1,-2,-3,-4};
	static int[] dy4 = {0,1,2,3,4};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			sb = new StringBuilder("#");
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			
			map = new Character[N][N];
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j]=str.charAt(j);
				}
			}
				
			if(test(map)) {
				ans = "YES";
			}else {
				ans = "NO";
			}
			
			sb.append((t+1)+" "+ans+"\n");
			bw.write(String.valueOf(sb));
			
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	
	}
	
	static boolean test(Character[][] arr) {
		boolean check = false;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				int sum1=0;
				int sum2=0;
				int sum3=0;
				int sum4=0;
				if(arr[i][j]=='o') {
					for(int k=0;k<5;k++) {
						if((i+dx[k])<arr.length && (j+dy[k])<arr.length) {
							if(arr[i+dx[k]][j+dy[k]]=='o')	{
								sum1++;
								if(sum1==5) {
									break;
								}
							}else {
								sum1=0;
							}
						}
						if((i+dx2[k])<arr.length && (j+dy2[k])<arr.length) {
							if(arr[i+dx2[k]][j+dy2[k]]=='o')	{
								sum2++;
								if(sum2==5) {
									break;
								}
							}else {
								sum2=0;
							}
						}
						if((i+dx3[k])<arr.length && (j+dy3[k])<arr.length) {
							if(arr[i+dx3[k]][j+dy3[k]]=='o')	{
								sum3++;
								if(sum3==5) {
									break;
								}
							}else {
								sum3=0;
							}
						}
						if((i+dx4[k])>=0 && (i+dx4[k])<arr.length && (j+dy4[k])<arr.length) {
							if(arr[i+dx4[k]][j+dy4[k]]=='o')	{
								sum4++;
								if(sum4==5) {
									break;
								}
							}else {
								sum4=0;
							}
						}
					}
				}
				if(sum1==5 || sum2==5 || sum3==5 || sum4==5) {
					check=true;
					break;
				}
			}
			if(check) {
				break;
			}
		}
		return check;
	}
}