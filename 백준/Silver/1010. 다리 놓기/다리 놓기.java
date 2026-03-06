import java.util.Scanner;

public class Main {
    static int[][] memo; // 이미 계산해본 상황을 저장하는 장부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            memo = new int[31][31];
            
            System.out.println(buildBridge(N, M));
        }
    }
    
    private static int buildBridge(int n, int m) {
        if (n == 0) return 1;

        if (n > m) return 0;

        if (memo[n][m] > 0) return memo[n][m];

        memo[n][m] = buildBridge(n - 1, m - 1) + buildBridge(n, m - 1);

        return memo[n][m];
    }
}
