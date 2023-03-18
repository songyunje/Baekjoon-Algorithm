import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine().trim());
		

		int count=0;
		for(int i=0;i<N;i++) {
			Boolean check = true;
			List<Character> list = new ArrayList<>();
			String str = br.readLine().trim();
			list.add(str.charAt(0));
			for(int j=1;j<str.length();j++) {
				Character temp = str.charAt(j);
				if(temp.equals(str.charAt(j-1)))
					continue;
				else {
					for(Character c : list) {
						if(c.equals(temp))
							check=false;
					}
					if(check)
						list.add(temp);
				}
			}
			if(check)
				count++;
		}
		
		bw.write(String.valueOf(count));
		br.close();
		bw.close();
	}
}