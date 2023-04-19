import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        String binary = Integer.toBinaryString(n);
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)-'0'==1) ans++;
        }

        return ans;
    }
}