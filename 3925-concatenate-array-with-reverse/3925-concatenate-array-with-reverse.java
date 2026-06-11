class Solution {
    public int[] concatWithReverse(int[] nums) {
        int len = nums.length;
        int[] result = new int[len * 2];

        for(int i = 0; i < len * 2; i++) {
            if(i < len) {
                result[i] = nums[i];
            } else {
                result[i] = nums[len * 2 - 1 - i];
            }
        }
        return result;
    }
}