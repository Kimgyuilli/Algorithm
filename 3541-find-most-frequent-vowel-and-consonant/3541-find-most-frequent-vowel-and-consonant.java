class Solution {
    public int maxFreqSum(String s) {
        int[] frequency = new int[26];

        int mo = 0;
        int ja = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            frequency[idx]++;

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mo = Math.max(mo, frequency[idx]);
            } else {
                ja = Math.max(ja, frequency[idx]);
            }
        }
        return mo + ja;
    }
}