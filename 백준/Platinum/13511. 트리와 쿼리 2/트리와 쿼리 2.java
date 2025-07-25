import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static int n,h;
    static List<Node>[] list;
    static int[] depth;
    static long[] cost;
    static int[][] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
        list = new ArrayList[n+1];
        parents = new int[n+1][h];
        depth = new int[n+1];
        cost = new long[n+1];
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));
            list[v].add(new Node(u,w));

        }

        init(1,0,-1);
        fillParents();
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int lca = LCA(u,v);
            if(op == 1) {
                sb.append(cost[u] + cost[v] - 2*cost[lca] +"\n");
            }else {
                int k = Integer.parseInt(st.nextToken());
                sb.append(kNode(u, v, lca, k) +"\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int LCA(int x, int y) {
        if (depth[x] < depth[y]) {
            int temp = x; x = y; y = temp;
        }

        for (int i = h - 1; i >= 0; i--) {
            if ((1 << i) <= depth[x] - depth[y]) {
                x = parents[x][i];
            }
        }

        if (x == y) return x;

        for (int i = h - 1; i >= 0; i--) {
            if (parents[x][i] != 0 && parents[x][i] != parents[y][i]) {
                x = parents[x][i];
                y = parents[y][i];
            }
        }
        return parents[x][0];
    }

    static int kNode(int x, int y, int root, int k) {
        int dx = depth[x];
        int dy = depth[y];
        int leftLen = dx - depth[root] + 1;

        int tmp;
        if (k == leftLen) {
            return root;
        } else if (k < leftLen) {
            tmp = x; k--;
        } else {
            tmp = y;
            k = dx + dy - 2 * depth[root] - k + 1;
        }

        for (int i = h - 1; i >= 0; i--) {
            if ((k & (1 << i)) != 0) {
                tmp = parents[tmp][i];
            }
        }
        return tmp;
    }

    static void fillParents() {
        for (int i = 1; i < h; i++) {
            for (int j = 1; j <= n; j++) {
                if (parents[j][i - 1] != 0) {
                    parents[j][i] = parents[parents[j][i - 1]][i - 1];
                }
            }
        }
    }

    static void init(int cur, int d, int pa) {
        depth[cur] = d;
        for (Node nxt : list[cur]) {
            if (nxt.to != pa) {
                parents[nxt.to][0] = cur;
                cost[nxt.to] = cost[cur] + nxt.cost;
                init(nxt.to, d + 1, cur);
            }
        }
    }

}