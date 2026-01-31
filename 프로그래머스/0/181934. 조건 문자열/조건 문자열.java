class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        String op = ineq + eq;
        
        boolean result = switch(op) {
            case "<=" -> n <= m;
            case "<!" -> n < m;
            case ">=" -> n >= m;
            case ">!" -> n > m;
            default -> false;
        };
        
        return result ? 1 : 0;
    }
}