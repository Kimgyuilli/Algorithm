import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alp = new int[26];
        
        Arrays.fill(alp, 101);
        
        for(String key : keymap) {
            for(int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                int idx = c - 'A';
                alp[idx] = Math.min(j + 1, alp[idx]);
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            
            for(int j = 0; j < target.length(); j++) {
                int cost = alp[target.charAt(j) - 'A'];
                
                if(cost == 101) {
                    sum = -1;
                    break;
                }
                sum += cost;
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}