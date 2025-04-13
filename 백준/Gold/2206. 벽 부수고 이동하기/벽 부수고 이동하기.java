import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y;
        boolean broken;
        int dist;

        Node(int x, int y, boolean broken, int dist) {
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        map = new int[N][M];
        visited = new boolean[N][M][2]; // [x][y][0]: 벽 안 부숨, [x][y][1]: 벽 부숨

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, false, 1));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue;

                if (map[newX][newY] == 0) {
                    if (!visited[newX][newY][cur.broken ? 1 : 0]) {
                        visited[newX][newY][cur.broken ? 1 : 0] = true;
                        q.add(new Node(newX, newY, cur.broken, cur.dist + 1));
                    }
                } else if (map[newX][newY] == 1) {
                    if (!cur.broken && !visited[newX][newY][1]) {
                        visited[newX][newY][1] = true;
                        q.add(new Node(newX, newY, true, cur.dist + 1));
                    }
                }
            }
        }

        return -1;
    }
}
