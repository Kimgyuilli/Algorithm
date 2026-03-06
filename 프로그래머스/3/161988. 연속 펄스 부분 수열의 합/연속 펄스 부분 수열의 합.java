class Solution {
    public long solution(int[] sequence) {
        
        long answer = Long.MIN_VALUE;
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < sequence.length; i++) {
            
            long val1 = (long) sequence[i] * (i % 2 == 0 ? 1 : -1);
            long val2 = (long) sequence[i] * (i % 2 == 0 ? -1 : 1);
            
            sum1 += val1;
            if(sum1 < val1) sum1 = val1;
            
            sum2 += val2;
            if(sum2 < val2) sum2 = val2;
            
            answer = Math.max(answer, Math.max(sum1, sum2));
        }
        
        return  answer;
    }
}