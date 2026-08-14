class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> {
            return b[k] - a[k];
        });

        return score;
    }
}