import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] prefixSum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            M = Integer.parseInt(br.readLine());
            arr = new int[M];
            prefixSum = new int[M + 1]; // 누적합을 위한 배열
            dp = new int[M][M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                prefixSum[i + 1] = prefixSum[i] + arr[i];
            }

            // DP 로직
            for (int len = 2; len <= M; len++) { // 구간 길이
                for (int i = 0; i <= M - len; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i][k] + dp[k + 1][j] + prefixSum[j + 1] - prefixSum[i]);
                    }
                }
            }

            System.out.println(dp[0][M - 1]); // 전체 파일을 합치는 최소 비용
        }
    }
}
