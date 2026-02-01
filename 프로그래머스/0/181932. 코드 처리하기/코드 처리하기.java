class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        
        for(int i = 0; i < code.length(); i++){
            char c = code.charAt(i);
            
            if(mode == 0){
                if(c == '1'){
                    mode = 1;
                    continue;
                }
                if(i % 2 == 0){
                    sb.append(c);
                }
            }
            else { 
                if(c == '1'){ 
                    mode = 0;
                    continue;
                }
                if(i % 2 == 1){
                    sb.append(c);
                }
            }
        }
        
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}