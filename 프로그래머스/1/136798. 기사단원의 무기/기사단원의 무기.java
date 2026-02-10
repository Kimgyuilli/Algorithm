class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            int n = 0;
            
            for(int j = 1; j*j <= i; j++){
                if(j*j == i){
                    n++;
                } else if(i % j == 0){
                    n += 2;
                }
            }
            
            answer += n > limit ? power : n;
            
        }
        
        return answer;
    }
}