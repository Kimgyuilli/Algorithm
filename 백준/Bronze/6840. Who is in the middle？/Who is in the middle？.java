import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.offer(Integer.parseInt(br.readLine()));
        pq.offer(Integer.parseInt(br.readLine()));
        pq.offer(Integer.parseInt(br.readLine()));
        
        pq.poll();
        System.out.println(pq.poll());
        
    }
}
