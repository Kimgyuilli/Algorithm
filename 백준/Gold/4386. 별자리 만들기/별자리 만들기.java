import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Star {
    int number;
    double x, y;

    Star(int number, double x, double y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int s, e;
    double cost;

    Edge(int s, int e, double cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.cost, o.cost);
    }
}



public class Main {

    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Star[] stars = new Star[N];
        parent = new int[N + 1];

        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            stars[i] = new Star(i, a, b);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double cost = Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
                pq.offer(new Edge(stars[i].number, stars[j].number, cost));
            }
        }

        double totalCost = 0.0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                totalCost += edge.cost;
            }
        }

        System.out.printf("%.2f\n", totalCost);

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }

}
