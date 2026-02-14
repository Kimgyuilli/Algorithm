import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        Map<String, Integer> wantMap = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        Map<String, Integer> window = new HashMap<>();
        
        for(int i = 0; i < 10; i++){
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }
        if(isMatch(wantMap, window)) answer++;
        
        for(int i = 10; i < discount.length; i++){
            String remove = discount[i-10];
            window.put(remove, window.get(remove) - 1);
            if(window.get(remove) < 1) window.remove(remove);
            
            String add = discount[i];
            window.put(add, window.getOrDefault(add, 0) + 1);
            if(isMatch(wantMap, window)) answer++;
            
        }
        
        
        return answer;
    }
    
    private boolean isMatch(Map<String, Integer> want, Map<String, Integer> discount) {
        for(String key : want.keySet()) {
            if(discount.getOrDefault(key, 0) < want.get(key)) {
                return false;
            }
        }
        return true;
    }
}