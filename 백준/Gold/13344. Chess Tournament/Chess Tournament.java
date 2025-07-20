import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static int[] rank;
    static List<int[]> inequalities; // [a, b] means a > b
    static List<List<Integer>> graph;
    static int[] indegree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        rank = new int[N];
        inequalities = new ArrayList<>();

        // Union-Find 초기화
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            if (op.equals("=")) {
                union(a, b);  // 같은 집합으로 합치기
            } else if (op.equals(">")) {
                inequalities.add(new int[]{a, b});  // a > b
            } else if (op.equals("<")) {
                inequalities.add(new int[]{b, a});  // b > a
            }
        }

        // 집합들을 찾기
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < N; i++) {
            roots.add(find(i));
        }

        // 그래프 구성 (집합 간의 관계)
        int rootCount = roots.size();
        Map<Integer, Integer> rootToIndex = new HashMap<>();
        int idx = 0;
        for (int root : roots) {
            rootToIndex.put(root, idx++);
        }

        graph = new ArrayList<>();
        indegree = new int[rootCount];
        visited = new boolean[rootCount];

        for (int i = 0; i < rootCount; i++) {
            graph.add(new ArrayList<>());
        }

        // 부등식 관계 처리
        for (int[] ineq : inequalities) {
            int rootA = find(ineq[0]);
            int rootB = find(ineq[1]);

            if (rootA == rootB) {
                // 같은 집합인데 부등호 관계가 있으면 모순
                System.out.println("inconsistent");
                return;
            }

            int indexA = rootToIndex.get(rootA);
            int indexB = rootToIndex.get(rootB);

            // A > B이므로 B -> A로 간선 추가
            graph.get(indexB).add(indexA);
            indegree[indexA]++;
        }

        // 위상정렬로 순환 검사
        if (hascycle(rootCount)) {
            System.out.println("inconsistent");
        } else {
            System.out.println("consistent");
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    static boolean hascycle(int nodeCount) {
        Queue<Integer> queue = new LinkedList<>();
        int[] tempIndegree = indegree.clone();

        // indegree가 0인 노드들을 큐에 추가
        for (int i = 0; i < nodeCount; i++) {
            if (tempIndegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedNodes = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedNodes++;

            for (int next : graph.get(current)) {
                tempIndegree[next]--;
                if (tempIndegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 모든 노드를 처리했으면 순환이 없음
        return processedNodes != nodeCount;
    }
}