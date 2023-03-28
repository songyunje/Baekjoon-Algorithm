import java.io.*;
import java.util.*;
public class Main {
	static int[] group;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		group = new int[N+1];
		for(int i=0;i<N+1;i++) {
			group[i]=i;
		} // group 설정
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		if(K != 0) {
			for(int k=0;k<K;k++) {
				group[Integer.parseInt(st.nextToken())]=0;
			}
		} // 진실을 아는 자 체크
		
		List<Integer>[] map = new ArrayList[M];
		for(int i=0;i<M;i++) {
			map[i]=new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			map[i].add(first);
			for(int t=1;t<T;t++) {
				int temp = Integer.parseInt(st.nextToken());
				if(!map[i].isEmpty()) combine(temp, first);
				map[i].add(temp);
			}
		} // map에 저장 겸 combine진행
		
		int count=0;
		for(int i=0;i<M;i++) {
			Boolean check=true;
			for(int j=0;j<map[i].size();j++) {
				if(find(map[i].get(j))==0) check=false;
			}
			if(check) count++;
		} // 가능한 파티수 계산
		

		
		bw.write(String.valueOf(count));
		br.close();
		bw.close();
		
	} // main
	static int find(int a) {
		if(a==group[a]) return a;
		else return group[a]=find(group[a]);
	} // find
	
	static void combine(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x>=y) group[x]=find(b);
		else group[y]=find(a);
	} // combine
}