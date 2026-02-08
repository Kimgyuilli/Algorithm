class Solution {
    public int solution(int n) {
        String base3 = Integer.toString(n, 3);
        String reversed = new StringBuilder(base3).reverse().toString();
        return Integer.parseInt(reversed, 3);
    }
}