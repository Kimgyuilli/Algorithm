class Solution {
    public long maxTotalValue(int[] nums, int k) {

        if(nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int n : nums) {
            if(n < min) min = n;
            if(n > max) max = n;
        }
        return (long)(max - min) * k;
    }
}