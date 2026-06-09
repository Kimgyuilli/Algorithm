class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int leftidx = 0;
        int rightidx = 0;

        for(int n : nums) {
            if(n < pivot) {
                left[leftidx++] = n;
            } else if(n > pivot) {
                right[rightidx++] = n;
            }
        }

        for(int i = 0; i < leftidx; i++) {
            nums[i] = left[i];
        }
        for(int i = leftidx; i < len - rightidx; i++) {
            nums[i] = pivot;
        }
        for(int i = len - rightidx; i < len; i++) {
            nums[i] = right[i - (len - rightidx)];
        }

        return nums;
    }
}