import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        if(enemy.length == k) return k;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return b - a;});
        
        for (int i = 0; i < enemy.length; i++) {
            int currentEnemy = enemy[i];
            
            pq.offer(currentEnemy);
            n -= currentEnemy;
            
            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}