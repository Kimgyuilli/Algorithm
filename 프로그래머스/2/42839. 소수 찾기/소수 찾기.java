import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        findSet(numbers, "", visited);
        
        for(int n : set) {
            if(isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    private void findSet(String numbers, String current, boolean[] visited) {
        if(!current.isEmpty()) set.add(Integer.parseInt(current));
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                findSet(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }    
    
    private boolean isPrime(int num) {
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(int i = 3; i*i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
}