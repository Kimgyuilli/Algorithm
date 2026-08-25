class Solution {
    private int[] p;
    public int[] processQueries(int[] queries, int m) {
        this.p = new int[m];

        for(int i = 1; i <= m; i++) {
            p[i - 1] = i;
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int query = queries[q];
            int idx = 0;

            while (p[idx] != query) {
                idx++;
            }
            answer[q] = idx;

            int change = Math.max(0, idx - query);
            for (int i = idx; i > 0; i--) {
                p[i] = p[i - 1];
            }

            p[0] = query;
        }

        return answer;
    }
}