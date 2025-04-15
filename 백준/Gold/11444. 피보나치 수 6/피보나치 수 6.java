import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fib(n)[1][0]);
    }

    static long[][] fib(long n) {
        long[][] base = {{1, 1}, {1, 0}};
        return power(base, n);
    }

    static long[][] power(long[][] matrix, long n) {
        if (n == 1) return matrix;

        long[][] half = power(matrix, n / 2);
        long[][] result = multiply(half, half);

        if (n % 2 == 1) {
            result = multiply(result, new long[][]{{1, 1}, {1, 0}});
        }

        return result;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return result;
    }
}
