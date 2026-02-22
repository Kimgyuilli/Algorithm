import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int work : works) {
            pq.offer(work);
        }
        
        for(int i = 0; i < n; i++){
            pq.offer(pq.poll() - 1);
        }
        
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            if(cur <= 0) break;
            answer += cur * cur;
        }
        
        return answer;
    }
}