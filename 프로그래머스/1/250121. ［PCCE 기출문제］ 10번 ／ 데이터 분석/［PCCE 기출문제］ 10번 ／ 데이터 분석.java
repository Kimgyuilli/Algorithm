import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int idx_ext = getIndex(ext);
        
        List<int[]> filtered = new ArrayList<>();
        for(int[] d : data) {
            if(d[idx_ext] < val_ext) {
                filtered.add(d);
            }
        }
        
        int idx_sort = getIndex(sort_by);
        filtered.sort((a, b) -> a[idx_sort] - b[idx_sort]);
        
        int[][] answer = new int[filtered.size()][4];
        for(int i = 0; i < filtered.size(); i++) {
            answer[i] = filtered.get(i);
        }
        
        return answer;
    }
    
    private int getIndex(String field) {
        switch(field) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: return 0;
        }
    }
}