import java.util.*;

class Solution {    
    public int solution(int n, int[][] q, int[] ans) {
        List<int[]> combinations = new ArrayList<>();
        int answer = 0;
        combine(1, 0, n, new int[5], combinations);
        
        for(int[] candidate : combinations) {
            boolean canResult = true;
            
            for (int i = 0; i < q.length; i++) {
                int matchCount = countMatch(candidate, q[i]);

                if (matchCount != ans[i]) {
                    canResult = false;
                    break;
                }
            }
            
            if(canResult) answer++;
        }
        
        return answer;
    }
    
    private void combine(int start, int depth, int n, int[] current, List<int[]> combinations) {
        if(depth == 5) {
            combinations.add(current.clone());
            return;
        }
        
        for (int i = start; i <= n; i++) {
            current[depth] = i;
            combine(i + 1, depth + 1, n, current, combinations);
        }
    }
    
    private int countMatch(int[] candidate, int[] query) {
        int count = 0;
        for (int c : candidate) {
            for (int q : query) {
                if (c == q) {
                    count++;
                    break; // q에서 찾았으면 다음 c로 넘어감
                }
            }
        }
        return count;
    }
}