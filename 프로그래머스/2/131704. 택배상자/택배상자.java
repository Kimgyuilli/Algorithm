import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> store = new ArrayDeque<>();
        int index = 0;

        for(int i = 1; i <= order.length; i++) {
            
            if(order[index] == i){
                index++;
                
                while(!store.isEmpty() && store.peek() == order[index]) {
                    index++;
                    store.pop();
                }
                
            } else {
                store.push(i);
            }
            
        }
        
        return index;
    }
}