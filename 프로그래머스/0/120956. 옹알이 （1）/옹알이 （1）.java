class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String word : babbling){
            String temp = word.replace("aya", " ")
                    .replace("ye", " ")
                    .replace("woo", " ")
                    .replace("ma", " ");
            
            if(temp.trim().isEmpty()){
                answer++;
            }   
        }
        return answer;
    }
}