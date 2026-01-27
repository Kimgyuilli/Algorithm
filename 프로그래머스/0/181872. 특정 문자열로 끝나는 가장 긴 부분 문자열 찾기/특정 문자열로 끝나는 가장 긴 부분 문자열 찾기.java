class Solution {
    public String solution(String myString, String pat) {
        
        int len = myString.length();
        for(int i = len; i >= 0; i--){
            String temp = myString.substring(0, i);
            if(temp.endsWith(pat)){
                return temp;
            }
        }
        
        
        return "";
    }
}