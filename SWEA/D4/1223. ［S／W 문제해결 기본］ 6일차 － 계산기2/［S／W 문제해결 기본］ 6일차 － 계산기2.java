import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		StringBuilder sb2;
		
		for(int t=0;t<10;t++) {
			int N = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			Stack<Integer> stack2 = new Stack<>();
			sb = new StringBuilder();
			
			sb2 = new StringBuilder("#");
		
			String str = br.readLine();
			
			
			
			for(int i=0;i<N;i++) {
				if((str.charAt(i)-'0')>=0 && (str.charAt(i)-'0')<=9) {
					sb.append(str.charAt(i));
				}else if(str.charAt(i)=='*') {
					stack.push(str.charAt(i));
				}else if(str.charAt(i)=='+') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					stack.push(str.charAt(i));
				}
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		
			for(int i=0;i<sb.length();i++) {
				if((sb.charAt(i)-'0')>=0 && (sb.charAt(i)-'0')<=9) {
					stack2.push(sb.charAt(i)-'0');
				}else if(sb.charAt(i)=='+') {
					int a = stack2.pop();
					int b = stack2.pop();
					
					stack2.push(a+b);
				}else if(sb.charAt(i)=='*') {
					int a = stack2.pop();
					int b = stack2.pop();
					
					stack2.push(a*b);
				}
			}

			sb2.append((t+1)+" "+stack2.pop()+"\n");
			bw.write(sb2.toString());
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}