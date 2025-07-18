import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int LOG = 60;
    static int N, Q;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][LOG];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            dp[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= N; i++) {
                dp[i][j] = dp[dp[i][j - 1]][j - 1]; // f^(2^j)(i) = f^(2^(j-1))(f^(2^(j-1))(i))
            }
        }

        Q = Integer.parseInt(br.readLine());
        for( int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int j = 0; j < LOG; j++) {
                if((n & (1L << j)) != 0) {
                    x = dp[x][j]; // f^(2^j)(x)
                }
            }
            sb.append(x).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}