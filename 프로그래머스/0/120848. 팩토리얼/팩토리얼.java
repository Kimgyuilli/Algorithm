class Solution {
    public int solution(int n) {
        int factorial = 1;
        
        for(int i = 1; i <= 10; i++){
            factorial *= i;
            if(factorial == n) return i;
            if(factorial > n) return i - 1;
        }
        
        return 10;
    }
}