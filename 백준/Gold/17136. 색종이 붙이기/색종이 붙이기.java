import java.io.*;
import java.util.*;
public class Main {
	static int[][] map;
	static int min;
	static int[] have;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		map = new int[10][10];
		min = Integer.MAX_VALUE;
		have = new int[]{0,5,5,5,5,5};
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		run(0);
		if(min==Integer.MAX_VALUE) bw.write(String.valueOf(-1));
		else bw.write(String.valueOf(min));
		br.close();
		bw.close();
	}
	static void run(int a) {
		if(min<=a) return;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(map[i][j]!=0) {
					int temp = check(i,j);
//					System.out.println(temp);
					for(int k=temp;k>=1;k--) {
						if(have[k]>0) {
							cover(i,j,k);
							run(a+1);
							recover(i,j,k);					
						}
					}
					return;
				}
			}
		}
//		System.out.println(a);
		min=Math.min(min, a);
	} // run
	static int check(int x, int y) {
		int level=0;
		int k=0;
		outer : while(level<5) {
			for(int i=x;i<=x+k;i++) {
				for(int j=y;j<=y+k;j++) {
					if(i>=10 | j>=10 | (i<10 && j<10 &&map[i][j]==0)) break outer;
				}
			}
			k++;
			level++;			
		}
		return level;
	} // check
	
	static void cover(int x, int y, int a) {
		for(int i=x;i<=x+a-1;i++) {
			for(int j=y;j<=y+a-1;j++) {
				map[i][j]=0;
			}
		}
		have[a]--;
	} // cover
	
	static void recover(int x, int y, int a) {
		for(int i=x;i<=x+a-1;i++) {
			for(int j=y;j<=y+a-1;j++) {
				map[i][j]=1;
			}
		}
		have[a]++;
	} // recover
}