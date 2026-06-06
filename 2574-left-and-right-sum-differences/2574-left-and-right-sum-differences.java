class Solution {
    public int[] leftRightDifference(int[] nums) {
        int len = nums.length;

        int[] leftsum = new int[len];
        int[] rightsum = new int[len];

        
        for (int i = 1; i < len; i++) {
            leftsum[i] = leftsum[i - 1] + nums[i - 1];
        }

        
        for (int i = len - 2; i >= 0; i--) {
            rightsum[i] = rightsum[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = Math.abs(leftsum[i] - rightsum[i]);
        }
        return nums;
    }
}