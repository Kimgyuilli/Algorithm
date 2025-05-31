import java.io.*;
import java.util.*;

public class Main {
    static int T, h, w;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            // 맵 읽기
            char[][] originalMap = new char[h][w];
            for (int i = 0; i < h; i++) {
                originalMap[i] = br.readLine().toCharArray();
            }

            // 맵 확장
            map = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) Arrays.fill(map[i], '.');
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i + 1][j + 1] = originalMap[i][j];
                }
            }
            h += 2;
            w += 2;

            // 죄수 위치 찾기
            List<Point> prisoners = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '$') {
                        prisoners.add(new Point(i, j));
                        map[i][j] = '.';  // 평지 처리
                    }
                }
            }

            // BFS 3번 수행 (조력자 + 죄수 2명)
            int[][] dist0 = bfs(0, 0);
            int[][] dist1 = bfs(prisoners.get(0).x, prisoners.get(0).y);
            int[][] dist2 = bfs(prisoners.get(1).x, prisoners.get(1).y);

            // 최소 문 개수 계산
            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '*') continue;
                    if (dist0[i][j] == -1 || dist1[i][j] == -1 || dist2[i][j] == -1) continue;

                    int sum = dist0[i][j] + dist1[i][j] + dist2[i][j];
                    if (map[i][j] == '#') sum -= 2; // 세 명이 모두 열었으면 중복 제거
                    answer = Math.min(answer, sum);
                }
            }

            System.out.println(answer);
        }
    }

    static int[][] bfs(int sx, int sy) {
        int[][] dist = new int[h][w];
        for (int[] row : dist) Arrays.fill(row, -1);

        Deque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(sx, sy));
        dist[sx][sy] = 0;

        while (!dq.isEmpty()) {
            Point cur = dq.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (map[nx][ny] == '*' || dist[nx][ny] != -1) continue;

                if (map[nx][ny] == '#') {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    dq.offerLast(new Point(nx, ny)); // 문은 뒤에
                } else {
                    dist[nx][ny] = dist[cur.x][cur.y];
                    dq.offerFirst(new Point(nx, ny)); // 평지는 앞에
                }
            }
        }

        return dist;
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
