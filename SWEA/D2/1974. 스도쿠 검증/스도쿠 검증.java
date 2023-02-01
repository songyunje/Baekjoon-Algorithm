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
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[9][9];
		int[]	result = new int[N];
		

		StringTokenizer st;
		
		
		
		for(int a=0;a<N;a++) {
			result[a]=1;
			
			for(int i=0;i<arr.length;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<arr[0].length;j++) {
		
					arr[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			
			for(int[] r : arr) {
				for(int i=0;i<r.length;i++) {
					for(int j=i+1;j<r.length;j++) {
						if(r[i]==r[j]) {
							result[a]=0;
							break;
						}
					}
				}
			}
			
			for(int i=0;i<arr[0].length;i++) {
				for(int j=0;j<arr.length;j++) {
					for(int k=j+1;k<arr.length;k++) {
						if(arr[j][i]==arr[k][i]) {
							result[a]=0;
							break;
						}
					}
				}
			}
			
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					int[] arr2 = new int[9];
					int index =0;
					for(int r=i*3;r<i*3+3;r++) {
						for(int c=j*3;c<j*3+3;c++) {
							arr2[index++]=arr[r][c];
						}
			
					}
					for(int k=0;k<arr2.length;k++) {
						for(int l=k+1;l<arr2.length;l++) {
							if(arr2[k]==arr2[l]) {
								result[a]=0;
								break;
							}
						}
					}
				}
			}
		}
		
		for(int i=1;i<=result.length;i++) {
			bw.write("#"+i+" "+result[i-1]+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}