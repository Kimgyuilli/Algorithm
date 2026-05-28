class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int common = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            int limit = Math.min(common, strs[i].length());
            while (j < limit && strs[0].charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            common = j;               
            if (common == 0) break; 
        }

        return strs[0].substring(0, common);
    }
}