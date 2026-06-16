class Solution {
    public int maxDistinct(String s) {
        boolean[] alp = new boolean[26];
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            if(alp[s.charAt(i) - 'a']) continue;

            alp[s.charAt(i) - 'a'] = true;
            result++;
        }
        return result;
    }
}