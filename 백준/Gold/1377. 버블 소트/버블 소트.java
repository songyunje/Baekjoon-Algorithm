import java.io.*;
import java.util.*;

public class Main {
	static class node{
		public int index;
		public int value;
		
		public node(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		List<node> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine().trim());
			list.add(new node(i, num));
		}
		
		Collections.sort(list, new Comparator<node>(){

			@Override
			public int compare(node o1, node o2) {
				return o1.value-o2.value;
			}
	
		});
		

		int max = 0;
		for(int i=0;i<N;i++) {
			max = Math.max(max, list.get(i).index-i);
		}
		
		bw.write(String.valueOf(max+1));
		br.close();
		bw.flush();
		bw.close();
	}

}