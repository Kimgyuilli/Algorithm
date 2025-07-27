import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static Stack<Integer> stack;
    static int[] sccId;
    static int sccCount;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 그래프 초기화: 0~2n-1 (0~n-1: x1~xn, n~2n-1: ¬x1~¬xn)
        graph = new ArrayList[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 절(clause) 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // (a ∨ b) → (¬a → b) AND (¬b → a)
            // 음수면 NOT, 양수면 그대로
            int notA = getNotIndex(a);
            int notB = getNotIndex(b);
            int posA = getIndex(a);
            int posB = getIndex(b);

            graph[notA].add(posB);  // ¬a → b
            graph[notB].add(posA);  // ¬b → a
        }

        // 코사라주 알고리즘으로 SCC 찾기
        findSCC();

        // 해 존재성 판별
        for (int i = 0; i < n; i++) {
            if (sccId[i] == sccId[i + n]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);

        // 실제 해 구하기
        boolean[] answer = new boolean[n];
        for (int i = 0; i < n; i++) {
            // SCC 번호가 더 큰 쪽이 false (위상정렬에서 나중)
            answer[i] = sccId[i] > sccId[i + n];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] ? 1 : 0);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();
    }

    // 변수 인덱스 변환
    static int getIndex(int x) {
        if (x > 0) return x - 1;        // x1 → 0
        else return (-x - 1) + n;       // ¬x1 → n
    }

    // NOT 인덱스 반환
    static int getNotIndex(int x) {
        if (x > 0) return (x - 1) + n;  // x1의 NOT → n
        else return (-x - 1);           // ¬x1의 NOT → 0
    }

    // 코사라주 알고리즘으로 SCC 찾기
    static void findSCC() {
        visited = new boolean[2 * n];
        stack = new Stack<>();

        // 1단계: DFS로 완료 순서 기록
        for (int i = 0; i < 2 * n; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        // 2단계: 역방향 그래프에서 SCC 찾기
        List<Integer>[] reverseGraph = new ArrayList[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < 2 * n; i++) {
            for (int next : graph[i]) {
                reverseGraph[next].add(i);
            }
        }

        visited = new boolean[2 * n];
        sccId = new int[2 * n];
        sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfs2(node, reverseGraph);
                sccCount++;
            }
        }
    }

    // 첫 번째 DFS (완료 순서)
    static void dfs1(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        stack.push(node);
    }

    // 두 번째 DFS (SCC 찾기)
    static void dfs2(int node, List<Integer>[] reverseGraph) {
        visited[node] = true;
        sccId[node] = sccCount;
        for (int next : reverseGraph[node]) {
            if (!visited[next]) {
                dfs2(next, reverseGraph);
            }
        }
    }
}