class Solution {
    public String[] solution(String[] quiz) {
        
        String[] answer = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++){
            String[] q = quiz[i].split(" ");
            
            int num1 = Integer.parseInt(q[0]);
            String op = q[1];
            int num2 = Integer.parseInt(q[2]);
            int result = Integer.parseInt(q[4]);
            
            if(op.equals("+")){
                answer[i] = num1 + num2 == result ? "O" : "X";
            } else if(op.equals("-")){
                answer[i] = num1 - num2 == result ? "O" : "X";
            }
            
        }
        
        
        
        return answer;
    }
}