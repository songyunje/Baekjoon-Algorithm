import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> list;
	static int digit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		
		digit = 1;
		for(int i=0;i<N-1;i++) {
			digit *=10;
		}
		
		list = new ArrayList<Integer>();
		
		for(int i=2;i<10;i++) {
			dfs(i);
		}
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void dfs(int n) {
		if(!Primecheck(n))
			return;
		if(n/digit>0) {
			list.add(n);
			return;
		}
		for(int i=1;i<=9;i++) {
			dfs(n*10+i);
		}
	}
	
	static Boolean Primecheck(int a) {
		for(int i=2;i<=a/2;i++) {
			if(a%i==0)
				return false;
		}
		return true;
	}
}