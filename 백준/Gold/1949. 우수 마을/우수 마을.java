import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] population;
    static List<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        tree = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int current) {
        visited[current] = true;

        dp[current][0] = 0;
        dp[current][1] = population[current];

        for (int neighbor : tree[current]) {
            if (!visited[neighbor]) {
                dfs(neighbor);

                // DP 전이
                dp[current][0] += Math.max(dp[neighbor][0], dp[neighbor][1]);
                dp[current][1] += dp[neighbor][0];
            }
        }
    }
}
