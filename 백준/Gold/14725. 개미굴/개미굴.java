import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Node {
    Map<String, Node> children = new TreeMap<>(); // 사전순 정렬
}

public class Main {
    static Node root = new Node();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String[] foods = new String[a];
            for (int i = 0; i < a; i++) {
                foods[i] = st.nextToken();
            }
            insert(foods);
        }
        print(root, 0);

    }

    static void insert(String[] foods) {
        Node curr = root;
        for (String food : foods) {
            curr = curr.children.computeIfAbsent(food, k -> new Node());
        }
    }

    static void print(Node node, int depth) {
        for (String key : node.children.keySet()) {
            System.out.println("--".repeat(depth) + key);
            print(node.children.get(key), depth + 1);
        }
    }

}
