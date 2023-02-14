import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count=0;
		
		for(int i=0;i<N;i++) {
			int a=0;
			int b=N-1;
			while(a!=b) {
				if(a==i) {
					a++;
				}
				else if(b==i) {
					b--;
				}
				else {
					if((arr[a]+arr[b])>arr[i]) {
						b--;
					}else if((arr[a]+arr[b])<arr[i]){
						a++;
					}else {
						count++;
						break;
					}
				}
			}
		}
		bw.write(String.valueOf(count));
		
		br.close();
		bw.flush();
		bw.close();

	}

}