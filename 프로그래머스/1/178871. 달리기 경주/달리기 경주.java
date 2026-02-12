import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            int current = map.get(callings[i]);
            int front = map.get(players[current-1]);
            
            map.put(players[current], front);
            map.put(players[front], current);
            
            String temp = players[current];
            players[current] = players[front];
            players[front] = temp;
            
            
        }
        
        return players;
    }
}