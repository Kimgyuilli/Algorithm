class Solution {

    List<List<Integer>> result;
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.graph = graph;
        this.result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(0, path);

        return result;
    }

    private void dfs(int node, List<Integer> path) {

        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[node]) {

            path.add(next);

            dfs(next, path);

            path.remove(path.size() - 1);
        }
    }
}