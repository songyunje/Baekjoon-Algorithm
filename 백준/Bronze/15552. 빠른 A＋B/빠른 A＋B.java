import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			arr[t]= A+B;
		}
		
		for(int i=0;i<arr.length;i++) {
			bw.write(String.valueOf(arr[i])+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}

}