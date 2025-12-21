class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    private void dfs(int n, int[][] computers){
        visited[n] = true;
        for(int i = 0; i < computers.length; i++){
            if(!visited[i] && computers[n][i] == 1){
                dfs(i, computers);
            }
        }
    }
    
}