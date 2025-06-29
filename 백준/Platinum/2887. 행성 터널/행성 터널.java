import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Planet {
    int number;
    int x, y, z;

    Planet(int number, int x, int y, int z) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edge implements Comparable<Edge> {
    int s, e;
    int cost;

    Edge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {

    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Planet[] planets = new Planet[N];
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }

        List<Edge> edges = new ArrayList<>();

        for (int dim = 0; dim < 3; dim++) {
            if (dim == 0) {
                Arrays.sort(planets, Comparator.comparingInt(p -> p.x));
            } else if (dim == 1) {
                Arrays.sort(planets, Comparator.comparingInt(p -> p.y));
            } else {
                Arrays.sort(planets, Comparator.comparingInt(p -> p.z));
            }

            for (int i = 0; i < N - 1; i++) {
                Planet a = planets[i];
                Planet b = planets[i + 1];
                int cost = Math.min(Math.min(Math.abs(a.x - b.x), Math.abs(a.y - b.y)), Math.abs(a.z - b.z));
                edges.add(new Edge(a.number, b.number, cost));
            }
        }

        Collections.sort(edges);

        int totalCost = 0;
        for (Edge edge : edges) {
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                totalCost += edge.cost;
            }
        }

        System.out.println(totalCost);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
