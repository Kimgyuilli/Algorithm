import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new LinkedHashSet<>();
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            while(n % i == 0){
                set.add(i);
                n /= i;
            }
        }
        
        if(n > 1) set.add(n);
        
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}