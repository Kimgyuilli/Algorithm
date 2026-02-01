import java.util.Arrays;

class Solution {
    public String solution(String myString) {
        
        char[] list = myString.toCharArray();
        
        for(int i = 0; i < list.length; i++){
            if(list[i] < 'l'){
                list[i] = 'l';
            }
        }
        
        return new String(list);
            
    }
}