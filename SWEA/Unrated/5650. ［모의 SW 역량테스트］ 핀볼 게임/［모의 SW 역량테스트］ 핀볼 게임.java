import java.io.*;
import java.util.*;
 
public class Solution {
    static int x,y,N,score,max;
    static int startx,starty;
    static int[][] map;
    static List<node>[] worm = new ArrayList[5];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] block = {{},{2,3,1,0},{1,3,0,2},{3,2,0,1},{2,0,3,1},{2,3,0,1}};
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;	
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine().trim());
         
        for(int t=1;t<=T;t++) {
            N = Integer.parseInt(br.readLine().trim());
              
            map = new int[N+2][N+2];
            for(int i=1;i<=N;i++) {
                st = new StringTokenizer(br.readLine().trim()," ");
                for(int j=1;j<=N;j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            } // map 입력받음
            
            for(int i=0;i<=N+1;i++) {
        		if(i==0 | i== N+1) {
        			for(int j=0;j<=N+1;j++) { 
        				map[i][j]=5;
        			}
            	}else {
            		map[i][0]=5;
            		map[i][N+1]=5;
            	}
            } // map 사방 처리
             
            for(int i=0;i<5;i++) {
            	worm[i]=new ArrayList<>();
            } // map 스캔하고 웜홀 위치 추적
            scan(map);
             
            max = 0;
  
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(map[i][j] == 0) {
                        for(int d=0;d<4;d++) {
                        	run(i,j,d);
                        }
                    }
                }
            }
 
            sb.append("#"+t+" "+max+"\n");
        }
        bw.write(sb.toString());
     
        br.close();
        bw.close();
    }
     
    static void scan(int[][] arr) {
        for(int i=1;i<=N+1;i++) {
            for(int j=1;j<=N+1;j++) {
            	int temp = arr[i][j];
            	if(temp>=6 && temp<=10) {
    				worm[temp-6].add(new node(i,j));
            	}
            }
        }
    } // 맵 스캔 후 웜홀 위치 추적
     
    static void run(int a, int b, int d) {
        score=0;
        startx=a;
        starty=b;
        x=a;
        y=b;
        move(d);
    } // run
     
    static void move(int d) {
    	int direction = d ;
    	while(true) {
    		x+=dx[direction];
    		y+=dy[direction];
			if(map[x][y] >=1 && map[x][y] <=5 && !(x==startx && y==starty)) {
				score++;
	            direction=block[map[x][y]][direction];
			}else if(map[x][y] >=6 && map[x][y] <=10 && !(x==startx && y==starty)) {
				int idx = map[x][y]-6;
				if(x==worm[idx].get(0).x && y==worm[idx].get(0).y) {
		    		x=worm[idx].get(1).x;
		    		y=worm[idx].get(1).y;
		    	}else {
		    		x=worm[idx].get(0).x;
		    		y=worm[idx].get(0).y;
		    	}
			}
			if(map[x][y] == -1 || (x==startx && y==starty)){
				max=Math.max(max, score);
			    break;
			}
    	}
    } // 이동
      
    static class node{
    	int x;
    	int y;
		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
    } // class node
}