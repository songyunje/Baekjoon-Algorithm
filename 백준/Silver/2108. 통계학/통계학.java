import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		
		for(int n=0;n<N;n++) {
			num[n]= Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		double sum = 0;
		int[] arr = new int[8001];
		
		for(int i=0;i<num.length;i++) {
			int a=0;
			sum+=num[i];
			arr[num[i]+4000]++;
		}
		int max=0;
		int maxv=0;
		
		for(int i=0;i<8001;i++) {
			if(max<arr[i]) {
				max = arr[i];
				maxv=i;
			}
		}
		int count =0;
		for(int i=0;i<8001;i++) {
			if(max==arr[i]) {
				count++;
				if(count==2) {
					maxv=i;
					break;
				}
			}
		}
		
		long average = Math.round(sum/N);
		
		int middle = num[N/2];
		
		int mode = maxv-4000;
		int range = num[N-1]-num[0];
		
		bw.write(average+"\n"+middle+"\n"+mode+"\n"+range);
		
		
		br.close();
		bw.flush();
		bw.close();

	}

}