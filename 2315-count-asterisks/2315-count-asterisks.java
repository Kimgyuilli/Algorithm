class Solution {
    public int countAsterisks(String s) {
        boolean canCount = true;

        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '*' && canCount) count++;
            else if(c == '|') canCount = !canCount;
        }
        return count;
    }
}