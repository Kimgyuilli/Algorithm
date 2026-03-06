import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            
            if(!map.containsKey(ticket[0])) {
                map.put(ticket[0], new ArrayList<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        
        for (List<String> dests : map.values()) {
            Collections.sort(dests);
        }
        
        result.add("ICN");
        dfs(map, "ICN", tickets.length);
        
        return result.toArray(String[]::new);
    }
    
    private boolean dfs(Map<String, List<String>> map, String current, int totalTickets) {
        if(result.size() == totalTickets + 1) {
            return true;
        }
        
        List<String> destinations = map.get(current);
        if (destinations == null || destinations.isEmpty()) return false;
        
        for (int i = 0; i < destinations.size(); i++) {
            String next = destinations.get(i);
            
            destinations.remove(i);
            result.add(next);
            
            if (dfs(map, next, totalTickets)) return true;
            
            result.remove(result.size() - 1);
            destinations.add(i, next);
        }
        return false;
    }
    
}