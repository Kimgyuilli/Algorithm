class Solution {
    private List<List<Integer>> answer;
    private int[] nums;
    private int len;
    public List<List<Integer>> permute(int[] nums) {
        this.len = nums.length;
        this.nums = nums;
        this.answer = new ArrayList<>();
        boolean[] visited = new boolean[len];
        List<Integer> list = new ArrayList<>();
        create(visited, list);

        return answer;
    }

    private void create(boolean[] visited, List<Integer> list) {
        if(list.size() == len) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < len; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            create(visited, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}