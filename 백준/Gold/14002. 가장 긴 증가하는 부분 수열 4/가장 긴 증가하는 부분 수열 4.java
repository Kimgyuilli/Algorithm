import java.io.*;
import java.util.*;

public class Main {
    static int[] A, dpIndex, prev;
    static ArrayList<Integer> dp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        dpIndex = new int[N];
        prev = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 구축 + 추적 정보 저장
        ArrayList<Integer> lis = new ArrayList<>();
        int[] track = new int[N];

        for (int i = 0; i < N; i++) {
            int num = A[i];
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -pos - 1;

            if (pos == lis.size()) lis.add(num);
            else lis.set(pos, num);

            dpIndex[i] = pos;
            prev[i] = -1;
            if (pos > 0) {
                // 마지막 num보다 작고, pos-1 위치에 있던 인덱스를 찾아야 함
                for (int j = i - 1; j >= 0; j--) {
                    if (dpIndex[j] == pos - 1 && A[j] < num) {
                        prev[i] = j;
                        break;
                    }
                }
            }
        }

        // LIS 길이
        int len = lis.size();
        System.out.println(len);

        // LIS 복원
        Deque<Integer> result = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dpIndex[i] == len - 1) {
                int idx = i;
                while (idx != -1) {
                    result.addFirst(A[idx]);
                    idx = prev[idx];
                }
                break;
            }
        }

        for (int num : result) System.out.print(num + " ");
    }
}
