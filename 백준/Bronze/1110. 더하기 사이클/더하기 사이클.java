import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int current = N;

        do {
            int tens = current % 10; 
            int sum = (current / 10 + tens) % 10; 
            current = tens * 10 + sum;
            answer++;
        } while (current != N);

        System.out.println(answer);
    }
}