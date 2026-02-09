class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            // 1. 비트 OR 연산
            int combined = arr1[i] | arr2[i];
            
            // 2. 이진수 문자열로 변환
            String binary = Integer.toBinaryString(combined);
            
            // 3. n 자리로 패딩 (앞에 0 채우기)
            while(binary.length() < n) {
                binary = "0" + binary;
            }
            
            // 4. 1→#, 0→공백 변환
            answer[i] = binary.replace('1', '#').replace('0', ' ');
        }
        
        return answer;
    }
}