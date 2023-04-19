import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashMap<String,Integer> map = new HashMap<>();
        int k = 0;
        String pre = "a"+words[0].charAt(0);
       loop: for(int i=1;i<=100/n;i++){
            for(int j=1;j<=n;j++){
                if(k==words.length) break loop;
                if( map.containsKey(words[k]) | pre.charAt(pre.length()-1) !=words[k].charAt(0) ) {
                answer[0]=j;
              answer[1]=i;
                    
               break loop;
            }
    else {
        pre=words[k];
        map.put(words[k],0);
    }
        k++;
                }
        }

        return answer;
    }
}