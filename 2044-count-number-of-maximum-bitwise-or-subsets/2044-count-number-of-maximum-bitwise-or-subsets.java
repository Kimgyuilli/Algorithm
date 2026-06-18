class Solution {
    private int maxOr;
    private int count;

    public int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        count = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        dfs(nums, 0, 0);

        return count;
    }

    private void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }

        dfs(nums, index + 1, currentOr | nums[index]);

        dfs(nums, index + 1, currentOr);
    }
}