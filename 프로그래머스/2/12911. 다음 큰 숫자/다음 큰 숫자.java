class Solution {
    public int solution(int n) {
        // 1. 가장 오른쪽에 있는 '1' 비트 찾기 (LSB)
        int rightmostOne = n & -n;
        
        // 2. 가장 낮은 '01' 패턴을 '10'으로 변경 (올림 발생)
        int nextHigherOneBit = n + rightmostOne;
        
        // 3. 올림 발생 시 바뀐 비트들과 원래 비트들의 차이 계산
        int rightPart = n ^ nextHigherOneBit;
        
        // 4. 오른쪽 끝으로 1들을 몰아주기 위해 조정
        // (4로 나누는 이유는 step 2에서 발생한 두 개의 비트 차이를 보정하기 위함)
        rightPart = (rightPart / rightmostOne) >> 2;
        
        return nextHigherOneBit | rightPart;
    }
}