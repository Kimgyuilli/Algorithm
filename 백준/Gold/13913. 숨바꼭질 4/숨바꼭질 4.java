import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        if (start == target) {
            System.out.println(0);
            System.out.println(start);
            return;
        }

        visited = new boolean[100001];
        prev = new int[100001];
        Arrays.fill(prev, -1);

        bfs(start, target);
    }

    static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000 || visited[next]) continue;

                visited[next] = true;
                prev[next] = now;
                q.add(next);

                if (next == target) {
                    printPath(target);
                    return;
                }
            }
        }
    }

    static void printPath(int now) {
        Stack<Integer> stack = new Stack<>();
        for (int i = now; i != -1; i = prev[i]) {
            stack.push(i);
        }
        System.out.println(stack.size() - 1);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
