import java.util.Arrays;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] answer = new int[n];
        
        // 평균 점수 계산
        Integer[] indices = new Integer[n];
        for(int i = 0; i < n; i++){
            indices[i] = i;
        }
        
        // 인덱스를 평균 내림차순으로 정렬
        Arrays.sort(indices, (i, j) -> 
            (score[j][0] + score[j][1]) - (score[i][0] + score[i][1])
        );
        
        // 등수 매기기
        int rank = 1;
        for(int i = 0; i < n; i++){
            if(i > 0 && score[indices[i]][0] + score[indices[i]][1] 
                     == score[indices[i-1]][0] + score[indices[i-1]][1]){
                answer[indices[i]] = answer[indices[i-1]];
            } else {
                answer[indices[i]] = rank;
            }
            rank++;
        }
        
        return answer;
    }
}