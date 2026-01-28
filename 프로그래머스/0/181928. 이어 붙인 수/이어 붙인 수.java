class Solution {
    public int solution(int[] num_list) {
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(int i : num_list){
            if(i %2 != 0) sb2.append(i);
            else sb1.append(i);
        }
        
        return Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
    }
}