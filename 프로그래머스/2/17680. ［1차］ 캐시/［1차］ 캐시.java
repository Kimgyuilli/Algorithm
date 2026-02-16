import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int answer = 0;
        List<String> cache = new ArrayList<>();
        
        for (String city : cities) {
            String upperCity = city.toUpperCase();
            
            if (cache.contains(upperCity)) {
                cache.remove(upperCity);  // 기존 위치에서 제거
                cache.add(upperCity);     // 맨 뒤에 추가 (최근 사용)
                answer += 1;
            } else {
                // 캐시 미스
                if (cache.size() >= cacheSize) {
                    cache.remove(0);      // 가장 오래된 것 제거 (맨 앞)
                }
                cache.add(upperCity);     // 맨 뒤에 추가
                answer += 5;
            }
        }
        
        return answer;
    }
}