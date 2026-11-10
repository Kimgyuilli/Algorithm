class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        arr[0] = nums[1];
        
        int firstIdx = 1;
        int secontIdx = 1;

        for(int i = 2; i < n; i++) {
            if(nums[firstIdx - 1] > arr[secontIdx - 1]) {
                nums[firstIdx++] = nums[i];
            } else {
                arr[secontIdx++] = nums[i];
            }
        }

        for(int i = firstIdx; i < n; i++) {
            nums[i] = arr[i - firstIdx];
        }

        return nums;
    }
}