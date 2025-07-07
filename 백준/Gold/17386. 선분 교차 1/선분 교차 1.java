import java.io.*;
import java.util.*;

public class Main {
    static int[][] points = new int[4][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2; i++) {
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i < 4; i++) {
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        if (isProperIntersect(points[0], points[1], points[2], points[3])) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // 정확히 한 점에서 교차하는지 확인
    static boolean isProperIntersect(int[] a, int[] b, int[] c, int[] d) {
        int ab1 = ccw(a, b, c);
        int ab2 = ccw(a, b, d);
        int cd1 = ccw(c, d, a);
        int cd2 = ccw(c, d, b);

        return ab1 * ab2 < 0 && cd1 * cd2 < 0;
    }

    // CCW 알고리즘
    static int ccw(int[] p1, int[] p2, int[] p3) {
        long cross = (long)(p2[0] - p1[0]) * (p3[1] - p1[1]) - (long)(p2[1] - p1[1]) * (p3[0] - p1[0]);
        return Long.compare(cross, 0); // 1: 반시계, -1: 시계, 0: 일직선
    }
}