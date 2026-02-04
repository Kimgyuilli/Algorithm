class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        char[] list = my_string.toCharArray();
        
        for(char c : list){
            if(c >= 'a' && c <= 'z'){
                answer[c - 'a' + 26]++;
            } else if(c >= 'A' && c <= 'Z'){ 
                answer[c - 'A']++;
            }
        }
        
        return answer;
    }
}