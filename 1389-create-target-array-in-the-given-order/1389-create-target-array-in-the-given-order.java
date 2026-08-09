class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> li = new ArrayList<>();

        int len = nums.length;

        for(int i = 0; i < len; i++) {
            int val = nums[i];
            int idx = index[i];

            li.add(idx, val);
        }

        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            result[i] = li.get(i);
        }
        return result;
    }
}