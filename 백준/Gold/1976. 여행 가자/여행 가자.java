import java.io.*;
import java.util.*;
public class Main {
	static int N,M;
	static int[][] map;
	static int[] connection, plan;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		connection = new int[N+1];
		int c=1;
		for(int i=1;i<=N;i++) {
			if(connection[i]==0) {
				connect(i,c++);
			}
		}

		st = new StringTokenizer(br.readLine());
		int temp = connection[Integer.parseInt(st.nextToken())];
		Boolean check = true;
		for(int i=1;i<M;i++) {
			if(temp !=connection[Integer.parseInt(st.nextToken())]) check=false;
		}
		if(check) bw.write("YES");
		else bw.write("NO");
		br.close();
		bw.close();
		
	}
	static void connect(int a,int b) {
		connection[a]=b;
		for(int i=1;i<N+1;i++) {
			if(map[a][i]==1 && connection[i] ==0) connect(i,b);
		}
	}
}