
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, N, K, object;
    static int[] timetable, dp, indegree;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            timetable = new int[N+1];
            dp = new int[N+1];
            list = new ArrayList[N+1];
            indegree = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                timetable[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                indegree[end]++;
                list[start].add(new Node(start, end));
            }

            object = Integer.parseInt(br.readLine());

            solve(object);

            System.out.println(dp[object]);


        }
    }

    private static void solve(int object) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i] = timetable[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node node : list[cur]) {
                int next = node.end;
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[cur] + timetable[next]);
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }

    static class Node{
        int start;
        int end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
}


