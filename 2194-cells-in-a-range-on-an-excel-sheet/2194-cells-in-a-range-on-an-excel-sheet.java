class Solution {
    public List<String> cellsInRange(String s) {
        char startCol = s.charAt(0);
        int startRow = s.charAt(1) - '0';
        char endCol = s.charAt(3);
        int endRow = s.charAt(4) - '0';

        List<String> answer = new ArrayList<>();
        for(char c = startCol; c <= endCol; c++) {
            for(int i = startRow; i <= endRow; i++) {
                answer.add(c + "" + i);
            }
        }
        return answer;
    }
}