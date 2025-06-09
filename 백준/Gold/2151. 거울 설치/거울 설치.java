import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int sx, sy, ex, ey;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '#') {
                    if (idx == 0) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                    idx++;
                }

            }
        }

        bfs();


    }

    static void bfs() {
        boolean[][][] visited = new boolean[N][N][4];
        PriorityQueue<Mirror> pq = new PriorityQueue<>();

        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != '*') {
                pq.add(new Mirror(sx, sy, i, 0));
                visited[sx][sy][i] = true;
            }
        }

        while(!pq.isEmpty()){
            Mirror cur = pq.poll();

            if (cur.x == ex && cur.y == ey) {
                System.out.println(cur.count);
                return;
            }

            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != '*') {
                if (!visited[nx][ny][cur.dir]) {
                    visited[nx][ny][cur.dir] = true;

                    // 직진
                    pq.add(new Mirror(nx, ny, cur.dir, cur.count));

                    // 거울이면 꺾기
                    if (map[nx][ny] == '!') {
                        int left = (cur.dir + 3) % 4;
                        int right = (cur.dir + 1) % 4;
                        pq.add(new Mirror(nx, ny, left, cur.count + 1));
                        pq.add(new Mirror(nx, ny, right, cur.count + 1));
                    }
                }
            }
        }
    }

    static class Mirror implements Comparable<Mirror>{
        int x, y, dir, count;

        public Mirror(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }

        @Override
        public int compareTo(Mirror o) {
            return this.count - o.count;
        }
    }
}