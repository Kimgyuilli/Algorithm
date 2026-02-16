import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int cur = 0;
        while(cur < progresses.length){
            int deploy = 0;
            for(int i = 0; i < progresses.length; i++){
                progresses[i] += speeds[i];
                if(progresses[i] >= 100 && i == cur){
                    deploy++;
                    cur++;
                }
            }
            if(deploy > 0) answer.add(deploy);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}