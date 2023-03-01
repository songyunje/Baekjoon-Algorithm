import java.io.*;
import java.util.*;

public class Main {
	static int link;
	static int[][] map;
	
	public static void main(String[] args)	throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		map = new int[N][6];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<6;j++) 
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=6;i++) {
			link=i;
			int temp=0;
			for(int j=0;j<N;j++) {
				temp+=add(j);
			}
			
			ans = Math.max(ans, temp);
		}
		bw.write(String.valueOf(ans));
		br.close();
		bw.flush();
		bw.close();
		
	}

	
	
	
	static int add(int a) {
		int index = 0;
		for(int i=0;i<6;i++) {
			if(map[a][i]==link) {
				index = i;
			}
		}
		int max = 0;
		switch(index) {
			case 0: link=map[a][5];
					for(int i=0;i<6;i++) {
						if(i !=0 && i!=5)
							max = Math.max(max, map[a][i]);
					}
					break;
			case 1: link=map[a][3];
				for(int i=0;i<6;i++) {
					if(i !=1 && i!=3)
						max = Math.max(max, map[a][i]);
					}
					break;
			case 2: link=map[a][4];
				for(int i=0;i<6;i++) {
					if(i !=2 && i!=4)
						max = Math.max(max, map[a][i]);
					}	
					break;
			case 3: link=map[a][1];
				for(int i=0;i<6;i++) {
					if(i !=1 && i!=3)
						max = Math.max(max, map[a][i]);
					}
					break;
			case 4: link=map[a][2];
				for(int i=0;i<6;i++) {
					if(i !=2 && i!=4)
						max = Math.max(max, map[a][i]);
					}
					break;
			case 5: link=map[a][0];
				for(int i=0;i<6;i++) {
					if(i !=0 && i!=5)
						max = Math.max(max, map[a][i]);
					}
					break;
		}
		return max;
	}
}