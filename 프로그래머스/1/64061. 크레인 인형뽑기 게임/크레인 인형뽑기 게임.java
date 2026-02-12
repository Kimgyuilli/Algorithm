import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        int[] indexs = new int[board.length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != 0){
                    indexs[i] = j;
                    break;
                }
            }
        }
            
            
        for(int move : moves){
            
            int col = move - 1;
            
            if(indexs[col] < board.length){
                int current = board[indexs[col]][col];
                indexs[col]++;
                if(!dq.isEmpty() && dq.peek() == current){
                    dq.pop();
                    answer+=2;
                } else{
                    dq.push(current);
                }
            }
        }
        
        return answer;
    }
}