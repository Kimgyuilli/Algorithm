import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        dfs(0, n, len, sb, 1);
    }

    private static void dfs(int depth, int n, int end, StringBuilder sb, int cur) {
        if(depth == end) {
            System.out.println(sb.toString());
            return;
        }

        for(int i = cur; i <= n; i++) {
            sb.append(i).append(" ");
            dfs(depth + 1, n, end, sb, i);
            sb.delete(sb.length() - 2, sb.length());
        }
    }
}