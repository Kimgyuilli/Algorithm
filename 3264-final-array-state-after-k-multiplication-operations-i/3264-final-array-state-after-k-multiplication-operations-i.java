class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-- > 0) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] < min) {
                    min = nums[i];
                    idx = i;
                }
            }
            nums[idx] *= multiplier;
        }
        return nums;
    }
}