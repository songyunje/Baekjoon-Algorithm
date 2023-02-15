import java.io.*;
import java.util.*;

public class Solution {
	static int current_x,current_y,ans;
	static int start_y;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		for(int t=0;t<10;t++) {
			sb = new StringBuilder("#");
			String str = br.readLine(); 
			map = new int[100][100];
			
			for(int i=0;i<100;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<100;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<100;i++) {
				if(map[99][i]==2) {
					start_y=i;
				}
			}
			
			current_x=98;
			current_y=start_y;
			moveup();
			
			sb.append((t+1)+" "+ans+"\n");
			bw.write(String.valueOf(sb));
			
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	
	static void moveleft() {
		while(map[current_x][current_y]==1) {
			current_y--;
			if(map[current_x-1][current_y]==1) {
				moveup();
				break;
			}
		}
	}
	
	static void moveright() {
		while(map[current_x][current_y]==1) {
			current_y++;
			if(map[current_x-1][current_y]==1) {
				moveup();
				break;
			}
		}
		
	}
	
	
	static void moveup() {
		while(map[current_x][current_y]==1) {
			current_x--;
			
			if(current_x==0) {
				ans=current_y;
				break;
			}			
			if(current_y>0) {
				if(map[current_x][current_y-1]==1) {
					moveleft();
					break;
				}	
			}
			if(current_y<99) {
				if(map[current_x][current_y+1]==1) {
					moveright();
					break;
				}
			}

		}
	}
}