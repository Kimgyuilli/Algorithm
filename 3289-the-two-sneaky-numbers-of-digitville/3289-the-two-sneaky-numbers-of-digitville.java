class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] result = new int[2];
        boolean[] isSneaky = new boolean[101];

        int idx = 0;

        for(int num : nums) {
            if(!isSneaky[num]) isSneaky[num] = true;
            else {
                result[idx++] = num;
                if(idx > 1) break;
            }
        }

        return result;
    }
}