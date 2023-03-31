import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<wire> list  = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new wire(x,y));
		}
		
		Collections.sort(list, new Comparator<wire>() {
			public int compare(wire o1, wire o2) {
				return o1.a-o2.a;
			}
		});
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		int min=N;
		for(int i=1;i<N;i++) {
			wire temp = list.get(i);
			for(int j=0;j<i;j++) {
				if(list.get(j).b<temp.b) dp[i]=Math.max(dp[i], dp[j]+1);
			}
			min = Math.min(min, N-dp[i]);
		}
		bw.write(String.valueOf(min));
		
		br.close();
		bw.close();
	} // main
	
	static class wire{
		int a;
		int b;
		public wire(int a, int b) {
			this.a=a;
			this.b=b;
		}
	} // class wire
}