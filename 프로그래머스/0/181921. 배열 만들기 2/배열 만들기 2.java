import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; ; i++) {
            String binary = Integer.toBinaryString(i);
            int num = Integer.parseInt(binary.replace('1', '5'));
            
            if (num > r) break;
            if (num >= l) result.add(num);
        }
        
        return result.isEmpty() ? new int[]{-1} : 
               result.stream().mapToInt(Integer::intValue).toArray();
    }
}