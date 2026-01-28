class Solution {
    public int solution(int a, int b) {
        int n = Integer.parseInt(a + "" + b);
        
        return Math.max(n, 2*a*b);
    }
}