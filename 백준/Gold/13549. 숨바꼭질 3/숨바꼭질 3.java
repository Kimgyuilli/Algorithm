import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] time = new int[100001];
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
        } else {
            bfs(N);
        }
    }
    public static void bfs(int start) {
        Deque<Integer> dq = new LinkedList<Integer>();
        dq.add(start);
        visited[start] = true;
        time[start] = 0;

        while(!dq.isEmpty()){
            int cur = dq.poll();

            int [] nexts = {cur * 2, cur - 1, cur + 1 };
            for(int i = 0; i < 3; i++){
                int next = nexts[i];

                if(next < 0 || next > 100000 || visited[next]) continue;

                visited[next] = true;

                if(i == 0){
                    dq.addFirst(next);
                    time[next] = time[cur];
                } else if(i == 1){
                    dq.addLast(next);
                    time[next] = time[cur] + 1;
                } else{
                    dq.addLast(next);
                    time[next] = time[cur] + 1;
                }

                if(next == K){
                    System.out.println(time[next]);
                    return;
                }
            }
        }
    }

}