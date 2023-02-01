import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] result = new int[T];
		StringTokenizer st;
		
		for(int t=0;t<T;t++) {
			st= new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] fly = new int[N][N];
			for(int i=0;i<fly.length;i++) {
				st= new StringTokenizer(br.readLine()," ");
				for(int j=0;j<fly[0].length;j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for(int r=0;r+M<=fly.length;r++) {
				for(int c=0;c+M<=fly[0].length;c++) {
					int sum=0;
					for(int nr=0;nr<M;nr++) {
						for(int nc=0;nc<M;nc++) {
							sum+=fly[r+nr][c+nc];
						}
					}
					max = Math.max(max, sum);
				}
				
			}
			
			result[t]=max;	
		}
		
		for(int t=0;t<T;t++) {
			bw.write("#"+(t+1)+" "+result[t]+"\n");
		}
		
		
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}