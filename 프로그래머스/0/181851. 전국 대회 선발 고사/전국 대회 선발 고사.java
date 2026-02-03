import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<int[]> students = new ArrayList<>();
        
        for(int i = 0; i < rank.length; i++){
            if(attendance[i]){
                students.add(new int[]{i, rank[i]});
            }
        }
        
        students.sort((o1, o2) -> o1[1] - o2[1]);
        
        int a = students.get(0)[0];
        int b = students.get(1)[0];
        int c = students.get(2)[0];
        
        return 10000 * a + 100 * b + c;
    }
}