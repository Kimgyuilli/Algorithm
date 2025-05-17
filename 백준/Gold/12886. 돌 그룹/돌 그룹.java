import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited = new boolean[1501][1501];
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = a + b + c;

        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }

        bfs(a, b, c, sum);
    }

    static void bfs(int a, int b, int c, int sum) {
        int[] init = {a, b, c};
        Arrays.sort(init);
        int x = init[0], y = init[1], z = init[2];

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int k = sum - i - j;

            if (i == j && j == k) {
                System.out.println(1);
                return;
            }

            int[][] pairs = {{i, j}, {i, k}, {j, k}};
            for (int[] pair : pairs) {
                int a1 = pair[0];
                int b1 = pair[1];
                if (a1 == b1) continue;

                int small = Math.min(a1, b1);
                int large = Math.max(a1, b1);

                int newA = small + small;
                int newB = large - small;
                int newC = sum - newA - newB;

                int[] next = {newA, newB, newC};
                Arrays.sort(next);
                int nx = next[0], ny = next[1];

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println(0);
    }
}
