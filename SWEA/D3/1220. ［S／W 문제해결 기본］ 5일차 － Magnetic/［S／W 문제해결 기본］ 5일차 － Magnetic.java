import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		for(int t=0;t<10;t++) {
			String trash = br.readLine();
			int[][] table = new int[100][100];
			
			for(int i=0;i<100;i++) {
				String str = br.readLine();
				for(int j=0;j<100;j++) {
					table[i][j] = str.charAt(2*j)-'0';
				}
			}
			int count=0;
			for(int c=0;c<100;c++) {
				int status = 0;
				for(int r=0;r<100;r++) {
					if(table[r][c]==1) {
						status++;
					}
					if(table[r][c]==2) {
						if(status>0) {
							count++;
						}
						status=0;
						
					}
				}
						
			}

			bw.write("#"+(t+1)+" "+count+"\n");

		}


		br.close();
		bw.flush();
		bw.close();
		
	}
}