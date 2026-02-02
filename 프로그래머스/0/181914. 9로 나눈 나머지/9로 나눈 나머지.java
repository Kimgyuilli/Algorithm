class Solution {
    public int solution(String number) {
        
        char[] numbers = number.toCharArray(); 
        
        int answer = 0;
        
        for(char c : numbers){
            answer += c - '0';
        }
        
        return answer % 9;
    }
}