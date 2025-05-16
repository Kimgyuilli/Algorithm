import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static int[] subtreeSize;
    static boolean[] visited;
    static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(R);

        for(int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(subtreeSize[query]);
        }


    }
    public static int dfs(int node) {
        visited[node] = true;
        int size = 1;
        for (int child : tree.get(node)) {
            if (!visited[child]) {
                size += dfs(child); // 자식 서브트리 크기 더하기
            }
        }
        subtreeSize[node] = size;
        return size;
    }
}
