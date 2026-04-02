import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long[] list = new long[100];
        int[] init = {1, 1, 1, 2, 2, 3, 4, 5, 7};

        for(int i = 0; i < 100; i++) {
            if(i < init.length) {
                list[i] = init[i];
                continue;
            }
            list[i] = list[i - 1]  + list[i - 5];
        }

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(list[N - 1]);
        }
    }
}