import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			Stack<Character> s1= new Stack<>();
			Stack<Character> s2= new Stack<>();
			Stack<Character> s3= new Stack<>();
			Stack<Character> s4= new Stack<>();
			Stack<Character> s5= new Stack<>();
			
			String str1 = br.readLine();
			for(int i=0;i<str1.length();i++) {
				s1.push(str1.charAt(i));				
			}
			String str2 = br.readLine();
			for(int i=0;i<str2.length();i++) {
				s2.push(str2.charAt(i));				
			}
			String str3 = br.readLine();
			for(int i=0;i<str3.length();i++) {
				s3.push(str3.charAt(i));				
			}
			String str4 = br.readLine();
			for(int i=0;i<str4.length();i++) {
				s4.push(str4.charAt(i));				
			}
			String str5 = br.readLine();
			for(int i=0;i<str5.length();i++) {
				s5.push(str5.charAt(i));				
			}
			
			int max = Math.max(s1.size(), s2.size());
			max = Math.max(max, s3.size());
			max = Math.max(max, s4.size());
			max = Math.max(max, s5.size());
			
			String[] note = new String[max];
			for(int i=note.length-1;i>=0;i--) {
				sb = new StringBuilder();
				if(s1.size()==max)
					sb.append(s1.pop());
				if(s2.size()==max)
					sb.append(s2.pop());
				if(s3.size()==max)
					sb.append(s3.pop());
				if(s4.size()==max)
					sb.append(s4.pop());
				if(s5.size()==max)
					sb.append(s5.pop());
				note[i]=sb.toString();
				max--;
			}
			
			sb= new StringBuilder();
			for(int i=0;i<note.length;i++) {
				sb.append(note[i]);
			}
			
			
			bw.write("#"+(t+1)+" "+sb.toString()+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}