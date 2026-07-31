class Solution {
    public int balancedStringSplit(String s) {
        int result = 0;
        int bal = 0;
        for(char c : s.toCharArray()) {
            if(c == 'R') bal++;
            else if(c == 'L') bal--;

            if(bal == 0) result++;
        }

        return result;
    }
}