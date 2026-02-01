class Solution {
    public int solution(int a, int b) {
        if(a % 2 == 0 && b % 2 == 0){
            return a > b ? a - b : b - a;
        }
        if(a % 2 == 1 && b % 2 == 1){
            return a*a + b*b;
        }
        return 2 * (a+b);
    }
}