import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] arr;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(arr[N - 1][M - 1]);
    }

    public static void bfs() {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Coordinate c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = c.x + dx[i];
                int nextY = c.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if(visited[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }

                q.add(new Coordinate(nextX, nextY));
                visited[nextX][nextY] = true;
                arr[nextX][nextY] = arr[c.x][c.y] + 1;
            }
        }
    }
}

class Coordinate {
    int x, y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
