class Solution {
    int count; // 노드 개수를 세기 위한 변수

    public int solution(int n, int[][] wires) {
        int answer = n; 
        boolean[][] node = new boolean[n + 1][n + 1];
        
        for(int[] wire : wires) {
            node[wire[0]][wire[1]] = node[wire[1]][wire[0]] = true;
        }
        
        for(int[] wire : wires) {
            node[wire[0]][wire[1]] = node[wire[1]][wire[0]] = false;
            
            boolean[] visited = new boolean[n + 1];
            int k = dfs(wire[0], n, visited, node);
            
            int diff = Math.abs(k - (n - k));
            answer = Math.min(answer, diff);
            
            node[wire[0]][wire[1]] = node[wire[1]][wire[0]] = true;
        }
        
        return answer;
    }
    
    private int dfs(int cur, int n, boolean[] visited, boolean[][] node) {
        visited[cur] = true;
        int cnt = 1;
        
        for(int next = 1; next <= n; next++) {
            if(node[cur][next] && !visited[next]) {
                cnt += dfs(next, n, visited, node);
            }
        }
        return cnt;
    }
}