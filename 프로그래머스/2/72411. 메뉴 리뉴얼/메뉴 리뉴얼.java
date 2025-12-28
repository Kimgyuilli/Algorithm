import java.util.*;

class Solution {
    private char[] currentOrder;
    private int targetLength;
    private Map<String, Integer> menuCount;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int courseLength : course) {
            this.menuCount = new HashMap<>();
            this.targetLength = courseLength;
            
            for (String order : orders) {
                this.currentOrder = order.toCharArray();
                Arrays.sort(this.currentOrder);
                
                combination(new StringBuilder(), 0);
            }
            
            int maxCount = menuCount.values().stream()
                .filter(count -> count >= 2)
                .max(Integer::compare)
                .orElse(0);
            
            if (maxCount >= 2) {
                menuCount.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxCount)
                    .forEach(entry -> answer.add(entry.getKey()));
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    private void combination(StringBuilder current, int start) {
        if (current.length() == targetLength) {
            String menu = current.toString();
            menuCount.merge(menu, 1, Integer::sum);
            return;
        }
        
        for (int i = start; i < currentOrder.length; i++) {
            current.append(currentOrder[i]);
            combination(current, i + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}