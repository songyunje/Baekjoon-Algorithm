import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	static int[][] input;
	static int W,H,N;
	static int[] distribute;
	static int min;
	
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringBuilder sb = new StringBuilder("#");
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			input = new int[H][W];
			map = new int[H][W];
			
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<W;j++) {
					input[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					map[i][j]=input[i][j];
				}
			}
			
	
			
			min = Integer.MAX_VALUE;
			
			distribute = new int[N];
			
			run(0);
			
	
			sb.append((t+1)+" "+min+"\n");
			bw.write(String.valueOf(sb));
			
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	
	
	
	
	
	// 모든 경우의 수에 대해 실행
	static void run(int n) {
		if(n==N) {
			for(int c=0;c<N;c++) {
				drop(distribute[c]);
				down();
			}
			min = Math.min(min, count());
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					map[i][j]=input[i][j];
				}
			}
			return;
		}
		for(int i=0;i<W;i++) {
			distribute[n]=i;
			run(n+1);
		}
	}
	
	
	// 해당 열에 구슬 투하
	static void drop(int c) {
		for(int r=0;r<H;r++) {
			if(map[r][c] != 0) {
				pop(r,c);
				return;
			}
		}
	}
	
	
	
	// 벽돌 개수 세기
	static int count() {
		int count=0;
		for(int r=0;r<H;r++) {
			for(int c=0;c<W;c++) {
				if(map[r][c] !=0) {
					count++;
				}
			}
		}
		return count;
	}
	
	
	// 벽돌 떨어트리기
	static void down() {
		List<Integer> list = new ArrayList<>();
		int[][] newmap = new int[H][W];
		for(int c=0;c<W;c++) {
			list.clear();
			for(int r=H-1;r>=0;r--) {
				if(map[r][c] !=0) {
					list.add(map[r][c]);
				}
			}
			for(int i=0;i<list.size();i++) {
				newmap[H-1-i][c]=list.get(i);
			}
		}
		map=newmap;
	}
	

	// 벽돌 부수기
	static void pop(int x, int y) {
		int num = map[x][y];
		map[x][y]=0;
		for(int i=0;i<4;i++) {
			int nx = x;
			int ny = y;
			for(int j=1;j<num;j++) {
				nx += dx[i];
				ny += dy[i];
				if((nx>=0)&&(nx<H)&&(ny>=0)&&(ny<W)) {
					if(map[nx][ny]<=1) {
						map[nx][ny]=0;
					}else {
						pop(nx,ny);
					}	
				}
			}
		}
	}
	
	
	

}