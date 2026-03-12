import java.util.*;

class Solution {
    // 각 그룹의 곡괭이별 피로도를 담을 클래스
    static class MineralGroup {
        int diaFatigue, ironFatigue, stoneFatigue;

        public MineralGroup(int dia, int iron, int stone) {
            this.diaFatigue = dia;
            this.ironFatigue = iron;
            this.stoneFatigue = stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = Arrays.stream(picks).sum();
        List<MineralGroup> groups = new ArrayList<>();

        // 1. 5개씩 묶어서 그룹화 (가진 곡괭이로 캘 수 있는 범위까지만)
        for (int i = 0; i < minerals.length && groups.size() < totalPicks; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            
            for (int j = i; j < Math.min(i + 5, minerals.length); j++) {
                String m = minerals[j];
                if (m.equals("diamond")) dia++;
                else if (m.equals("iron")) iron++;
                else stone++;
            }
            
            // 곡괭이별 피로도 미리 계산
            groups.add(new MineralGroup(
                (dia * 1) + (iron * 1) + (stone * 1),   // 다이아 곡괭이 사용 시
                (dia * 5) + (iron * 1) + (stone * 1),   // 철 곡괭이 사용 시
                (dia * 25) + (iron * 5) + (stone * 1)  // 돌 곡괭이 사용 시
            ));
        }

        groups.sort((a, b) -> b.stoneFatigue - a.stoneFatigue);

        // 3. 좋은 곡괭이부터 순차적으로 투입
        for (MineralGroup g : groups) {
            if (picks[0] > 0) { // 다이아 곡괭이
                answer += g.diaFatigue;
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이
                answer += g.ironFatigue;
                picks[1]--;
            } else if (picks[2] > 0) { // 돌 곡괭이
                answer += g.stoneFatigue;
                picks[2]--;
            }
        }

        return answer;
    }
}