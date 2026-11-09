class Solution {
    private int[] nums;
    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return answer;
    }

    private void dfs(int start) {
        answer.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i + 1);
            path.remove(path.size() - 1);
        }
    }
}