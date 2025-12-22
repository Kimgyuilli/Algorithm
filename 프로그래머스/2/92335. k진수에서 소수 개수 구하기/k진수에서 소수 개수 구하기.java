class Solution {
    
    public int solution(int n, int k) {
        
        String nums = Integer.toString(n, k);
        String[] splitedNums = nums.split("0");
        
        int answer = 0;
        for(String num : splitedNums){
            
            if(num.equals("") || num.equals(" ")){
                continue;
            }
            
            long checkPrime = Long.parseLong(num);
            
            if(isPrime(checkPrime)){
                answer++;
            }
        }
        
        return answer;
    }
    
    // 소수 판별 함수 분리
    private boolean isPrime(long num) {
        if(num < 2) {
            return false;
        }
        if(num == 2) {
            return true;
        }
        if(num % 2 == 0) {
            return false;
        }
        
        for(long i = 3; i * i <= num; i += 2) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}