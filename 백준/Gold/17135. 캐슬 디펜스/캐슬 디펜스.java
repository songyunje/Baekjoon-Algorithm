import java.io.*;
import java.util.*;

public class Main {
	static int N,M,D;
	static int[][] map;
	static List<int[]> list;
	static int[] archer;
	static int answer;
	static class enemy{
		int x, y, d;
		public enemy(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		list = new ArrayList<>();
		archer = new int[3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) list.add(new int[] {i,j});
			}
		}
		
		start(0,0);
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	
	static void start(int idx,int start) {
		if(idx==3) {
			List<int[]> data = copy(list);
			attack(data);
			return;
		}
		for(int i=start;i<M;i++) {
			archer[idx]=i;
			start(idx+1,i+1);
		}
	} // 궁수 배치 조합 및 실행
	
	static List<int[]> copy(List<int[]> list){
		List<int[]> temp = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			temp.add(new int[] {list.get(i)[0],list.get(i)[1]});
		}
		return temp;
	} // map 복사

	static void attack(List<int[]> list) {
		int count=0;
		while(!list.isEmpty()) {
			List<int[]> targets = new ArrayList<>(); // 각 턴 마다 타겟 list
			
			for(int k=0;k<3;k++) { // 각 궁수마다 잡을 수 있는 적 체크 후 targets에 추가
				PriorityQueue<enemy> pq = new PriorityQueue<>(new Comparator<enemy>() {
					public int compare(enemy o1, enemy o2) {
						if(o1.d==o2.d) return o1.y-o2.y;
						else return o1.d-o2.d;
					}	
				}); // 거리, 행을 비교하여 우선순위 큐 
				
				for(int i=0;i<list.size();i++) {
					int[] cur = list.get(i);
					int d = Math.abs(cur[0]-N)+Math.abs(cur[1]-archer[k]);
					if(d<=D) pq.add(new enemy(cur[0],cur[1],d));
				} // 거리가 D 이하인 적 pq에 추가
				
				if(!pq.isEmpty()) {
					enemy target = pq.poll();
					boolean check = false;
					for(int i=0;i<targets.size();i++) {
						if(target.x==targets.get(i)[0] && target.y==targets.get(i)[1]) check=true;
					}
					if(!check) targets.add(new int[] {target.x,target.y});
				} // 잡을 수 있는 적이 있다면 targets와 비교하여 새로운 적 추가
				
			} // 여기까지 targets 추가
			
			for(int i=0;i<targets.size();i++) {
				for(int j=list.size()-1;j>=0;j--) {
					if(targets.get(i)[0]==list.get(j)[0] && targets.get(i)[1]==list.get(j)[1]) {
						list.remove(j);
						count++;
						break;
					}
				}
			} // 적 공격하여 제거
			
			for(int i=list.size()-1;i>=0;i--) {
				list.get(i)[0]+=1;
				if(list.get(i)[0]>=N) list.remove(i);
			}
		} // 턴이 끝나며 적들이 한 칸 내려옴
		
		answer = Math.max(answer, count); // 최대 적 처치 수 갱신
	} // 여기까지 공격




}