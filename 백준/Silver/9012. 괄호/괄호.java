import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String str = br.readLine();
			Stack<Character> stk = new Stack<>();
			
			String ans = "YES";
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='(') {
					stk.push(str.charAt(i));
				}
				if(str.charAt(i)==')') {
					if(stk.isEmpty()) {
						ans = "NO";
						break;
					}
					else {
						stk.pop();
					}
				}
			}
			if(stk.isEmpty()&&(ans=="YES")) {
				bw.write(ans+"\n");
			}
			else {
				bw.write("NO"+"\n");
			}
			
			
		}
		
		br.close();
		bw.flush();
		bw.close();
		
		
		
		
		
		
		
	} 
}