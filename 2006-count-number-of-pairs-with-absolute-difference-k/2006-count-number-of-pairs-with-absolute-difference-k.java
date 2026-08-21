class Solution {
    public int countKDifference(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                if(Math.abs(nums[i] - nums[j]) == k) count++;
            }
        }
        return count;
    }
}