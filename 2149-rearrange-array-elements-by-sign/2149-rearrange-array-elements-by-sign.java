class Solution {
    public int[] rearrangeArray(int[] nums) {

        int len = nums.length;
        int[] answer = new int[len];

        int positiveIdx = 0;
        int nagativeIdx = 1;

        for(int i = 0; i < len; i++) {
            if(nums[i] > 0) {
                answer[positiveIdx] = nums[i];
                positiveIdx += 2;
            } else {
                answer[nagativeIdx] = nums[i];
                nagativeIdx += 2;
            }
        }

        return answer;
    }
}