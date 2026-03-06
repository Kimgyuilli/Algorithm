import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> li = new ArrayList<>();
        long total = 1;
        
        for (int i = 1; i <= n; i++) {
            total *= i;
            li.add(i);
        }
        
        k--; 
        
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            total /= (n - i); 
            
            int index = (int) (k / total);
            
            answer[i] = li.get(index);
            li.remove(index);
            
            k %= total;
        }
        
        return answer;
    }
}