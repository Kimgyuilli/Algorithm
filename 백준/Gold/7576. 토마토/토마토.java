import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, M;
    static int[] dx = {0, 0, -1, 1};  // 좌우 이동
    static int[] dy = {-1, 1, 0, 0};  // 상하 이동
    static Queue<Tomato> q = new LinkedList<>();
    static int countZero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.add(new Tomato(i, j, 0));
                } else if (arr[i][j] == 0) {
                    countZero++;
                }
            }
        }
        bfs();
    }

    public static void bfs() {
        int day = 0;
        while (!q.isEmpty()) {
            Tomato t = q.poll();
            day = t.day;

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    q.add(new Tomato(nx, ny, day + 1));
                    countZero--;
                }
            }
        }


        System.out.println(countZero == 0 ? day : -1);
    }

    static class Tomato {
        int x, y, day;
        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
