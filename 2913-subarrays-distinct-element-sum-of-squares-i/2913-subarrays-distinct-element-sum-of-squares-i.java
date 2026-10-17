class Solution {
    public int sumCounts(List<Integer> nums) {
        
        int answer = 0;
        int len = nums.size();

        for(int start = 0; start < len; start++) {
            Set<Integer> seen = new HashSet<>();

            for(int end = start; end < len; end++) {
                seen.add(nums.get(end));
                int dist = seen.size();
                answer += dist * dist;
            }

        }
        return answer;

    }
}