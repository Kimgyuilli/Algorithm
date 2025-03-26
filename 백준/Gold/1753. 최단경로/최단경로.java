import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, K;
    static ArrayList<Node>[] nodes;
    static int[] dijkstraList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[V + 1];
        dijkstraList = new int[V+1];

        K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= V; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes[u].add(new Node(v, w));
        }

       dijkstra(K);
    }

    private static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        Arrays.fill(dijkstraList, Integer.MAX_VALUE);
        dijkstraList[k] = 0;

        pq.add(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 이미 더 짧은 경로로 처리한 경우 스킵
            if (dijkstraList[current.n] < current.cost) continue;

            for (Node next : nodes[current.n]) {
                int newDist = current.cost + next.cost;
                if (dijkstraList[next.n] > newDist) {
                    dijkstraList[next.n] = newDist;
                    pq.add(new Node(next.n, newDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dijkstraList[i] == Integer.MAX_VALUE ? "INF" : dijkstraList[i]).append("\n");
        }
        System.out.print(sb);
    }

    static class Node {
        int n;
        int cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}