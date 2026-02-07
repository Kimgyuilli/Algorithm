import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(flag[i]){
                for(int j = 0; j < arr[i]; j++){
                    list.add(arr[i]);
                    list.add(arr[i]);
                }
            } else {
                for(int j = 0; j < arr[i]; j++){
                    if(!list.isEmpty()){
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}