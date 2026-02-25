import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 각 몸무게의 등장 횟수를 저장
        Map<Integer, Long> map = new HashMap<>();
        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }

        for (int w : map.keySet()) {
            long count = map.get(w);

            // 1:1 (같은 무게) → 조합: count * (count - 1) / 2
            answer += count * (count - 1) / 2;

            // 2:3 비율 → w * 2 == other * 3
            if (w * 2 % 3 == 0 && map.containsKey(w * 2 / 3)) {
                answer += count * map.get(w * 2 / 3);
            }

            // 2:4 (= 1:2) 비율
            if (map.containsKey(w * 2)) {
                answer += count * map.get(w * 2);
            }

            // 3:4 비율
            if (w * 3 % 4 == 0 && map.containsKey(w * 3 / 4)) {
                answer += count * map.get(w * 3 / 4);
            }
        }

        return answer;
    }
}