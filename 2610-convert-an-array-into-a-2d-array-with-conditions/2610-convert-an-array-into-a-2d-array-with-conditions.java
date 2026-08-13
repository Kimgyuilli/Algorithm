class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();
        int len = nums.length;

        int[] count = new int[len + 1];
        int max = 0;

        for(int n : nums) {
            max = Math.max(++count[n], max);
        }

        for(int i = 0; i < max; i++) {
            answer.add(new ArrayList<>());
        }

        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < count[i]; j++) {
                answer.get(j).add(i);
            }
        }

        return answer;

    }
}