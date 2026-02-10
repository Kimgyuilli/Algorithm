class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletWidth = Math.max(wallet[0], wallet[1]);
        int walletHeight = Math.min(wallet[0], wallet[1]);
        
        int max = Math.max(bill[0], bill[1]);
        int min = Math.min(bill[0], bill[1]);
        
        while(true){
                
            if(max <= walletWidth && min <= walletHeight) break;
            
            int temp = max / 2;
            max = Math.max(temp, min);
            min = Math.min(temp, min);
            
            
            answer++;
            
            
        }
        
        return answer;
    }
}