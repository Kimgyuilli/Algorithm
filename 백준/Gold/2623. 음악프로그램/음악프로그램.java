import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가수 수
        M = Integer.parseInt(st.nextToken()); // 보조 PD 수

        graph = new ArrayList[N + 1];
        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int count = Integer.parseInt(input[0]);

            for (int j = 1; j < count; j++) {
                int a = Integer.parseInt(input[j]);
                int b = Integer.parseInt(input[j + 1]);

                graph[a].add(b);
                indegree[b]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }


        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int next : graph[now]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if (result.size() == N) {
            for (int x : result) {
                System.out.println(x);
            }
        } else {
            System.out.println(0);
        }

    }
}
