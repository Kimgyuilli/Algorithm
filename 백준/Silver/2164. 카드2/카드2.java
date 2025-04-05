import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> q = new LinkedList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            if(q.size() == 1){
                System.out.println(q.poll());
            }else {
                q.pop();
                q.addLast(q.poll());
            }
        }

    }

}