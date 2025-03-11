import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N, x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x > 0) {
                q.add(x);
            } else{
                if (q.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(q.poll());
                }
            }
        }
        br.close();
    }
}
