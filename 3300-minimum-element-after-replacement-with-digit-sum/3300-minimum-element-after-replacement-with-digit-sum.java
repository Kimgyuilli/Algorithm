class Solution {
    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            nums[i] = 0;
            while(n > 0) {
                nums[i] += n % 10;
                n /= 10;
            }
            min = Math.min(min, nums[i]);
        }

        return min;
    }
}