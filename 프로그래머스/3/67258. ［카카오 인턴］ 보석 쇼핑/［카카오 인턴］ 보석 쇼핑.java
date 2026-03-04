import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemTypes.size();
        
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int ansStart = 0;
        int ansEnd = 0;    
        
        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.size() == totalTypes) {
                if (end - start < minLen) {
                    minLen = end - start;
                    ansStart = start;
                    ansEnd = end;
                }

                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
        }
        
        return new int[] {ansStart + 1, ansEnd + 1};
    }
}