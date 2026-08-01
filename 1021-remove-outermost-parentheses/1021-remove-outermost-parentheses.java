class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if(c == '(') { 
                stack.push(c);
            }
            else {
                stack.pop();
                if(stack.isEmpty()) continue;
            }

            result.append(c);
        }

        return result.toString();
    }
}