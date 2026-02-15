import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] clothe : clothes){
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1);
        }
        
        int count = 1;
        
        for(int i : map.values()){
            count *= i;
        }
        
        return count - 1;
    }
}