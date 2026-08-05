class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        boolean[] list = new boolean[101];
        int max = 0;
        for(int num : nums) {
            list[num] = true;
            max = Math.max(num, max);
        }

        List<Integer> answer = new ArrayList<>();
        
        int idx = 1;

        while(!list[idx++]) {
        }

        for(int i = idx; i <= max; i++) {
            if(!list[i]) answer.add(i);
        }

        return answer;
    }
}