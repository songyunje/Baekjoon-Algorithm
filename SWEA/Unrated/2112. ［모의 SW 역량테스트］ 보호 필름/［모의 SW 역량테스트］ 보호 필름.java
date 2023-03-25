import java.io.*;
import java.util.*;
public class Solution {
    static int[][] map;
    static int[][] cmap;
    static int D,W,K;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            sb.append("#"+t+" ");
            st = new StringTokenizer(br.readLine().trim()," ");
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
             
            map = new int[D+1][W+1];
            cmap = new int[D+1][W+1];
             
            for(int i=1;i<=D;i++) {
                st = new StringTokenizer(br.readLine().trim()," ");
                for(int j=1;j<=W;j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                    cmap[i][j]=map[i][j];
                }
            }
             
            ans=Integer.MAX_VALUE;
             
            if(pass() || K==1)
                sb.append(0+"\n");
            else {
                input(1,0);

                sb.append(ans+"\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
     
    static void input(int a, int b) {
    	if(pass()) {
    		ans=Math.min(ans, b);
    		return;
    	}
    	if(ans<=b || a>D) return;
    	
        for(int i=0;i<=2;i++) {
        	in(a,i);
        	input(a+1,i!=2?b+1:b);
        	back(a);
        }
    } // 주입 재귀
     
    static Boolean pass() {
        for(int i=1;i<=W;i++) {
            int max=0;
            int cnt=1;
            for(int j=2;j<=D;j++) {
                if(cmap[j-1][i]==cmap[j][i]) {
                	cnt++;
                }
                else {
                    max=Math.max(max, cnt);
                    cnt=1;
                }
            }
            max=Math.max(max, cnt);
            if(max<K)
                return false;
        }
        return true;
    } // 성능검사
     
    static void in(int a, int b) {
    	if(b==2) return;
        for(int i=1;i<=W;i++) {
            cmap[a][i]=b;
        }
    } // 약물 주입
      
    static void back(int a) {
        for(int i=1;i<=W;i++) {
            cmap[a][i]=map[a][i];
        }
    } // 백트랙킹
}