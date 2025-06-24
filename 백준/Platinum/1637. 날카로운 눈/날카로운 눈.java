import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A, B, C;

    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];

        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());

            min = Math.min(min, A[i]);
            max = Math.max(max, C[i]);
        }

        max++;

        binarySearch();
    }

    static void binarySearch() {
        long left = min;
        long right = max;

        while (left < right) {
            long mid = (left + right) / 2;
            long sum = getSum(mid);

            if (sum % 2 == 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left == max) {
            System.out.println("NOTHING");
        } else {
            long count = getSum(left) - getSum(left - 1);
            System.out.println(left + " " + count);
        }
    }

    static long getSum(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (mid < A[i]) continue;
            long last = Math.min(mid, C[i]);
            sum += (last - A[i]) / B[i] + 1;
        }
        return sum;
    }

}
