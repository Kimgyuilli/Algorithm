import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;      // 인접 행렬 (순위 그래프)
    static int[] indegree;     // 각 노드의 진입 차수
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n + 1][n + 1];
            indegree = new int[n + 1];

            int[] rank = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            // 작년 순위로 그래프 구성
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    graph[rank[i]][rank[j]] = 1;  // i가 j보다 앞
                    indegree[rank[j]]++;
                }
            }

            // 올해 변경된 순위 처리
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 방향 뒤집기
                if (graph[a][b] == 1) {
                    graph[a][b] = 0;
                    graph[b][a] = 1;
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    graph[b][a] = 0;
                    graph[a][b] = 1;
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            // 위상 정렬 수행
            List<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) q.offer(i);
            }

            boolean certain = true;
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                if (q.isEmpty()) {
                    impossible = true;  // 사이클 존재
                    break;
                }

                if (q.size() > 1) {
                    certain = false;    // 순위를 단정할 수 없음
                }

                int now = q.poll();
                result.add(now);

                for (int j = 1; j <= n; j++) {
                    if (graph[now][j] == 1) {
                        indegree[j]--;
                        if (indegree[j] == 0) q.offer(j);
                    }
                }
            }

            // 결과 출력
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else if (!certain) {
                System.out.println("?");
            } else {
                for (int num : result) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}
