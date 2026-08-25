class Solution {
    public int maxDepth(String s) {
        int stack = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack++;
                max = Math.max(stack, max);
            }
            else if(c == ')') stack--;
        }

        return max;
    }
}