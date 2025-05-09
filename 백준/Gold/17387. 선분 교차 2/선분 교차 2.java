import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        long x1, y1, x2, y2, x3, y3, x4, y4;
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x3 = Long.parseLong(st.nextToken());
        y3 = Long.parseLong(st.nextToken());
        x4 = Long.parseLong(st.nextToken());
        y4 = Long.parseLong(st.nextToken());

        if (isIntersect(x1, y1, x2, y2, x3, y3, x4, y4)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static boolean isIntersect(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        int ab = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        int cd = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);

        if (ab == 0 && cd == 0) {
            if (Math.min(x1, x2) <= Math.max(x3, x4) &&
                    Math.min(x3, x4) <= Math.max(x1, x2) &&
                    Math.min(y1, y2) <= Math.max(y3, y4) &&
                    Math.min(y3, y4) <= Math.max(y1, y2)) {
                return true;
            }
            return false;
        }

        return ab <= 0 && cd <= 0;
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long val = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (val > 0) return 1;
        else if (val < 0) return -1;
        else return 0;
    }
}

