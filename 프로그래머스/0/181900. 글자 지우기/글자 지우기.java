class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        
        char[] answer = my_string.toCharArray();
        
        for(int i : indices){
            answer[i] = ' ';
        }
        
        return new String(answer).replace(" ", "");
    }
}