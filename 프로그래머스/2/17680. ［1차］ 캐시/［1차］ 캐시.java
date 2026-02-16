import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int answer = 0;
        
        LinkedHashMap<String, Boolean> cache = new LinkedHashMap<>
            (cacheSize, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > cacheSize;
            }
        };
        
        for (String city : cities) {
            String cityLower = city.toLowerCase();
            
            if (cache.containsKey(cityLower)) {
                answer += 1;
            } else {
                answer += 5;
            }
            
            cache.put(cityLower, true);
        }
        
        return answer;
    }
}