import java.util.*;

class Solution {
    private int n;
    private int[] distance;
    private List<Integer>[] graph;
    private boolean[] visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        this.n = n;
        this.distance = new int[n + 1];
        this.graph = new ArrayList[n+1];
        this.visited = new boolean[n+1];
        
        for(int i = 1; i <= n; i++) {
            distance[i] = i == destination ? 0 : -1;
            graph[i] = new ArrayList<>();
        }
        
        for(int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        visited[destination] = true;
        BFS(destination);
        
        for(int i = 0; i < sources.length; i++) {
            sources[i] = distance[sources[i]];
        }
        return sources;
    }
    
    private void BFS(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int node : graph[cur]) {
                if(distance[node] != -1) continue;
                q.offer(node);
                distance[node] = distance[cur] + 1;
            }
        }
        
    }
}