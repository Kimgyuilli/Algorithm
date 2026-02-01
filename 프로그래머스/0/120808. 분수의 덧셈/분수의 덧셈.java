class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int num = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        
        int div = 1;
        
        for(int i = Math.min(num, denom); i > 0; i--){
            if(num % i == 0 && denom % i == 0){
                div = i;
                break;
            }
        }
        
        return new int[] {num/div, denom/div};
    }
}