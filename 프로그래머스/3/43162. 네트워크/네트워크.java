class Solution {
    private int[] parent;
    public int solution(int n, int[][] computers) {
        this.parent = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(computers[i][j] == 1) union(i, j);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(find(i) == i) answer++;
        }
        
        return answer;
    }
    
    private void union(int node1, int node2) {
        int rootA = find(node1);
        int rootB = find(node2);
        
        if(rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
    
    
    private int find(int node) {
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }
}