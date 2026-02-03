import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);
        String target = String.join("", spell);
        
        for(String word : dic){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            
            if(target.equals(new String(chars))){
                return 1;
            }
        }
        
        return 2;
    }
}