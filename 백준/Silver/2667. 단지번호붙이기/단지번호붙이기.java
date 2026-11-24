import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] visited;
    static int[][] arr;
    static int N;
    static List<Integer> complexSizes;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        complexSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    int size = dfs(i, j);
                    complexSizes.add(size);
                }
            }
        }

        Collections.sort(complexSizes);
        System.out.println(complexSizes.size());

        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = 1; // 현재 위치 포함

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
                if (!visited[newX][newY] && arr[newX][newY] == 1) {
                    size += dfs(newX, newY);
                }
            }
        }
        return size;
    }
}
