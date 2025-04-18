import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int numOfCity, numOfBus;
    static List<Node>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numOfCity = Integer.parseInt(br.readLine());
        numOfBus = Integer.parseInt(br.readLine());

        graph = new ArrayList[numOfCity + 1];
        distance = new int[numOfCity + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 1; i <= numOfCity; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < numOfBus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(distance[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));         // 1. 시작 노드를 우선순위 큐에 넣음
        distance[start] = 0;                  // 2. 시작 노드까지의 거리는 0으로 설정

        while (!pq.isEmpty()) {               // 3. 우선순위 큐가 빌 때까지 반복
            Node current = pq.poll();        // 4. 현재까지 거리 가장 짧은 노드 꺼냄

            if (distance[current.city] < current.cost) continue;
            // 5. 이미 더 짧은 거리로 방문한 적이 있다면 스킵

            for (Node next : graph[current.city]) {    // 6. 현재 노드와 연결된 모든 인접 노드 탐색
                int newCost = distance[current.city] + next.cost;  // 현재까지 거리 + 다음 노드까지 거리
                if (newCost < distance[next.city]) {   // 7. 새로운 경로가 더 짧으면
                    distance[next.city] = newCost;      // 8. 거리 갱신
                    pq.offer(new Node(next.city, newCost));  // 9. 다음 노드를 큐에 넣음
                }
            }
        }
    }


    static class Node implements Comparable<Node> {
        int city, cost;

        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
