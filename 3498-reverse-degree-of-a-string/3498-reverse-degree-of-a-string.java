class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            int alp = s.charAt(i) - 'a';
            int rd = 26 - alp;

            sum += rd * (i + 1);
        }
        return sum;
    }
}