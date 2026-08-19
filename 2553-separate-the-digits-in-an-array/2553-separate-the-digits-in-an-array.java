class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int num : nums) {
            sb.append(num);
        }

        String arr = sb.toString();

        int[] answer = new int[arr.length()];

        for(int i = 0; i < arr.length(); i++) {
            answer[i] = arr.charAt(i) - '0';
        }
        return answer;
    }
}