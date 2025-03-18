import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  // 올바른 N 입력

        arr = new int[N][N];
        dp = new int[N][N];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {  // j <= i 로 수정
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];  // 초기값 설정

        // DP 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];  // 첫 번째 요소
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];  // 마지막 요소
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];  // 일반적인 경우
                }
            }
        }

        // 최댓값 찾기
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[N-1][i]);
        }

        System.out.println(max);
    }
}
