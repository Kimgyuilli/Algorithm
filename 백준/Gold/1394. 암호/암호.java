import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String code = br.readLine();
        int[] arr = new int[200];
        int result = 0;
        int size = str.length();

        for (int i = 0; i < str.length(); ++i) {
            int index = str.charAt(i) - '!';
            if (arr[index] == 0) {
                arr[index] = i + 1;
            }
        }

        for (int i = 0; i < code.length(); ++i) {
            int index = code.charAt(i) - '!';

            result *= size;
            result += arr[index];
            result %= 900528;
        }

        System.out.println(result);
        br.close();
    }
}