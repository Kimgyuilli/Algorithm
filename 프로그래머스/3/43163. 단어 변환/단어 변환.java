import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            if(current.word.equals(target)){
                return current.depth;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && isConnected(words[i], current.word)){
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.depth + 1));
                }
            }
        }
        
        
        return 0;
    }
    
    private boolean isConnected(String word1, String word2){
        int missMatch = 0;
        
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)) missMatch += 1;
        }
        
        if(missMatch == 1){
            return true;
        }
            
        return false;
        
    }
    
    static class Node {
        String word;
        int depth;
        
        Node(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
}