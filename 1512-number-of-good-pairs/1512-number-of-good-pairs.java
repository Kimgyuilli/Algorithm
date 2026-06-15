class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] store = new int[101];

        for(int num : nums) {
            store[num]++;
        }

        int result = 0;

        for(int n : store) {
            if(n == 0) continue;
            result += n * (n-1) / 2;
        }
        return result;
    }
}