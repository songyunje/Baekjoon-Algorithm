import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		
		int T = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>(); 
		
		for(int t=0;t<T;t++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);
		
		for(int i : list) {
			bw.write(String.valueOf(i)+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}

}