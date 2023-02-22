import java.io.*;
import java.util.*;

public class Solution {
	static int T,N,M;
	static int[] distribute;
	static Character[][] map;
	static int min;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			sb = new StringBuilder("#"+(t+1)+" ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new Character[N][M];
			distribute = new int[3];
			min = N*M;
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			
			run(0);

			sb.append(min+"\n");
			bw.write(sb.toString());
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	
	static void run(int n) {
		int count=0;
		if(n==3) {
			if(distribute[0]+distribute[1]+distribute[2]==N-2 && distribute[1] != 0) {
				for(int i=0;i<M;i++) {
					if(map[0][i] != 'W')
						count++;
					if(map[N-1][i] != 'R')
						count++;
				}
				for(int i=1;i<1+distribute[0];i++) {
					for(int j=0;j<M;j++) {
						if(map[i][j] != 'W')
							count++;
					}
				}
				for(int i=1+distribute[0];i<1+distribute[0]+distribute[1];i++) {
					for(int j=0;j<M;j++) {
						if(map[i][j] != 'B')
							count++;
					}
				}
				for(int i=1+distribute[0]+distribute[1];i<N-1;i++) {
					for(int j=0;j<M;j++) {
						if(map[i][j] != 'R')
							count++;
					}
				}
				min = Math.min(min, count);
			}
			return;
		}
		
		
		
		for(int i=0;i<=N-2;i++) {
			distribute[n]=i;
			run(n+1);
		}
	}

}