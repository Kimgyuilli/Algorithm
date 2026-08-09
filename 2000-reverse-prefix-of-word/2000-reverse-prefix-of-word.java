class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = -1;
        int len = word.length();
        while(++idx < len && ch != word.charAt(idx)) {
        }

        if(idx >= len) return word;

        StringBuilder sb = new StringBuilder(word.substring(0, idx + 1));

        return  sb.reverse().toString() + word.substring(idx + 1);
    }
}