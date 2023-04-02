import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			TreeMap<Integer,Integer> map = new TreeMap<>();
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				String c = st.nextToken();
				int temp = Integer.parseInt(st.nextToken());
				if(c.equals("I")) map.put(temp, map.getOrDefault(temp, 0)+1);
				else {
					if(map.isEmpty()) continue;
					int n = (temp==1)?map.lastKey():map.firstKey();
					if(map.get(n)==1) map.remove(n);
					else map.put(n, map.get(n)-1);
				}
			}
			if(map.isEmpty()) sb.append("EMPTY"+"\n");
			else sb.append(map.lastKey()+" "+map.firstKey()+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
		
	}

}