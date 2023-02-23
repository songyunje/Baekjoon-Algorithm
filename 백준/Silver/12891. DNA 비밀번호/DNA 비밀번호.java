import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); 
		int P = Integer.parseInt(st.nextToken());
		
		Character[] arr = new Character[S];
		
		String str = br.readLine();

		for(int i=0;i<S;i++) {
			arr[i] = str.charAt(i);
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int an = Integer.parseInt(st.nextToken());
		int cn = Integer.parseInt(st.nextToken());
		int gn = Integer.parseInt(st.nextToken());
		int tn = Integer.parseInt(st.nextToken());


		int count = 0;
		
		int ac = 0;
		int cc = 0;
		int gc = 0;
		int tc = 0;
		
		int start = 0;
		int end = P-1;
		
		for(int i=start;i<=end;i++) {
			if(arr[i]=='A')
				ac++;
			else if(arr[i]=='C')
				cc++;
			else if(arr[i]=='G')
				gc++;
			else
				tc++;
		}
		if(ac>=an && cc>=cn && gc>=gn && tc>=tn) {
			count++;
		}
		
		while(true) {
			start++;
			end++;
			if(end>S-1)
				break;
			switch(arr[start-1]) {
			case 'A': ac--;
				break;
			case 'C': cc--;
				break;
			case 'G': gc--;
				break;
			case 'T': tc--;
				break;
			}
			
			switch(arr[end]) {
			case 'A': ac++;
				break;
			case 'C': cc++;
				break;
			case 'G': gc++;
				break;
			case 'T': tc++;
				break;
			}
			
			if(ac>=an && cc>=cn && gc>=gn && tc>=tn) {
				count++;
			}
			
		
		}
		
		bw.write(String.valueOf(count));


		
		br.close();
		bw.flush();
		bw.close();
	}
}