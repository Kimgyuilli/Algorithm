import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dist[x][y] = Math.min(dist[x][y], end);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
}
            int minCycle = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (dist[i][j] != Integer.MAX_VALUE && dist[j][i] != Integer.MAX_VALUE) {
                    minCycle = Math.min(minCycle, dist[i][j] + dist[j][i]);
                }
            }
        }
            if (minCycle == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minCycle);
            }
        

    }

}
