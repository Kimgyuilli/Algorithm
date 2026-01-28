class Solution {
    public String solution(String my_string) {
        
        char[] list = my_string.toCharArray();
        
        for(int i = 0; i < list.length; i++){
            if(list[i] <= 'z' && list[i] >= 'a') list[i] = Character.toUpperCase(list[i]);
            else list[i] = Character.toLowerCase(list[i]);
        }
        
        return String.valueOf(list);
    }
}