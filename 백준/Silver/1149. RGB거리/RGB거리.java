import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i][0] = Integer.parseInt(st.nextToken()); //r
            cost[i][1] = Integer.parseInt(st.nextToken()); //g
            cost[i][2] = Integer.parseInt(st.nextToken()); //b
        }

        for (int i = 1; i < N; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
        }
        System.out.println(Math.min(Math.min(cost[N - 1][0], cost[N - 1][1]), cost[N - 1][2]));
    }
}