import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim(),"-");
		
		Boolean check = false;
		int ans = 0;
		while(st.hasMoreTokens()) {
			int temp = 0;
			StringTokenizer str = new StringTokenizer(st.nextToken(),"+");
			while(str.hasMoreTokens()) {
				temp+=Integer.parseInt(str.nextToken());
			}
			if(!check)
				ans+=temp;
			else
				ans-=temp;
			check=true;
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

}