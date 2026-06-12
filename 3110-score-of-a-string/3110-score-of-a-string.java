class Solution {
    public int scoreOfString(String s) {
        char[] ch = s.toCharArray();
        int result = 0;

        for(int i = 1; i < ch.length; i++) {
            result += Math.abs(ch[i - 1] - ch[i]);
        }
        return result;
    }
}