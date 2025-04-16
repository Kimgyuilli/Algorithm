import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int min = 0, max = N - 1;
        int left = 0, right = N - 1;
        int result = Integer.MAX_VALUE;
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (left < right) {
            int temp = arr[left] + arr[right];
            if(Math.abs(temp) < result) {
                result = Math.abs(temp);
                min = arr[left];
                max = arr[right];

            }
            if(temp > 0) {
                right--;
            } else if(temp < 0) {
                left++;
            } else {
                break;
            }
        }
        System.out.println(min + " " + max);
    }


}