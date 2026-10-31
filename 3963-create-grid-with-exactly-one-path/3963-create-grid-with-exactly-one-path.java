class Solution {
    public String[] createGrid(int m, int n) {
        String[] answer = new String[m];

        answer[0] = ".".repeat(n);
        for(int i = 1; i < m; i++) {
            answer[i] = "#".repeat(n-1) + ".";
        }
        return answer;
    }
}