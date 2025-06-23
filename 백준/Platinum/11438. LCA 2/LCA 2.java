import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, LOG = 17;  // N = 노드 개수, M = 쿼리 개수, LOG = 최대 깊이를 2^k로 표현할 때 필요한 k 값
    static ArrayList<Integer>[] graph;  // 트리 인접 리스트
    static int[][] parent;   // parent[k][v] = v의 2^k 번째 조상
    static int[] depth;      // depth[v] = 루트에서 v까지의 깊이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 트리 간선 입력 (양방향)
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // log2(N) 구하기 -> parent[][] 배열 높이 결정
        LOG = (int) Math.ceil(Math.log(N) / Math.log(2));
        parent = new int[LOG + 1][N + 1];
        depth = new int[N + 1];

        // DFS로 depth[], parent[0][] 채우기 (루트는 1번 노드)
        dfs(1, 0);

        // parent[k][v] = parent[k-1][ parent[k-1][v] ] 방식으로 DP 구성
        for (int k = 1; k <= LOG; k++) {
            for (int v = 1; v <= N; v++) {
                parent[k][v] = parent[k - 1][parent[k - 1][v]];
            }
        }

        // 쿼리 입력
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a, b));  // LCA 결과 출력
        }
    }

    // DFS : 깊이, 2^0번째 부모(parent[0]) 설정
    static void dfs(int v, int p) {
        depth[v] = depth[p] + 1;  // 부모 노드보다 깊이 1 증가
        parent[0][v] = p;         // parent[0][v] = 바로 위 부모

        for (int next : graph[v]) {
            if (next != p) {      // 방문하지 않은 자식 노드만 탐색
                dfs(next, v);
            }
        }
    }

    // LCA(a, b) 찾기
    static int lca(int a, int b) {
        // 1. depth가 다르면 깊이를 맞춰줌 (항상 a가 더 깊은 노드가 되도록)
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // a를 b와 같은 깊이로 끌어올리기
        for (int k = LOG; k >= 0; k--) {
            if (depth[a] - (1 << k) >= depth[b]) {
                a = parent[k][a];
            }
        }

        // 만약 깊이 맞춘 후 둘이 같으면 LCA
        if (a == b) return a;

        // 2. a와 b가 다르다면, 둘을 동시에 위로 올리며 공통 조상 찾기
        for (int k = LOG; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        // 최종적으로 공통 조상의 바로 아래까지 올라왔으므로, 그 부모가 LCA
        return parent[0][a];
    }

}
