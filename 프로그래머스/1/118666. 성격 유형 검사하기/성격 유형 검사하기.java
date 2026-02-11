import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<String, Integer> map = new HashMap<>();
        
        String[] personal_type = {"RT", "TR", "CF", "FC", "JM", "MJ", "AN", "NA"};
        
        for(String s : personal_type){
            map.put(s, 0);
        }
        
        for(int i = 0; i < survey.length; i++){
            int score = choices[i] - 4;
            map.put(survey[i], map.get(survey[i]) + score);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 8; i+=2){
            int typeA = map.get(personal_type[i]);
            int typeB = map.get(personal_type[i+1]);
            
            if(typeA > typeB){
                sb.append(personal_type[i].charAt(1));
            } else{
                sb.append(personal_type[i].charAt(0));
            }
        }
        
        return sb.toString();
    }
}