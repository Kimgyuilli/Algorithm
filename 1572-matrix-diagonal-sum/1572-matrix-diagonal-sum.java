class Solution {
    public int diagonalSum(int[][] mat) {
        
        int len = mat.length;

        int left = 0;
        int right = len - 1;

        int total = 0;

        for(int[] m : mat) {

            if(left == right) {
                total -= m[left];
            }

            total += m[left++] + m[right--];
        }
        return total;
    }
}