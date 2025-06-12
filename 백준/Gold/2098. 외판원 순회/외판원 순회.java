import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n; // 도시 수
    static int INF = 1000000000;
    static int[][] dp;
    static int[][] W; // W[i][j] : 도시 i에서 j로 가는 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        W = new int[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n][1 << n];
        for (int i = 0; i < n ; i++)
            Arrays.fill(dp[i], -1); // 아직 방문 안한 상태
        System.out.println(dfs(0, 1));

    }

    static int dfs(int pre, int bit){

        if (bit == Math.pow(2, n) - 1) {
            // 모든 도시를 방문했을 때
            if (W[pre][0] != 0) return W[pre][0]; // 돌아갈 수 있으면 비용 리턴
            else return INF; // 돌아가지 못하면 불가능 리턴
        }
        if (dp[pre][bit] != -1) return dp[pre][bit]; // 이 전에 계산한 적이 있으면 그 값으로 리턴
        dp[pre][bit] = INF;
        for (int i = 0; i < n; i++){
            if ((bit & (1 << i)) == 0 && W[pre][i] != 0){
                // 아직 i번 도시 방문 안 했고, pre -> i 로 가는 길이 있는 경우
                dp[pre][bit] = Math.min(dp[pre][bit], dfs(i,  bit | (1 << i)) + W[pre][i]);
            }
        }
        return dp[pre][bit];
    }
}
