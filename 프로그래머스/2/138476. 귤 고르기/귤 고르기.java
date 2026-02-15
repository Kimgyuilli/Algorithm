import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> volume = new HashMap<>();
        for(int i : tangerine) {
            volume.put(i, volume.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(volume.values());
        Collections.sort(counts, Collections.reverseOrder());
        
        for(int count : counts) {
            k -= count;
            answer++;
            if(k <= 0) break;
        }
        
        return answer;
    }
}