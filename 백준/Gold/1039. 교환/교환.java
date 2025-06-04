import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, max = 0;
    static Set<String>[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new HashSet[K + 1];
        for (int i = 0; i <= K; i++) {
            visited[i] = new HashSet<>();
        }

        // 예외 처리: 두 자리 수지만 0과 교환하면 0으로 시작하게 되는 경우
        if (String.valueOf(N).length() == 1 || (String.valueOf(N).length() == 2 && String.valueOf(N).charAt(1) == '0')) {
            System.out.println(-1);
            return;
        }

        bfs();
        System.out.println(max == 0 ? -1 : max);
    }

    static void bfs(){
        Queue<State> q = new LinkedList<>();
        q.offer(new State(String.valueOf(N), 0));
        visited[0].add(String.valueOf(N));
        while (!q.isEmpty()) {
            State cur = q.poll();
            String num = cur.num;
            int count = cur.count;
            if(count == K) {
                max = Math.max(max, Integer.parseInt(num));
                continue;
            }
            int len = num.length();
            for (int i = 0; i < len -1; i++) {
                for(int j = i + 1; j < len; j++) {
                    String swapped = swap(num, i, j);
                    // 0으로 시작하면 skip
                    if (swapped.charAt(0) == '0') continue;
                    if (!visited[count + 1].contains(swapped)) {
                        visited[count + 1].add(swapped);
                        q.offer(new State(swapped, count + 1));
                    }
                }
            }

        }
    }

    static class State {
        String num;
        int count; // 교환 횟수
        State(String num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    static String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
        return sb.toString();
    }

}
