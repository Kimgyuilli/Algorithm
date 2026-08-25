class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);

            if (num == 2) {
                ans[i] = -1;
                continue;
            }

            int bit = 1;

            while ((num & bit) != 0) {
                bit <<= 1;
            }

            ans[i] = num ^ (bit >> 1);
        }

        return ans;
    }
}