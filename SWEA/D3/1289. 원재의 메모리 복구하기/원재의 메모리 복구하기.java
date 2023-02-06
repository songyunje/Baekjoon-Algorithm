import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];
        for(int t=0;t<T;t++) {
            String str = br.readLine();
            int[] arr = new int[str.length()];
            for(int i=0; i<str.length();i++) {
                arr[i] = str.charAt(i)-'0';
            }
 
            int count=0;
            if(arr[0]==1) {
                count+=1;
            }
 
            for(int j=0;j<arr.length-1;j++) {
                if(arr[j] !=arr[j+1]) {
                    count++;
                }
            }
            result[t]=count;
        }
         
        for(int t=0;t<T;t++) {
            bw.write("#"+(t+1)+" "+result[t]+"\n");
        }
         
        br.close();
        bw.flush();
        bw.close();
    }
}