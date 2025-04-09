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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startX = 0, startY = 0;
        boolean isStartChecked = false;

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
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    sb.append("0 ");
                } else if (!isVisited[i][j]) {
                    sb.append("-1 ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static void bfs(int startRow, int startCol) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startRow, startCol));
        isVisited[startRow][startCol] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = p.row + DY[i];
                int newCol = p.col + DX[i];

                if (newRow < 0 || newCol < 0 || newRow >= N || newCol >= M)
                    continue;
                if (isVisited[newRow][newCol] || arr[newRow][newCol] == 0)
                    continue;

                q.add(new Point(newRow, newCol));
                distance[newRow][newCol] = distance[p.row][p.col] + 1;
                isVisited[newRow][newCol] = true;
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
