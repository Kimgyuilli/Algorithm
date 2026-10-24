class Solution {
    public int prefixCount(String[] words, String pref) {
        int len = pref.length();
        int answer = 0;
        for(String word : words) {
            if(word.length() < len) continue;
            if(word.substring(0, len).equals(pref)) answer++;
        }

        return answer;
    }
}