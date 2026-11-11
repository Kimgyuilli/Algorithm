class Solution {
    public int minSteps(String s, String t) {
        int[] alpS = new int[26];
        int[] alpT = new int[26];

        for(int i = 0; i < s.length(); i++) {
            alpS[s.charAt(i) - 'a']++;
            alpT[t.charAt(i) - 'a']++;
        }

        int diff = 0;
        for(int i = 0; i < 26; i++) {
            if(alpS[i] > alpT[i]) diff += alpS[i] - alpT[i];
        }

        return diff;
    }
}