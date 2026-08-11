class Solution {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for(int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }

        int[] result = new int[len];

        int idx = 0;
        for(int i = 0; i < nums.length; i += 2) {
            int repeat = nums[i];
            int n = nums[i+1];
            

            for(int j = 0; j < repeat; j++) {
                result[idx++] = n;
            }
        }

        return result;
    }
}
