import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    static String[] numbers;      // 숫자들을 문자열로 저장
    static int[] modValue;        // 각 숫자를 K로 나눈 나머지
    static int[] length;          // 각 숫자의 길이
    static int[] pow10;           // pow10[i] = (10^i) % K
    static long[][] dp;           // dp[bitmask][mod] = 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 숫자 개수
        N = Integer.parseInt(br.readLine());

        numbers = new String[N];
        modValue = new int[N];
        length = new int[N];

        // 각 숫자 입력 및 길이 저장
        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
            length[i] = numbers[i].length();
        }

        // 나눌 수 K
        K = Integer.parseInt(br.readLine());

        // pow10[i] = (10^i) % K를 미리 계산
        pow10 = new int[51];  // 숫자 최대 길이가 50
        pow10[0] = 1;
        for (int i = 1; i < 51; i++) {
            pow10[i] = (pow10[i - 1] * 10) % K;
        }

        // 각 숫자를 정수로 보고 % K 한 값 미리 저장
        for (int i = 0; i < N; i++) {
            int val = 0;
            for (int j = 0; j < numbers[i].length(); j++) {
                val = (val * 10 + (numbers[i].charAt(j) - '0')) % K;
            }
            modValue[i] = val;
        }

        // DP 배열 초기화
        // dp[bitmask][mod] = bitmask 상태에서 mod 나머지를 만들 수 있는 경우의 수
        dp = new long[1 << N][K];
        dp[0][0] = 1; // 아무 숫자도 사용하지 않았고 나머지가 0인 상태는 1가지

        // 모든 상태에 대해 DP 전이 수행
        for (int bit = 0; bit < (1 << N); bit++) {
            for (int mod = 0; mod < K; mod++) {
                if (dp[bit][mod] == 0) continue;

                for (int i = 0; i < N; i++) {
                    // i번 숫자가 아직 사용되지 않았다면
                    if ((bit & (1 << i)) == 0) {
                        int nextBit = bit | (1 << i); // i번째 숫자를 새로 사용

                        // 새로운 숫자를 이어붙였을 때의 나머지 계산
                        // (현재 나머지 * 10^len + 숫자_i) % K
                        int nextMod = (mod * pow10[length[i]] + modValue[i]) % K;

                        // 새로운 상태의 경우의 수 누적
                        dp[nextBit][nextMod] += dp[bit][mod];
                    }
                }
            }
        }

        // 모든 숫자를 다 사용했고 (bitmask가 꽉 찬 상태), 나머지가 0인 경우의 수
        long numerator = dp[(1 << N) - 1][0];

        // 전체 순열 수는 N!
        long denominator = factorial(N);

        // 기약분수로 만들기 위해 GCD로 나눔
        long gcd = gcd(numerator, denominator);
        System.out.println((numerator / gcd) + "/" + (denominator / gcd));
    }

    // 팩토리얼 함수 (N!)
    static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    // 유클리드 호제법을 이용한 GCD 함수
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
