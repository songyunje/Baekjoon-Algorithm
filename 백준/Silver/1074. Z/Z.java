import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int h = (int)Math.pow(2, N-1);
		int ans=-1;
		 while(true) {
			 int x = r/h;
			 int y = c/h;
			 r = r%h;
			 c = c%h;
			 if(x==0 && y==1) ans+=h*h*1;
			 else if(x==1 && y==0) ans+=h*h*2;
			 else if(x==1 && y==1) ans+=h*h*3;
			 h=h/2;
			 if(r<2 && c<2) {
				 if(r==0 && c==0) ans+=1;
				 if(r==0 && c==1) ans+=2;
				 if(r==1 && c==0) ans+=3;
				 if(r==1 && c==1) ans+=4;
				 break;
			 };
		 }
		 br.close();
		 System.out.println(ans);
	}

}