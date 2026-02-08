class Solution {
    public String solution(int n) {
        final String SUBAK = "수박";
        final String SU = "수";
        
        if(n % 2 == 0){
            return SUBAK.repeat(n/2);
        }
        
        return SUBAK.repeat(n/2) + SU;
    }
}