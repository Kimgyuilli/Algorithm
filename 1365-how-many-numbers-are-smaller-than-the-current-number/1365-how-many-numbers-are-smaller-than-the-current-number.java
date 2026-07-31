class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];

        for (int num : nums) {
            count[num]++;
        }

        int smallerCount = 0;

        for (int value = 0; value <= 100; value++) {
            int frequency = count[value];

            // count[value]를 value보다 작은 숫자의 개수로 변경
            count[value] = smallerCount;
            smallerCount += frequency;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = count[nums[i]];
        }

        return nums;
    }
}