import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        List<Integer> answer = new ArrayList<>();
        int nextIndex = 27;
        String w = "";
        
        for(char c : msg.toCharArray()){
            String wc = w + c;
            if(dict.containsKey(wc)){
                w = wc;
            } else{
                answer.add(dict.get(w)); 
                dict.put(wc, nextIndex++);
                w = String.valueOf(c);
            }
        }
        
        if (!w.isEmpty()) answer.add(dict.get(w));
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}