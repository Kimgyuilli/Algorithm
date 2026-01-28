class Solution {
    public int solution(int a, int b) {
        
        int i1 = Integer.parseInt(a + "" + b);
        int i2 = Integer.parseInt(b + "" + a);
        
        return i1 < i2 ? i2 : i1;
    }
}