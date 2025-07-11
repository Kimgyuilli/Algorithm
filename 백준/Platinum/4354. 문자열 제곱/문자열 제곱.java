import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals(".")) {
            int len = line.length();
            int[] pi = makeTable(line);
            int repeatLen = len - pi[len - 1];

            if (len % repeatLen == 0) {
                sb.append(len / repeatLen).append("\n");
            } else {
                sb.append(1).append("\n");
            }
        }

        System.out.print(sb);
    }

    static int[] makeTable(String s) {
        int n = s.length();
        int[] pi = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}
