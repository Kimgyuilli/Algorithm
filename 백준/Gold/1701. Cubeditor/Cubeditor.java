import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int len = str.length();
        int res = 0;

        // 모든 접미 문자열에 대해 pi 배열 계산
        for (int i = 0; i < len; i++) {
            String subStr = str.substring(i, len);
            res = Math.max(res, KMP(subStr));
        }

        System.out.println(res);
    }

    static int KMP(String str) {
        int n = str.length();
        int[] pi = new int[n];
        int j = 0;
        int max = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j++;
                pi[i] = j;
                max = Math.max(max, pi[i]);
            }
        }

        return max;
    }
}
