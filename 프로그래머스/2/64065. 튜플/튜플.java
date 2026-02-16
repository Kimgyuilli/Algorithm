import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] temp = s.substring(2, s.length()-2)
            .replaceAll("[{}]", "")
            .split(",");
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String t : temp){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        int[] answer = new int[map.size()];
        
        for(String key : map.keySet()){
            answer[map.size() - map.get(key)] = Integer.parseInt(key);
        }
        
        return answer;
    }
}