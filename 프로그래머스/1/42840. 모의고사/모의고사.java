import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        final int[] STUDENT1 = {1, 2, 3, 4, 5};
        final int[] STUDENT2 = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] STUDENT3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        int max = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(STUDENT1[i % 5] == answers[i]){
                if(++score[0] > max) max = score[0];
            } 
            if(STUDENT2[i % 8] == answers[i]) {
                if(++score[1] > max) max = score[1];
            } 
            if(STUDENT3[i % 10] == answers[i]) {
                if(++score[2] > max) max = score[2];
            } 
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            if(score[i] == max){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}