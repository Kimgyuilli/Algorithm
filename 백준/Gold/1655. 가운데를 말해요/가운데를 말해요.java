import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if(maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if(minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            System.out.println(maxHeap.peek());
        }

    }
}