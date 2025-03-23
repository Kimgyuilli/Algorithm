import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] dp;
    static int[] weights, values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        K  = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];
        weights = new int[N];
        values = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(backpack(weights, values, K));

    }
    public static int backpack(int[] weights, int[] values, int W) {
        for (int i = 1; i <= N; i++) {
            int weight = weights[i-1];
            int value = values[i-1];
            for (int j = 0; j <= W; j++) {
                if(weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[N][K];
    }

}
