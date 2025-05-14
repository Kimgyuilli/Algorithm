import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static final long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        long[] factorial = new long[N+1];
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = (factorial[i-1] * i) % MOD;
        }
        long numerator = factorial[N];
        long denominator = (factorial[K] * factorial[N - K]) % MOD;
        long result = (numerator * modPow(denominator, MOD - 2, MOD)) % MOD;
        System.out.println(result);


    }
    static long modPow(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}