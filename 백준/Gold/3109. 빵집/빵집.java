import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static int[][] check;
	static int[] dx = {-1, 0, 1};
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		check = new int[R][C];
		count = 0;
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		for(int i=0;i<R;i++)
			dfs(i,0);
			
		bw.write(String.valueOf(count));
		br.close();
		bw.flush();
		bw.close();

		
	} // main
	
	static boolean dfs(int x, int y) {
		check[x][y]=1;
		if(y==C-1) {
			count++;
			return true;
		}
		for(int d=0;d<3;d++) {
			int nx = x+dx[d];
			int ny = y+1;
			if(nx>=0 && nx < R && map[nx][ny]=='.' && check[nx][ny]==0 && dfs(nx, ny)) 
				return true;
		}
		return false;
	}
}