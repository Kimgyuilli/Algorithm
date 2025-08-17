import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        
        int[] count = new int[10];
        List<Integer> result = new ArrayList<>();
        
        
        for(int i = 0; i < X.length(); i++){
            count[X.charAt(i) - '0']++;
        }
        
        
        for(int i = 0; i < Y.length(); i++){
            int digit = Y.charAt(i) - '0';
            if(count[digit] > 0){
                count[digit]--;
                result.add(digit);
            }
        }
        
        result.sort(Collections.reverseOrder());
        
        if(result.isEmpty()) return "-1";
        
        if(result.get(0) == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int num : result) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}