import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        } 
        
        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        distance[1] = 0;
        
        int maxDistance = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int neighbor : graph[cur]) {
                if(distance[neighbor] == -1) {
                    distance[neighbor] = distance[cur] + 1;
                    maxDistance = Math.max(maxDistance, distance[neighbor]);
                    q.offer(neighbor);
                }
            }
        }
        
        int answer = 0;
        
        for(int i : distance) {
            if(i == maxDistance) answer++;
        }
        
        return answer;
    }
}