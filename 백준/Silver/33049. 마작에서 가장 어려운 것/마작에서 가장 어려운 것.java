import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 3의 배수로
        int m = Integer.parseInt(st.nextToken()); // 4의 배수로
        int k = Integer.parseInt(st.nextToken()); // 자유롭게 분배

        int minThreeGroup = Integer.MAX_VALUE;
        int answerThree = -1;
        int answerFour = -1;

        for (int x = 0; x <= k; x++) {
            int newN = n + x;
            int newM = m + (k - x);

            if (newN % 3 == 0 && newM % 4 == 0) {
                int group3 = newN / 3;
                int group4 = newM / 4;

                if (group3 < minThreeGroup) {
                    minThreeGroup = group3;
                    answerThree = group3;
                    answerFour = group4;
                }
            }
        }

        if (answerThree == -1) {
            System.out.println(-1);
        } else {
            System.out.println(answerThree + " " + answerFour);
        }
    }
}
