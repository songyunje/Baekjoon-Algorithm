import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int sn = 1;
		Boolean check = true;
		for(int i=0;i<N;i++) {
			int pn = Integer.parseInt(br.readLine());
			if(sn<=pn) {
				while(sn <= pn) {
					stack.push(sn++);		
					sb.append("+"+"\n");
				}
				stack.pop();
				sb.append("-"+"\n");
			}
			else {
				if(stack.peek() != pn) {
					check = false;
					break;
				}
				else {
					stack.pop();
					sb.append("-"+"\n");
				}
			}
		}
		
		if(check)
			bw.write(sb.toString());
		else
			bw.write("NO");
		
		br.close();
		bw.flush();
		bw.close();
	}
}