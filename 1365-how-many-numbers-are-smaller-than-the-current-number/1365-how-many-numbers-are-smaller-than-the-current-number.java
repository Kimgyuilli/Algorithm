class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] accumulate = new int[101];

        for(int n : nums) {
            count[n]++;
        }

        for(int i = 1; i < 101; i++) {
            accumulate[i] = count[i-1] + accumulate[i-1];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = accumulate[nums[i]];
        }
        return nums;
    }
}