class Solution {
    private String s;
    private int[][] dp;
    public int minInsertions(String s) {
        this.s = s;
        int n = s.length();

        dp = new int[n][n];

        for(int[] li : dp) {
            Arrays.fill(li, -1);
        }

        return dfs(0, n-1);
    }

    private int dfs(int left, int right) {
        if(left >= right) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        if (s.charAt(left) == s.charAt(right)) return dp[left][right] = dfs(left + 1, right - 1);

        return dp[left][right] = 1 + Math.min(
            dfs(left + 1, right),
            dfs(left, right - 1)
        );
    }
}