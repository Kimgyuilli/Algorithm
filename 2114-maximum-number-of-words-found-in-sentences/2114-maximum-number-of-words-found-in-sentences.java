class Solution {
    public int mostWordsFound(String[] sentences) {
        int answer = 0;

        for(String s : sentences) {
            answer = Math.max(s.split(" ").length, answer);
        }
        return answer;
    }
}