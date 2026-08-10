class Solution {
    private int[][] dungeons;
    private int answer;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.answer = 0;
        
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, 0, visited);
        
        return answer;
    }
    
    private void dfs(int k, int depth, boolean[] visited) {
        
        answer = Math.max(depth, answer);
        
        if(depth == dungeons.length) return;
        
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], depth + 1, visited);
                visited[i] = false;
            }
        }
        
    }
    
}