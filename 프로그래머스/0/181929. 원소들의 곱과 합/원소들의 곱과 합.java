class Solution {
    public int solution(int[] num_list) {
        
        int cal = 1;
        int sum = 0;
        
        for(int i : num_list){
            cal *= i;
            sum += i;
        }
        
        return sum * sum > cal ? 1 : 0;
    }
}