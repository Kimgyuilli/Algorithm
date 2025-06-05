import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int testCaseCount;
    static int nodeCount, edgeCount, candidateCount;
    static int start, mustPass1, mustPass2;
    static int[] destinations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCaseCount = Integer.parseInt(br.readLine());

        while (testCaseCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodeCount = Integer.parseInt(st.nextToken());
            edgeCount = Integer.parseInt(st.nextToken());
            candidateCount = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            mustPass1 = Integer.parseInt(st.nextToken());
            mustPass2 = Integer.parseInt(st.nextToken());

            List<Edge>[] graph = new ArrayList[nodeCount + 1];
            for (int i = 1; i <= nodeCount; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < edgeCount; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph[from].add(new Edge(to, weight));
                graph[to].add(new Edge(from, weight));  // 양방향 처리
            }

            destinations = new int[candidateCount];
            for (int i = 0; i < candidateCount; i++) {
                destinations[i] = Integer.parseInt(br.readLine());
            }

            int[] distFromStart = dijkstra(start, graph);

            int[] distFromG = dijkstra(mustPass1, graph);

            int[] distFromH = dijkstra(mustPass2, graph);

            List<Integer> result = new ArrayList<>();
            Arrays.sort(destinations);  // 오름차순 출력 조건

            for (int dest : destinations) {
                int path1 = distFromStart[mustPass1] + getEdgeWeight(graph, mustPass1, mustPass2) + distFromH[dest];
                int path2 = distFromStart[mustPass2] + getEdgeWeight(graph, mustPass2, mustPass1) + distFromG[dest];
                int shortest = distFromStart[dest];

                if (shortest == path1 || shortest == path2) {
                    result.add(dest);
                }
            }

            for (int d : result) {
                System.out.print(d + " ");
            }
            System.out.println();


        }
    }
    static int[] dijkstra(int startNode, List<Edge>[] graph) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startNode, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curNode = cur.to;
            int curDist = cur.weight;

            if (curDist > dist[curNode]) continue;

            for (Edge next : graph[curNode]) {
                int newDist = curDist + next.weight;
                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.add(new Edge(next.to, newDist));
                }
            }
        }

        return dist;
    }

    static int getEdgeWeight(List<Edge>[] graph, int from, int to) {
        for (Edge e : graph[from]) {
            if (e.to == to) return e.weight;
        }
        return Integer.MAX_VALUE; // 연결이 없을 경우
    }



}
class Edge implements Comparable<Edge> {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }

}
