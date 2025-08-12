import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            
            
            if(used.contains(word) || 
               (i > 0 && words[i-1].charAt(words[i-1].length() - 1) != word.charAt(0))) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            
            used.add(word);
        }
        
        return new int[]{0, 0};
    }
}