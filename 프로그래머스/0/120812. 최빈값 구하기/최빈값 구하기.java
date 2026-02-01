import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num : array){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int maxCount = 0;
        int mode = 0;
        
        for(int count : countMap.values()){
            maxCount = Math.max(maxCount, count);
        }
        
        int modeCount = 0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if(entry.getValue() == maxCount){
                mode = entry.getKey();
                modeCount++;
            }
        }
        
        return modeCount > 1 ? -1 : mode;
    }
}