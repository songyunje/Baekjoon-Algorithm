import java.io.*;
import java.util.*;
public class Main {
	static int[] lis;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		lis = new int[N+1];
		Arrays.fill(lis, -1);

		st = new StringTokenizer(br.readLine());

		cnt = 1;
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(lis[cnt-1]<temp) lis[cnt++]=temp;
			else {
				lis[place(temp)]=temp;
			}
		}
		bw.write(String.valueOf(cnt-1));
		br.close();
		bw.close();
	}
	static int place(int a) {
		return placehelp(lis,0,cnt,a);
	} // place
	static int placehelp(int[] arr, int start, int end, int key) {
		int res = 0;
		while(start<=end) {
			int mid = (start+end)/2;
			if(key<=lis[mid]) {
				res = mid;
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return res;
	} // placehelp
}