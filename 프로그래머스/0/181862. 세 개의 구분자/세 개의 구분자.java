class Solution {
    public String[] solution(String myStr) {
        
        String[] answer = myStr.replace("a", " ")
            .replace("b", " ")
            .replace("c", " ")
            .trim()
            .split(" +");
        
        return answer[0].isEmpty() ? new String[] {"EMPTY"} : answer;
    }
}