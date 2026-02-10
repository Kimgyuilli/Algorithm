import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] reach = new int[N + 2];
        for(int stage : stages) {
            reach[stage]++;
        }
        
        List<Stage> list = new ArrayList<>();
        int total = stages.length;
        
        for(int i = 1; i <= N; i++) {
            double rate = total == 0 ? 0 : (double) reach[i] / total;
            list.add(new Stage(i, rate));
            total -= reach[i];
        }
        
        list.sort((a, b) -> Double.compare(b.rate, a.rate));
        
        return list.stream().mapToInt(s -> s.num).toArray();
    }
    
    static class Stage {
        int num;
        double rate;
        
        Stage(int num, double rate) {
            this.num = num;
            this.rate = rate;
        }
    }
}