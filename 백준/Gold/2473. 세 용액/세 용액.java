import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class Main {
    static int N;
    static long[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        sort(arr);

        long minSum = Long.MAX_VALUE;
        int first = 0, second = 1, third = 2;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    first = i;
                    second = left;
                    third = right;
                }

                if (sum == 0) {
                    System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                    return;
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(arr[first] + " " + arr[second] + " " + arr[third]);
    }
}
