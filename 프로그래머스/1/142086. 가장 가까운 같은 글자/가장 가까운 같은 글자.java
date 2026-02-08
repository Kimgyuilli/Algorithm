import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            
            if(lastPos[idx] != -1) {
                answer[i] = i - lastPos[idx];
            } else {
                answer[i] = -1;
            }
            
            lastPos[idx] = i;
        }
        
        return answer;
    }
}