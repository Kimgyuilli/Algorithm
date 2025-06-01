import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static char[][] map;
    static int[][][] visited;

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        int[][] c = new int[2][2];
        int idx = 0;

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    c[idx][0] = i;
                    c[idx][1] = j;
                    idx++;
                }
            }
        }

        bfs(c[0][0], c[0][1], c[1][0], c[1][1]);
    }

    static void bfs(int sx, int sy, int ex, int ey) {
        visited = new int[H][W][4];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int d = 0; d < 4; d++) {
                    visited[i][j][d] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점에서 4방향 모두 시도
        for (int d = 0; d < 4; d++) {
            visited[sx][sy][d] = 0;
            pq.offer(new Node(sx, sy, d, 0));
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.x == ex && now.y == ey) {
                System.out.println(now.mirror);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (map[nx][ny] == '*') continue;

                int nMirror = now.mirror;
                if (now.dir != d) nMirror++;

                if (visited[nx][ny][d] > nMirror) {
                    visited[nx][ny][d] = nMirror;
                    pq.offer(new Node(nx, ny, d, nMirror));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, dir, mirror;

        public Node(int x, int y, int dir, int mirror) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }

        @Override
        public int compareTo(Node o) {
            return this.mirror - o.mirror;
        }
    }
}
