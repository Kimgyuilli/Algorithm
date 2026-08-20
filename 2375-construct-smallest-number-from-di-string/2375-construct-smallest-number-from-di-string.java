class Solution {
    public String smallestNumber(String pattern) {
        int len = pattern.length();
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= len; i++) {
            stack.push(i+1);

            if(i == len || pattern.charAt(i) == 'I') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        return sb.toString();

    }
}