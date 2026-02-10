class Solution {
    public String solution(String s, String skip, int index) {
        
        char[] ch = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : ch){
            int idx = 0;
            while(idx < index){
                c = (char)((c - 'a' + 1) % 26 + 'a');
                if(skip.indexOf(c) == -1) {
                    idx++;   
                }
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}