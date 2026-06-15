class Solution {
    public int alternatingSum(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) result += nums[i];
            else result -= nums[i];
        }

        return result;
    }
}