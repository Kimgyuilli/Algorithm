import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if(sum1 == sum2) return 0;
        if((sum1 + sum2) % 2 != 0) return -1;
        
        while(sum1 != sum2) {
            if(sum1 > sum2){
                int cur = q1.poll();
                q2.offer(cur);
                sum1 -= cur;
                sum2 += cur;
            } else {
                int cur = q2.poll();
                q1.offer(cur);
                sum2 -= cur;
                sum1 += cur;
            }
            answer++;
            if(answer > queue1.length * 3){
                return -1;
            }
        }
        
        return answer;
    }
}