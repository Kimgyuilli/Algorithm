import java.io.*;
import java.util.*;

public class Main {
    static int W, H;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Point> dustList;
    static Map<Point, Integer> dustIndex;

    static class State {
        int x, y, steps, bit;

        public State(int x, int y, int steps, int bit) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.bit = bit;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // equals and hashCode are important for using Point as Map key
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0) break;

            map = new char[H][W];
            visited = new boolean[H][W][1 << 11]; // 최대 먼지 10개까지 지원
            dustList = new ArrayList<>();
            dustIndex = new HashMap<>();
            Point start = null;

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == 'o') start = new Point(i, j);
                    else if (map[i][j] == '*') {
                        dustList.add(new Point(i, j));
                        dustIndex.put(new Point(i, j), dustList.size() - 1);
                    }
                }
            }

            System.out.println(bfs(start));
        }
    }

    static int bfs(Point start) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(start.x, start.y, 0, 0));
        visited[start.x][start.y][0] = true;

        int targetBit = (1 << dustList.size()) - 1;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.bit == targetBit) {
                return cur.steps;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (map[nx][ny] == 'x') continue;

                int newBit = cur.bit;
                if (map[nx][ny] == '*') {
                    Point p = new Point(nx, ny);
                    Integer idx = dustIndex.get(p);
                    if (idx != null) {
                        newBit |= (1 << idx);
                    }
                }

                if (!visited[nx][ny][newBit]) {
                    visited[nx][ny][newBit] = true;
                    q.offer(new State(nx, ny, cur.steps + 1, newBit));
                }
            }
        }

        return -1; // 모든 먼지를 청소할 수 없는 경우
    }
}
