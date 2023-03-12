import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		for(int i=4;i<10000;i++) {
			Boolean check = true;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0)
					check=false;
			}
			if(check)
				list.add(i);
		} // 소수 추가
		
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine().trim());
			int a = 0;
			int b = 0;
			int gap =10000;
			for(int i=0;i<list.size()-1;i++) {
				for(int j=i;j<list.size();j++) {
					if(list.get(i)+list.get(j)>n)
						break;
					if(list.get(i)+list.get(j)==n && list.get(j)-list.get(i)<gap) {
						a=list.get(i);
						b=list.get(j);
						gap = b-a;
					}	
				}
			}
			
			bw.write(String.valueOf(a+" "+b+"\n"));
		} // test case
		
		br.close();
		bw.close();
	} // main
}