import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        
        
        for(int i = 0; i < len; i++){
            int sum = 0;
            for(int j = i; j < i + len; j++){
                sum += elements[j % len];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}