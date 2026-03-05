import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        
        parent = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];
        });
        
        int answer = 0;
        
        for(int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            
            if(find(from) != find(to)) {
                union(from, to);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    public int find(int node) {
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
    
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        parent[rootB] = rootA;
    }
}