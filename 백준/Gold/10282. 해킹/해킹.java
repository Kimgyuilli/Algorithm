import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to, time;

        Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
            int d = Integer.parseInt(st.nextToken()); // 의존성 수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            List<Node>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new Node(a, s));
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.add(new Node(c, 0));
            dist[c] = 0;

            while (!pq.isEmpty()) {
                Node now = pq.poll();

                if (now.time > dist[now.to]) continue;

                for (Node next : graph[now.to]) {
                    if (dist[next.to] > dist[now.to] + next.time) {
                        dist[next.to] = dist[now.to] + next.time;
                        pq.add(new Node(next.to, dist[next.to]));
                    }
                }
            }

            int count = 0;
            int maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    count++;
                    maxTime = Math.max(maxTime, dist[i]);
                }
            }

            System.out.println(count + " " + maxTime);
        }
    }
}
