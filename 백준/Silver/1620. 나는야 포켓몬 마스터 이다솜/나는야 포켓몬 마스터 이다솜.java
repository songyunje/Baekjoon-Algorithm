import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			map.put(str, String.valueOf(i));
			map.put(String.valueOf(i),str);
		}
		
		for(int i=0;i<M;i++) {
			bw.write(map.get(br.readLine())+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}