import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M;
        int[] list;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        Arrays.sort(list);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(list, Integer.parseInt(st.nextToken())));
        }

    }

    public static int binarySearch(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) {
                return 1;
            }
            else if (arr[mid] < key) {
                lo = mid + 1;
            }else if (arr[mid] > key) {
                hi = mid - 1;
            }
        }
        return 0;
    }

}