class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        if(num_list.length > 10){
            for(int i : num_list) answer += i;
        } else{
            answer = num_list[0];
            
            for(int i = 1; i < num_list.length; i++){
                answer *= num_list[i];
            }
        }
        
        
        return answer;
    }
}