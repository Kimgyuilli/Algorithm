import java.util.*;

class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    public int solution(int[][] maps) {
        
        int answer = bfs(maps);
        
        return answer == 1 ? -1 : answer;
    }
    
    private int bfs(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                if (map[ny][nx] == 0) continue;

                if (map[ny][nx] == 1) {
                    map[ny][nx] = map[y][x] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return map[n - 1][m - 1];
    }
}