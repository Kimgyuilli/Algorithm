class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = sort(k, rowConditions);
        int[] colOrder = sort(k, colConditions);

        if(rowOrder.length == 0 || colOrder.length == 0) return new int[0][0];

        int[] x = new int[k + 1];
        int[] y = new int[k + 1];
        for(int i = 0; i < k; i++) {
            y[rowOrder[i]] = i;
            x[colOrder[i]] = i;
        }

        int[][] answer = new int[k][k];

        for (int number = 1; number <= k; number++) {
            int row = y[number];
            int col = x[number];
            answer[row][col] = number;
        }
        return answer;

    }

    private int[] sort(int k, int[][] conditions) {
        List<Integer>[] graph = new ArrayList[k + 1];

        for(int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[k + 1];

        for(int[] condition : conditions) {
            int before = condition[0];
            int after = condition[1];

            indegree[after]++;
            graph[before].add(after);
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= k; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int[] order = new int[k];
        int index = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            order[index++] = cur;
            for(int next : graph[cur]) {
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }

        if(index != k) return new int[0];

        return order;
    }
}