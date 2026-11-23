import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] notes = br.readLine().replace(" ", "").toCharArray();

        boolean positive = notes[0] < notes[1];

        for(int i = 2; i < 8; i++) {
            if((positive && notes[i - 1] > notes[i])
            || (!positive && notes[i - 1] < notes[i])) {
                System.out.println("mixed");
                return;
            }
        }

        System.out.println(positive ? "ascending" : "descending");
    }
}