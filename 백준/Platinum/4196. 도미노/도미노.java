import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static List<List<Integer>> reverseGraph;
    static boolean[] visited;
    static Stack<Integer> finishOrder;
    static int[] sccId;
    static int sccCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            graph = new ArrayList<>();
            reverseGraph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
                reverseGraph.add(new ArrayList<>());
            }

            // 간선 입력
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
                reverseGraph.get(y).add(x);
            }

            // SCC 찾기 (Kosaraju 알고리즘)
            visited = new boolean[N + 1];
            finishOrder = new Stack<>();

            // 1단계: 원본 그래프에서 DFS로 완료 순서 기록
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs1(i);
                }
            }

            // 2단계: 역방향 그래프에서 완료 순서 역순으로 DFS
            visited = new boolean[N + 1];
            sccId = new int[N + 1];
            sccCount = 0;

            while (!finishOrder.isEmpty()) {
                int v = finishOrder.pop();
                if (!visited[v]) {
                    dfs2(v, sccCount++);
                }
            }

            // 3단계: SCC간 indegree 계산
            int[] indegree = new int[sccCount];
            Set<String> edges = new HashSet<>();

            for (int u = 1; u <= N; u++) {
                for (int v : graph.get(u)) {
                    int sccU = sccId[u];
                    int sccV = sccId[v];

                    // 서로 다른 SCC 사이의 간선이고, 중복이 아닌 경우
                    if (sccU != sccV) {
                        String edge = sccU + "->" + sccV;
                        if (!edges.contains(edge)) {
                            edges.add(edge);
                            indegree[sccV]++;
                        }
                    }
                }
            }

            // 4단계: indegree가 0인 SCC 개수 세기
            int answer = 0;
            for (int i = 0; i < sccCount; i++) {
                if (indegree[i] == 0) {
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }

    // 원본 그래프에서 DFS (완료 순서 기록)
    static void dfs1(int v) {
        visited[v] = true;
        for (int next : graph.get(v)) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        finishOrder.push(v);
    }

    // 역방향 그래프에서 DFS (SCC 찾기)
    static void dfs2(int v, int sccNum) {
        visited[v] = true;
        sccId[v] = sccNum;
        for (int next : reverseGraph.get(v)) {
            if (!visited[next]) {
                dfs2(next, sccNum);
            }
        }
    }
}