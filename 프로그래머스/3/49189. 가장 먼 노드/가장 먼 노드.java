import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        distance[1] = 0;

        int max = 0;
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : graph[node]) {
                if (distance[next] != -1) continue;

                distance[next] = distance[node] + 1;
                max = Math.max(max, distance[next]);
                q.offer(next);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == max) answer++;
        }
        return answer;
    }
}