class Solution {
    private int[] map;
    private int[] dp;
    private int len;
    private int d;
    public int maxJumps(int[] arr, int d) {
        this.len = arr.length;
        this.dp = new int[len];
        this.map = arr;
        this.d = d;

        Arrays.fill(dp, -1);

        for(int i = 0; i < len; i++) {
            if(dp[i] > -1) continue;
            dfs(i);
        }
        
        int max = 0;
        for(int n : dp) {
            max = Math.max(n, max);
        }

        return max + 1;
    }

    private void dfs(int cur) {

        for(int i = cur - 1; i >= Math.max(0, cur - d); i--) {
            if(map[i] >= map[cur]) break;
            if(dp[i] == -1) dfs(i);

            dp[cur] = Math.max(dp[cur], dp[i] + 1);
        }
        
        for(int i = cur + 1; i < Math.min(len, cur + d + 1); i++) {
            if(map[i] >= map[cur]) break;
            if(dp[i] == -1) dfs(i);

            dp[cur] = Math.max(dp[cur], dp[i] + 1);
        }

        if(dp[cur] == -1) dp[cur] = 0;
    }
}