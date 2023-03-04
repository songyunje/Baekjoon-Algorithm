import java.io.*;
import java.util.*;

public class Main {
	static class node{
		public int value;
		public int check;
		public node(int value, int check) {
			super();
			this.value = value;
			this.check = check;
		}
		
	}
	static node[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		map = new node[5][5];
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<5;j++) {
				map[i][j]=new node(Integer.parseInt(st.nextToken()),0);
			}
		}
		
		int ans=0;
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			
			for(int j=0;j<5;j++) {
				int num = Integer.parseInt(st.nextToken());
				
				ans++;
				for(int r=0;r<5;r++) {
					for(int c=0;c<5;c++) {
						if(map[r][c].value==num)
							map[r][c].check=1;
							
					}
				}
				
				if(bingo()) {
					bw.write(String.valueOf(ans)+"\n");
					break;
				}

			}
			if(bingo())
				break;
		}
		br.close();
		bw.flush();
		bw.close();
	}

	

	
	
	
	static Boolean bingo() {
		int count=0;

		for(int i=0;i<5;i++) {
			int tempr=0;
			int tempc=0;
			for(int j=0;j<5;j++) {
				tempr+=map[i][j].check;
				tempc+=map[j][i].check;
				if(tempr==5)
					count++;
				if(tempc==5)
					count++;
			}
		}
		int temp3=0;
		int temp4=0;
		for(int i=0;i<5;i++) {
			temp3+=map[i][i].check;
			temp4+=map[i][4-i].check;
		}
		if(temp3==5)
			count++;
		if(temp4==5)
			count++;
		
		if(count>=3)
			return true;
		else
			return false;
	}
}