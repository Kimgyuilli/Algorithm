import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count;
    static int[] arr;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            M = Integer.parseInt(br.readLine());

            arr = new int[M + 1];
            visited = new boolean[M + 1];
            finished = new boolean[M + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= M; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(M - count);
        }
    }

    static void dfs(int curr) {
        visited[curr] = true;
        int next = arr[curr];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int i = next; i != curr; i = arr[i]) {
                count++;
            }
            count++;
        }

        finished[curr] = true;
    }
}
