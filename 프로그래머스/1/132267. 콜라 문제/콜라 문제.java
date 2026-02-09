class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            int returnBottle = (n / a) * a;
            int paybackBottle = (returnBottle / a) * b;
            n += paybackBottle - returnBottle;
            
            answer += paybackBottle;
        }
        
        return answer;
    }
}