import java.io.*;
import java.util.*;

public class Main {
    static int R, C, N;
    static char[][] map;
    static boolean[][] visited;
    static int[] heights;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        N = Integer.parseInt(br.readLine());
        heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            throwStick(i % 2, R - heights[i]); // 왼/오 방향, 행 변환
            markGroundConnected();
            List<int[]> floating = getFloatingCluster();
            if (!floating.isEmpty()) {
                int fallDist = getFallDistance(floating);
                dropCluster(floating, fallDist);
            }
        }

        printMap();
    }

    static void throwStick(int dir, int row) {
        if (dir == 0) { // 왼쪽 -> 오른쪽
            for (int col = 0; col < C; col++) {
                if (map[row][col] == 'x') {
                    map[row][col] = '.';
                    break;
                }
            }
        } else { // 오른쪽 -> 왼쪽
            for (int col = C - 1; col >= 0; col--) {
                if (map[row][col] == 'x') {
                    map[row][col] = '.';
                    break;
                }
            }
        }
    }

    static void markGroundConnected() {
        visited = new boolean[R][C];
        for (int col = 0; col < C; col++) {
            if (map[R - 1][col] == 'x' && !visited[R - 1][col]) {
                bfs(R - 1, col);
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (visited[nx][ny] || map[nx][ny] != 'x') continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    static List<int[]> getFloatingCluster() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && !visited[i][j]) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }

    static int getFallDistance(List<int[]> cluster) {
        int minDist = R;
        boolean[][] clusterMap = new boolean[R][C];
        for (int[] pos : cluster) {
            clusterMap[pos[0]][pos[1]] = true;
        }

        for (int[] pos : cluster) {
            int x = pos[0];
            int y = pos[1];
            int dist = 0;

            while (true) {
                int nx = x + dist + 1;
                if (nx >= R || (map[nx][y] == 'x' && !clusterMap[nx][y])) break;
                dist++;
            }
            minDist = Math.min(minDist, dist);
        }
        return minDist;
    }

    static void dropCluster(List<int[]> cluster, int dist) {
        // 기존 위치 삭제
        for (int[] pos : cluster) {
            map[pos[0]][pos[1]] = '.';
        }

        // 아래로 이동
        for (int[] pos : cluster) {
            int nx = pos[0] + dist;
            int ny = pos[1];
            map[nx][ny] = 'x';
        }
    }

    static void printMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
