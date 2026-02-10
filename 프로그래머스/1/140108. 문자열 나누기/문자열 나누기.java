class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int firstIdx = 0;
        int compareIdx = 0;
        char first = '.';
        
        for(int i = 0; i < s.length(); i++){
            if(firstIdx == 0){
                first = s.charAt(i);
                firstIdx++;
                continue;
            } 
            
            if(s.charAt(i) == first) firstIdx++;
            else compareIdx++;
            
            if(firstIdx == compareIdx){
                firstIdx = 0;
                compareIdx = 0;
                answer++;
            }    
        }
        
        return firstIdx == 0 ? answer : answer + 1;
    }
}