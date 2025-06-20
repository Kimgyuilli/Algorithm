import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int to, cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {

    static int N, M;
    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];
        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) continue;
            visited[cur.to] = true;

            for (Node next : graph[cur.to]) {
                if (distance[next.to] > distance[cur.to] + next.cost) {
                    distance[next.to] = distance[cur.to] + next.cost;
                    parent[next.to] = cur.to;
                    pq.add(new Node(next.to, distance[next.to]));
                }
            }
        }

        // 최단거리 출력
        System.out.println(distance[end]);

        // 경로 복원
        Stack<Integer> path = new Stack<>();
        int node = end;
        while (node != 0) {
            path.push(node);
            node = parent[node];
        }
        System.out.println(path.size());
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }

}
