import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, max;
    static ArrayList<Node>[] nodes;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        nodes = new ArrayList[N+1];

        if (N == 1) {
            System.out.println(0);
            return;
        }


        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes[parent].add(new Node(child, cost));
            nodes[child].add(new Node(parent, cost));
        }
        visited = new boolean[N+1];
        dfs(1, 0);

        visited = new boolean[N+1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    private static void dfs(int node, int dist) {
        visited[node] = true;

        if(dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }
        for (Node next : nodes[node]) {
            if (!visited[next.link]) {
                dfs(next.link, dist + next.cost);
            }
        }
    }

    static class Node {
        int link;
        int cost;

        Node(int link, int cost) {
            this.link = link;
            this.cost = cost;
        }
    }
}