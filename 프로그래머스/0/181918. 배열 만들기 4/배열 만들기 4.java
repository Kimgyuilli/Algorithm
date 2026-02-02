import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        
        for (int i : arr) {
            while (!stk.isEmpty() && stk.get(stk.size() - 1) >= i) {
                stk.remove(stk.size() - 1);
            }
            stk.add(i);
        }
        
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}