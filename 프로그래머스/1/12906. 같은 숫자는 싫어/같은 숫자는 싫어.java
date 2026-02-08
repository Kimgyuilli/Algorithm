import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        int pre = -1;
        
        for(int i : arr){
            if(i != pre) list.add(i);
            pre = i;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}