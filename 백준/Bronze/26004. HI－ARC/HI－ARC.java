import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        int[] find = new int[5];
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = input.charAt(i);
            if(arr[i] == 'H'){
                find[0]++;
            } else if(arr[i] == 'I'){
                find[1]++;
            } else if(arr[i] == 'A'){
                find[2]++;
            } else if(arr[i] == 'R'){
                find[3]++;
            } else if(arr[i] == 'C'){
                find[4]++;
            }
        }

        int min = Arrays.stream(find).min().getAsInt();
        System.out.println(min);

    }
}
