import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> str1_map = new HashMap<>();
        Map<String, Integer> str2_map = new HashMap<>();

        
        // 다중집합 생성 (영문자 쌍만 허용)
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String sub = "" + c1 + c2;
                str1_map.put(sub, str1_map.getOrDefault(sub, 0) + 1);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String sub = "" + c1 + c2;
                str2_map.put(sub, str2_map.getOrDefault(sub, 0) + 1);
            }
        }
        
        int intersectionCount = 0;
        int unionCount = 0;
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(str1_map.keySet());
        allKeys.addAll(str2_map.keySet());
        
        for (String key : allKeys) {
            int count1 = str1_map.getOrDefault(key, 0);
            int count2 = str2_map.getOrDefault(key, 0);
            
            intersectionCount += Math.min(count1, count2);
            unionCount += Math.max(count1, count2);
        }

        if (unionCount == 0) return 65536;
        
        double jaccard = (double) intersectionCount / unionCount;
        return (int) (jaccard * 65536);
    }
}