import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr, distance;
    static int N, M;
    private final static int[] DY = { -1, 0, 1, 0 }; // row
    private final static int[] DX = { 0, -1, 0, 1 }; // col
    private static boolean[][] isVisited;
    public static boolean isStartChecked = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startX = 0, startY = 0;

        arr = new int[N][M];
        distance = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!isStartChecked)
                for (int j = 0; j < M; j++)
                    if (arr[i][j] == 2) {
                        isStartChecked = true;
                        startX = i;
                        startY = j;
                        break;
                    }
        }
        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (!isVisited[i][j] && arr[i][j] == 1)
                    sb.append(-1 + " ");
                else
                    sb.append(distance[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);

    }
    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.row + DX[i];
                int nextY = current.col + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (arr[nextX][nextY] == 0) continue;
                if (isVisited[nextX][nextY]) continue;

                queue.add(new Point(nextX, nextY));
                distance[nextX][nextY] = distance[current.row][current.col] + 1;
                isVisited[nextX][nextY] = true;
            }
        }
    }


    static class Point {
        int row, col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
