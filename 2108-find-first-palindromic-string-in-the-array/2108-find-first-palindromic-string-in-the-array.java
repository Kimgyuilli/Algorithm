class Solution {
    public String firstPalindrome(String[] words) {
        for(String word : words) {
            if(!isPalindrom(word)) continue;;
            return word;
        }
        return "";
    }
    
    private boolean isPalindrom(String word) {
        int left = 0;
        int right = word.length() - 1;
        while(left <= right) {
            if(word.charAt(left++) != word.charAt(right--)) return false;
        }
        return true;
    }
}