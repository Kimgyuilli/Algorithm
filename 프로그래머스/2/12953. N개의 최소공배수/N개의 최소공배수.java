class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            lcm = getLcm(lcm, arr[i]);
        }
        
        return lcm;
    }
    
    private int getLcm(int a, int b){
        int gcd = getGcd(a, b);
        
        return (a/gcd) * b;
    }
    
    private int getGcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    
    
}