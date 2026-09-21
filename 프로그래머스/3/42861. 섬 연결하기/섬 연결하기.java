import java.util.*;

class Solution {
    private int[] parent;
    public int solution(int n, int[][] costs) {
        
        this.parent = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];
        });
        
        int answer = 0;
        for(int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            
            if(find(a) == find(b)) continue;
            answer += cost[2];
            union(a, b);
        }
        return answer;
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }
    
    private int find(int num) {
        if(num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
}