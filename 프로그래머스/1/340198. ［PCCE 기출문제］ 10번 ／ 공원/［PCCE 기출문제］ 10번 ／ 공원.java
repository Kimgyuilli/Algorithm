import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        // 내림차순 정렬
        Arrays.sort(mats);
        
        // 큰 것부터 확인
        for(int idx = mats.length - 1; idx >= 0; idx--){
            int m = mats[idx];
            for(int i = 0; i < park.length - m + 1; i++){
                for(int j = 0; j < park[0].length - m + 1; j++){
                    if(canPlace(park, i, j, m)) return m;
                }
            } 
        }
        
        return -1;
    }
    
    private boolean canPlace(String[][] park, int row, int col, int size){
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}