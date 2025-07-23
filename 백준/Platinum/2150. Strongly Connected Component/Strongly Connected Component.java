import java.io.*;
import java.util.*;

public class Main {

    static int V, E, index = 0;
    static List<Integer>[] graph;
    static int[] ids, low;
    static boolean[] onStack;
    static Deque<Integer> stack = new ArrayDeque<>();
    static List<List<Integer>> sccList = new ArrayList<>();
    static int id = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }

        ids = new int[V + 1];
        low = new int[V + 1];
        onStack = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (ids[i] == 0) {
                dfs(i);
            }
        }

        // 각 SCC 정점 오름차순 정렬
        for (List<Integer> scc : sccList) {
            Collections.sort(scc);
        }

        // SCC 목록을 각 SCC의 최소 정점 기준으로 오름차순 정렬
        sccList.sort(Comparator.comparingInt(o -> o.get(0)));

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(sccList.size()).append("\n");
        for (List<Integer> scc : sccList) {
            for (int node : scc) {
                sb.append(node).append(" ");
            }
            sb.append("-1\n");
        }

        System.out.println(sb);
    }

    static void dfs(int at) {
        ids[at] = low[at] = id++;
        stack.push(at);
        onStack[at] = true;

        for (int to : graph[at]) {
            if (ids[to] == 0) {
                dfs(to);
                low[at] = Math.min(low[at], low[to]);
            } else if (onStack[to]) {
                low[at] = Math.min(low[at], ids[to]);
            }
        }

        // root node for an SCC
        if (ids[at] == low[at]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                scc.add(node);
                if (node == at) break;
            }
            sccList.add(scc);
        }
    }
}
