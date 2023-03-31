import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		List<String> list = new ArrayList<>();
		for(int i=0;i<M;i++) {
			String temp = br.readLine();
			if(set.contains(temp)) list.add(temp);
		}
		
		Collections.sort(list);
		
		sb.append(list.size()+"\n");
		for(String str : list) {
			sb.append(str+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}