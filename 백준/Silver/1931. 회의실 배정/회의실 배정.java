import java.io.*;
import java.util.*;

public class Main {
	static class meet {
		public int start;
		public int end;
		
		public meet(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "meet [start=" + start + ", end=" + end + "]";
		}
		
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<meet> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			list.add(new meet(start, end));
		}

		Collections.sort(list,new Comparator<meet>() {

			@Override
			public int compare(meet o1, meet o2) {
				
				if(o1.end==o2.end)
					return o1.start-o2.start;
				else
					return o1.end-o2.end;
			}
			
		});
		

		
		int count=0;
		int end=0;
		for(int i=0;i<N;i++) {
			if(list.get(i).start>=end) {
				count++;
				end=list.get(i).end;
			}
		}
		
		bw.write(String.valueOf(count));
		br.close();
		bw.flush();
		bw.close();
	}
}