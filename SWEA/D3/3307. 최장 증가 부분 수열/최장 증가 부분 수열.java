import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        int[] result = new int[T];
         
        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int s=0;s<N;s++) {
                arr[s]=Integer.parseInt(st.nextToken());
            }
             
            int[] lis = new int[N];
            lis[0]=1;
            int max=0;
            for(int i=1;i<N;i++) {
                int imax=0;
                for(int j=i-1;j>=0;j--) {
                    if(arr[j]<arr[i]) {
                        imax= Math.max(imax, lis[j]);
                    }
                }
                lis[i]=imax+1;
                max=Math.max(max, lis[i]);
            }
             
            result[t]=max;
        }
 
        for(int t=0;t<T;t++) {
            bw.write("#"+(t+1)+" "+result[t]+"\n");
        }
         
        br.close();
        bw.flush();
        bw.close();
    }
}