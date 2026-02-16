class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0);
        return answer;
    }
    
    private void dfs(int[][] dungeons, boolean[] visited, int piro, int depth){
        answer = Math.max(answer, depth);
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && piro >= dungeons[i][0]){
                visited[i] = true;
                dfs(dungeons, visited, piro - dungeons[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}