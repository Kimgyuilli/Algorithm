import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int dp[][];
    static int colorMap[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        colorMap = new int[N][3];
        dp = new int[N][3];



        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colorMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N][3];

            // 첫 번째 집 초기화
            for (int c = 0; c < 3; c++) {
                if (c == firstColor) dp[0][c] = colorMap[0][c];
                else dp[0][c] = 1000000; // 충분히 큰 값
            }

            // DP 수행
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + colorMap[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + colorMap[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + colorMap[i][2];
            }

            // 마지막 집의 색은 첫 색과 달라야 함
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == firstColor) continue;
                answer = Math.min(answer, dp[N-1][lastColor]);
            }
        }
        System.out.println(answer);

    }
}
