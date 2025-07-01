import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] weight;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;       // DFS용
    static boolean[] traceVisited;  // 역추적용
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        weight = new int[N + 1];
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        traceVisited = new boolean[N + 1];

        // 가중치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        // 트리 생성
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1); // 루트 노드: 1
        trace(1, dp[1][1] > dp[1][0]);

        int maxWeight = Math.max(dp[1][0], dp[1][1]);
        Collections.sort(result);

        System.out.println(maxWeight);
        for (int node : result) {
            System.out.print(node + " ");
        }
    }

    // DFS + 트리 DP
    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0; // 선택하지 않았을 때
        dp[node][1] = weight[node]; // 선택했을 때

        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
                dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                dp[node][1] += dp[child][0];
            }
        }
    }

    // 역추적: 어떤 노드를 선택했는지 추출
    static void trace(int node, boolean isSelected) {
        traceVisited[node] = true;
        if (isSelected) {
            result.add(node);
        }

        for (int child : tree[node]) {
            if (!traceVisited[child]) {
                if (isSelected) {
                    trace(child, false);
                } else {
                    trace(child, dp[child][1] > dp[child][0]);
                }
            }
        }
    }
}
