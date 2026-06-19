class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = new boolean[26];

        for (char c : allowed.toCharArray()) {
            allow[c - 'a'] = true;
        }

        int result = 0;

        for (String word : words) {
            boolean isMatch = true;

            for (char c : word.toCharArray()) {
                if (!allow[c - 'a']) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) result++;
        }

        return result;
    }
}