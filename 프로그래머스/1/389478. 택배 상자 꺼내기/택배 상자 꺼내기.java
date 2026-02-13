class Solution {
    public int solution(int n, int w, int num) {
        
        // 1. num의 층과 물리적 column 찾기
        int numLayer = (num - 1) / w + 1;
        int posInLayer = (num - 1) % w;  // 0-indexed
        
        // 홀수층은 왼쪽부터, 짝수층은 오른쪽부터
        int numColumn = (numLayer % 2 == 1) 
            ? posInLayer + 1        // 홀수층: col 1부터
            : w - posInLayer;       // 짝수층: col w부터
        
        // 2. 총 층수 계산
        int totalLayers = (n - 1) / w + 1;
        
        // 3. num 포함해서 카운트 시작
        int count = 1;
        
        // 4. num 위의 각 층에서 같은 column에 상자가 있는지 확인
        for (int layer = numLayer + 1; layer <= totalLayers; layer++) {
            int boxesInLayer = Math.min(w, n - (layer - 1) * w);
            
            // 해당 층에서 numColumn 위치의 상자가 존재하는지 확인
            int posInThisLayer;
            if (layer % 2 == 1) {
                // 홀수층: 왼쪽부터 채움
                posInThisLayer = numColumn - 1;  // 0-indexed
            } else {
                // 짝수층: 오른쪽부터 채움
                posInThisLayer = w - numColumn;  // 0-indexed
            }
            
            // 해당 위치에 상자가 있으면 카운트
            if (posInThisLayer >= 0 && posInThisLayer < boxesInLayer) {
                count++;
            }
        }
        
        return count;
    }
}