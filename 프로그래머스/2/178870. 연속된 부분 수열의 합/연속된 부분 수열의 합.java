class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0, end = 0;
        int sum = sequence[0];
        int ansStart = 0, ansEnd = sequence.length - 1;
        
        while(start <= end && end < sequence.length) {
            if(sum == k) {
                if(ansEnd - ansStart > end - start) {
                    ansStart = start;
                    ansEnd = end;
                }
                sum -= sequence[start++];
            } else if(sum < k) {
                end++;
                if(end < sequence.length) {
                    sum += sequence[end];
                }
            } else if(sum > k) {
                sum -= sequence[start++];
            }
        }
        
        return new int[] {ansStart, ansEnd};
    }
}