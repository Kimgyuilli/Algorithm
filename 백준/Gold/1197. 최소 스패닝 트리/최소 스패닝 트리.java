import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, total;
    static ArrayList<Node> [] graph;
    static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        prim(1);

        System.out.println(total);

    }
static void prim(int start){
    Queue<Node> pq = new PriorityQueue<>();

    pq.add(new Node(start, 0));
    while(!pq.isEmpty()){
        Node p = pq.poll();
        int node = p.to;
        int value = p.value;

        if(visited[node]) continue;
        visited[node] = true;
        total += value;

        for(Node next : graph[node]){
            if(!visited[next.to]){
                pq.add(next);
            }
        }
    }
}

}

class Node implements Comparable<Node>{
    int to;
    int value;

    public Node(int to, int value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
