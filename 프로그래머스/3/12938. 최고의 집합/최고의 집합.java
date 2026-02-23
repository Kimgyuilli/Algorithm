import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        
        if(s < n) return new int[] {-1};
        if(n == 1) return new int[] {s};
        
        int[] answer = new int[n];
        
        int div = s / n;
        int rest = s % n;
        
        Arrays.fill(answer, div);
        
        for(int i = n - 1; i > 0; i--) {
            if(rest == 0) break;
            answer[i]++;
            rest--;
            
        }
        
        return answer;
    }
}