class Solution {
    public int smallestIndex(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int total = 0;

            while(num > 0) {
                total += num % 10;
                num /= 10;
            }

            if(total == i) return i;
        }

        return -1;

    }
}