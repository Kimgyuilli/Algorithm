import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] floor0 = new int[15];

        for(int i = 1; i < 15; i++) {
            floor0[i] = i;
        }

        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[] curFloor = floor0.clone();

            for(int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    curFloor[j] = curFloor[j - 1] + curFloor[j];
                }
            }
            System.out.println(curFloor[n]);
        }
    }
}