import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0;i<queue1.length;i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        double avg = (sum1+sum2)/ 2;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (sum1 < avg) {
                int tmp = q2.poll();
                sum1 += tmp;
                q1.add(tmp);
                answer += 1;
            } else if (sum1 > avg) {
                sum1 -= q1.poll();
                answer += 1;
            } else {
                return answer;
            }
        }
        return -1;
    }
}