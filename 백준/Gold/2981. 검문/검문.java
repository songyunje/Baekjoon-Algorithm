import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int cgcd = arr[1]-arr[0];
		
		for(int i=2;i<N;i++) {
			cgcd=gcd(cgcd,arr[i]-arr[i-1]);
		}
		
		sb = new StringBuilder();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=1;i<=Math.sqrt(cgcd);i++) {
			if(cgcd%i==0) {
				list.add(i);
				if(cgcd/i != i)
					list.add(cgcd/i);
			}
		}
		
		Collections.sort(list);
		
		for(int i=1;i<list.size();i++) {
			sb.append(list.get(i)+" ");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	static int gcd(int a, int b) {
		if(a%b==0)
			return b;
		while(true) {
			return gcd(b,a%b);
		}
	}
}