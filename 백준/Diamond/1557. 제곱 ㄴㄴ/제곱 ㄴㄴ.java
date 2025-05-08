import java.io.*;

public class Main {
    static final int LIMIT = 500_000; // 루트 2e9보다 크면 충분
    static int[] mu = new int[LIMIT + 1];
    static boolean[] isPrime = new boolean[LIMIT + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());

        initMobius();

        long left = 1;
        long right = (long) 2e9;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (countSquareFree(mid) >= K) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static long countSquareFree(long x) {
        long res = 0;
        for (int i = 1; (long) i * i <= x; i++) {
            res += mu[i] * (x / ((long) i * i));
        }
        return res;
    }

    static void initMobius() {
        for (int i = 0; i <= LIMIT; i++) {
            mu[i] = 1;
            isPrime[i] = true;
        }

        mu[0] = 0;
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= LIMIT; i++) {
            if (!isPrime[i]) continue;
            for (int j = i; j <= LIMIT; j += i) {
                isPrime[j] = false;
                mu[j] *= -1;
            }
            long square = (long) i * i;
            if (square > LIMIT) continue;
            for (long j = square; j <= LIMIT; j += square) {
                mu[(int) j] = 0;
            }
        }
    }
}
