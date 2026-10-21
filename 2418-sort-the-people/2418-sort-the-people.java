class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        int len = names.length;
        
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        for(int h : heights) {
            map.put(h, i++);
        }

        Arrays.sort(heights);

        String[] answer = new String[len];

        for(int n = 0; n < len; n++) {
            answer[len - 1 - n] = names[map.get(heights[n])];
        }

        return answer;
    }
}