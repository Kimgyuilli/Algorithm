class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
            
        String s1 = ".".repeat(k);
        String s2 = "x".repeat(k);
        
        for(int i = 0; i < picture.length; i++){
            String s = picture[i].replace(".", s1)
                .replace("x", s2);
            
            for(int j = 0; j < k; j++){
                answer[i * k + j] = s;
            }    
        }
        return answer;
    }
}