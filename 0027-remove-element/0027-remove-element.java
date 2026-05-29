class Solution {
    public int removeElement(int[] nums, int val) {
        
        int[] replace = new int[100];

        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                replace[idx++] = nums[i];
            }
        }

        for(int i = 0; i < idx; i++) {
            nums[i] = replace[i];
        }

        return idx;
    }
}