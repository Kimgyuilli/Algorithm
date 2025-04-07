import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        int cnt = 0;
        while (q.size() > 1) {
            int data = q.poll();
            cnt++;
            if (cnt%K == 0) {
                sb.append(data).append(", ");
            } else q.add(data);
        }

        sb.append(q.poll()).append(">");
        System.out.println(sb);


    }

}

