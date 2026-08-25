class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        double min = 50;

        while(left < right) {
            min = Math.min(min, ((double)nums[left++] + nums[right--]) / 2);
        };

        return min;
    }
}