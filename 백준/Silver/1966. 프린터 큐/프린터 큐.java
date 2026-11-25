
import java.io.*;
import java.util.*;

public class Main {

    public static class Docs {
        int id;
        int priority;

        Docs(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int find = Integer.parseInt(st.nextToken());

            Queue<Docs> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.offer(new Docs(i, priority));
            }

            int count = 0;

            while (!q.isEmpty()) {

                Docs current = q.poll();

                boolean hasHigherPriority = false;

                for (Docs d : q) {
                    if (d.priority > current.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    q.offer(current);
                } else {
                    count++;

                    if (current.id == find) {
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
