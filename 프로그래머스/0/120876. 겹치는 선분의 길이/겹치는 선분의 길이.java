class Solution {
    public int solution(int[][] lines) {
        int[] overlap = new int[201];
        
        for (int[] line : lines) {
            for (int i = line[0]; i < line[1]; i++) {
                overlap[i + 100]++;
            }
        }
        
        int result = 0;
        for (int count : overlap) {
            if (count >= 2) result++;
        }
        
        return result;
    }
}