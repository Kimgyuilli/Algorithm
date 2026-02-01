class Solution {
    public int solution(int num, int k) {
        
        int answer = -1;
        int index = 0;
        
        while(num > 0){
            int temp = num % 10;
            num /= 10;
            if(temp == k){
                answer = index;
            }
            
            index++;
        }
        
        return answer == - 1 ? answer : index - answer;
    }
}