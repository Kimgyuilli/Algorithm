import java.util.*;

class Solution {
    
    List<int[]> moves = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        dfs(n, 1, 2, 3);
        
        int[][] answer = new int[moves.size()][2];
        for(int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        
        
        return answer;
    }
    
    private void dfs(int n, int from, int helper, int to) {
        if(n == 1) {
            moves.add(new int[] {from, to});
            return;
        }
        
        dfs(n-1, from, to, helper);
        moves.add(new int[] {from, to});
        dfs(n-1, helper, from, to);
    }
    
}