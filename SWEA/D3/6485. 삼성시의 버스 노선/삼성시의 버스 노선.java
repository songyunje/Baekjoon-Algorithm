import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		


		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> listA = new ArrayList<>(); 
			List<Integer> listB = new ArrayList<>(); 
			int[] station = new int[5000];
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine()," ");
				listA.add(Integer.parseInt(st.nextToken()));
				listB.add(Integer.parseInt(st.nextToken()));
			}
			
			int P = Integer.parseInt(br.readLine());
			
			int[] array = new int[P];
			
			for(int p=0;p<P;p++) {
				array[p]=Integer.parseInt(br.readLine());
			}
			
			for(int i=0;i<N;i++) {
				for(int j=listA.get(i)-1;j<listB.get(i);j++) {
					station[j]++;
				}

			}
			System.out.printf("#%d ",(t+1));
			for(int i=0;i<P;i++) {
				System.out.print(station[array[i]-1]+" ");
			}
            System.out.println();
		}

		br.close();

		
	}
}