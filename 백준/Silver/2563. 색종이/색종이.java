import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] map = new int[101][101];
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=y;i<y+10;i++){
				for(int j=x;j<x+10;j++) {
					map[i][j]=1;
				}
			}
		}
		int sum = 0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				sum+=map[i][j];
			}
		}
		
		bw.write(String.valueOf(sum));
		br.close();
		bw.close();
	} // main
}