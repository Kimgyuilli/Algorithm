import java.io.*;

public class Main {
    static final int MOD = 1_000_000_003;
    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 색의 개수
        int k = Integer.parseInt(br.readLine()); // 선택할 색 개수

        // 불가능한 경우: 인접하지 않게 k개 고를 수 없음
        if (k > n / 2) {
            System.out.println(0);
            return;
        }

        // 초기화
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // 아무것도 안 고르는 경우 1가지
            dp[i][1] = i; // i개 중 1개 고르는 경우 i가지
        }

        // DP 점화식
        // dp[i][j] = i개 중에서 서로 인접하지 않게 j개를 고르는 경우의 수
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }

        // 원형이므로 첫 번째 색을 고른 경우, 마지막은 못 고름
        // Case 1: 1번 안 고름 → dp[n-1][k]
        // Case 2: 1번 고름 → 마지막 색 못 고름 → dp[n-3][k-1]
        int answer = (dp[n - 1][k] + dp[n - 3][k - 1]) % MOD;

        System.out.println(answer);
    }
}
