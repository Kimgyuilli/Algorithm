class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        
        char[] ch = my_string.toCharArray();
        char letterCh = letter.charAt(0);
        for(char c : ch){
            if(letterCh != c){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}