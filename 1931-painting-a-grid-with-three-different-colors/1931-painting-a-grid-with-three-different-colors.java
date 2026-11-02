class Solution {
    private final int MOD = 1_000_000_007;

    private List<int[]> states = new ArrayList<>();
    private int n, m, len;
    private int[][] dp;

    public int colorTheGrid(int m, int n) {
        this.m = m;
        this.n = n;

        makeStates(new int[m], 0);

        this.len = states.size();

        dp = new int[n][len];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int answer = 0;

        for (int color = 0; color < len; color++) {
            answer = (answer + dfs(1, color)) % MOD;
        }

        return answer;
    }

    private void makeStates(int[] state, int depth) {
        if (depth == m) {
            states.add(state.clone());
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (depth > 0 && state[depth - 1] == color) {
                continue;
            }

            state[depth] = color;
            makeStates(state, depth + 1);
        }
    }

    private int dfs(int col, int prev) {
        if (col == n) return 1;

        if (dp[col][prev] != -1) {
            return dp[col][prev];
        }

        int count = 0;

        for (int curr = 0; curr < len; curr++) {
            if (canConnect(states.get(prev), states.get(curr))) {
                count = (count + dfs(col + 1, curr)) % MOD;
            }
        }

        return dp[col][prev] = count;
    }

    private boolean canConnect(int[] prev, int[] curr) {
        for (int i = 0; i < m; i++) {
            if (prev[i] == curr[i]) {
                return false;
            }
        }

        return true;
    }
}