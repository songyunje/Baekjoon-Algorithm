import java.io.*;
import java.util.*;
public class Main {
	static int N,M;
	static int[] group;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		group = new int[N+1];
		for(int i=1;i<N+1;i++) group[i]=i;

		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				if(Integer.parseInt(st.nextToken())==1) connect(i,j);
			}
		} // map
		
		st = new StringTokenizer(br.readLine());
		int temp = group[Integer.parseInt(st.nextToken())];
		String ans = "YES";
		for(int i=1;i<M;i++) {
			if(temp != group[Integer.parseInt(st.nextToken())]) ans = "NO";
		}
		bw.write(ans);
		br.close();
		bw.close();
		
	} // main
	
	static int find(int a) {
		if(a==group[a]) return a;
		else return group[a]=group[group[a]];
	} // find
	
	static void connect(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x>=y) group[x]=find(b);
		else group[y]=find(a);
	} // connect
}