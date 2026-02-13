class Solution {
    public int[] solution(String s) {
        
        int index = 0;
        int deleted_zero = 0;
        
        while(!s.equals("1")){
            
            index++;
            
            int origin_length = s.length();
            
            s = s.replace("0", "");
            
            deleted_zero += origin_length - s.length();
            
            s = Integer.toBinaryString(s.length());
            
        }
        
        return new int[] {index, deleted_zero};
    }
}