import java.io.*;
import java.util.*;
 
public class Main {
 
    static int N;
    static List<List<Integer>> graph;
    static int[][] capacity, flow;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        capacity = new int[2*N+1][2*N+1];
        flow = new int[2*N+1][2*N+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= 2*N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // i번째 점: 2*i-1, 2*i에 대응 
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int from = 2*Integer.parseInt(st.nextToken())-1;
            int to = 2*Integer.parseInt(st.nextToken())-1;
            graph.get(from).add(from+1);
            graph.get(from+1).add(from);
            graph.get(from+1).add(to);
            graph.get(to).add(from+1);
            graph.get(to).add(to+1);
            graph.get(to+1).add(to);
            graph.get(to+1).add(from);
            graph.get(from).add(to+1);
            capacity[from][from+1] = 1;
            capacity[from+1][to]++;
            capacity[to][to+1] = 1;
            capacity[to+1][from]++;
        }
        // 1, 2번 점은 두 번 이상 방문 
        System.out.println(maximumFlow(2, 3));
    }
 
    static int maximumFlow(int source, int sink) {
        int maxFlow = 0;
        while (true) {
            parent = new int[2*N+1];
            parent[source] = source;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(source);
            while (!queue.isEmpty() && parent[sink] == 0) {
                int cur = queue.poll();
                for (int nxt: graph.get(cur)) {
                    if (parent[nxt] == 0 && capacity[cur][nxt] - flow[cur][nxt] > 0) {
                        parent[nxt] = cur;
                        queue.offer(nxt);
                    }
                }
            }
            
            if (parent[sink] == 0) break;
            
            int tempFlow = Integer.MAX_VALUE;
            for (int cur = sink; cur != source; cur = parent[cur]) {
                tempFlow = Math.min(tempFlow, capacity[parent[cur]][cur] - flow[parent[cur]][cur]);
            }
            for (int cur = sink; cur != source; cur = parent[cur]) {
                flow[parent[cur]][cur] += tempFlow;
                flow[cur][parent[cur]] -= tempFlow;
            }
            maxFlow += tempFlow;
        }
        return maxFlow;
    }
}
