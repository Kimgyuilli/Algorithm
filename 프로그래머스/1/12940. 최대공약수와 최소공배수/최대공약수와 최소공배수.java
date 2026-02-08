class Solution {
    public int[] solution(int n, int m) {
        
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        
        return new int[] {commonDivisor(min, max), commonMultiple(min, max)};
    }
    
    private int commonDivisor(int n, int m){
        for(int i = n; i > 0; i--){
            if(n % i == 0 && m % i == 0) return i;
        }
        return 0;
    }
    
    private int commonMultiple(int n, int m){
        for(int i = m; i <= n * m; i++){
            if(i % n == 0 && i % m == 0) return i;
        }
        
        return 0;
    }
    
}