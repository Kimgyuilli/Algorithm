import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        
        List<List<int[]>> road_map = new ArrayList<>();
        for(int i = 0; i <= N; i++) road_map.add(new ArrayList<>());
        
        for(int[] r : road) {
            road_map.get(r[0]).add(new int[] {r[1], r[2]});
            road_map.get(r[1]).add(new int[] {r[0], r[2]});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1];
            
            if(cost > dist[node]) continue;

            for(int[] next : road_map.get(node)) {
                int nextNode = next[0];
                int nextCost = cost + next[1];
                
                if(nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[] {nextNode, nextCost});
                }
                
            }
            
        }
        
        int answer = 0;
        
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
}