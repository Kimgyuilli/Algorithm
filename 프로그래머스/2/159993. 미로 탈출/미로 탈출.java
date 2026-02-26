import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(String[] maps) {
        // S 위치 찾기
        int[] start = find(maps, 'S');
        // L 위치 찾기
        int[] lever = find(maps, 'L');

        // S → L
        int toLever = bfs(maps, start[0], start[1], 'L');
        if (toLever == -1) return -1;

        // L → E
        int toExit = bfs(maps, lever[0], lever[1], 'E');
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    private int[] find(String[] maps, char target) {
        for (int y = 0; y < maps.length; y++) {
            int x = maps[y].indexOf(target);
            if (x != -1) return new int[]{x, y};
        }
        return null;
    }

    private int bfs(String[] maps, int x, int y, char target) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y, 0});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (maps[cur[1]].charAt(cur[0]) == target) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0
                    || nx >= maps[0].length() || ny >= maps.length
                    || visited[ny][nx]
                    || maps[ny].charAt(nx) == 'X') {
                    continue;
                }

                visited[ny][nx] = true;
                q.offer(new int[]{nx, ny, cur[2] + 1});
            }
        }

        return -1; // 도달 불가
    }
}