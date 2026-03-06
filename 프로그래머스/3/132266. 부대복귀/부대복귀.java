import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 1. 인접 리스트 그래프 구축
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) { // n++ 오타 수정
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        bfs(graph, destination, dist);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
    private void bfs(List<Integer>[] graph, int start, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int neighbor : graph[cur]) {
                // 아직 방문하지 않은 노드라면 (dist가 -1인 경우)
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[cur] + 1; // 이전 노드 거리 + 1
                    q.offer(neighbor);
                }
            }
        }
    }
}