import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] s1, s2, sample;
    static boolean[][] visited;
    static Boolean[][] memo;

    static boolean dfs(int i, int j) {
        if (i + j == sample.length) return true;
        if (visited[i][j]) return memo[i][j];
        visited[i][j] = true;

        boolean res = false;
        if (i < s1.length && s1[i] == sample[i + j]) {
            res |= dfs(i + 1, j);
        }
        if (j < s2.length && s2[j] == sample[i + j]) {
            res |= dfs(i, j + 1);
        }

        return memo[i][j] = res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= n; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s1 = st.nextToken().toCharArray();
            s2 = st.nextToken().toCharArray();
            sample = st.nextToken().toCharArray();

            if (s1.length + s2.length != sample.length) {
                System.out.println("Data set " + testCase + ": no");
                continue;
            }

            visited = new boolean[s1.length + 1][s2.length + 1];
            memo = new Boolean[s1.length + 1][s2.length + 1];

            boolean result = dfs(0, 0);
            System.out.println("Data set " + testCase + ": " + (result ? "yes" : "no"));
        }
    }
}
