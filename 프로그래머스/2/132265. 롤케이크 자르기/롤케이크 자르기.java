import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> left_set = new HashSet<>();
        Map<Integer, Integer> right_map = new HashMap<>();
        
        for(int t : topping){
            right_map.put(t, right_map.getOrDefault(t, 0) + 1);
        }
        
        for(int t : topping){
            left_set.add(t);
            right_map.put(t, right_map.get(t) - 1);
            
            if(right_map.get(t) == 0){
                right_map.remove(t);
            }
            
            if(left_set.size() == right_map.size()) answer++;
            if(left_set.size() > right_map.size()) break;
            
        }
        
        return answer;
    }
}