class Solution {
    public int solution(String my_string) {
        String[] s = my_string.split(" ");
        
        int answer = Integer.parseInt(s[0]);
        
        for(int i = 2; i < s.length; i += 2){
            int a = Integer.parseInt(s[i]);
            answer += s[i-1].equals("+") ?  a : -1 * a;
        }
        
        return answer;
    }
}