import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dx = { -1,0,1,0 };
    static int[] dy = { 0,1,0,-1 };
    static int[][] map, add;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
		st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        add = new int[N+2][M+2];
        for(int i=0;i<N+2;i++) {
        	for(int j=0;j<M+2;j++) {
        		map[i][j]=0;
        		add[i][j]=0;
        	}
        }
        
        for(int i=1;i<=N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1;j<=M;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        		add[i][j]=Integer.MAX_VALUE;
        	}
        }
        pour();
        
        bw.write(String.valueOf(cal()));
        br.close();
        bw.close();
    }
    public static void pour() {
        while (true) {
            Boolean flag = true;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j]==add[i][j]) continue;
                    int min = Integer.MAX_VALUE;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        min = Math.min(min, add[nx][ny]);
                    }
                    if (add[i][j] > min) {
                        add[i][j]= Math.max(map[i][j], min);
                        flag = false;
                    }
                }
            }
            if (flag) break;
        }
    } // pour
    
    static int cal() {
    	int ans=0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                ans += add[i][j]-map[i][j];
            }
        }
        return ans;
    } // calculation
}