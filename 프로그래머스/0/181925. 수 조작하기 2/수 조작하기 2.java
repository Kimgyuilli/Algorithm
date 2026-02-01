class Solution {
    public String solution(int[] numLog) {
        
        int preNum = numLog[0];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < numLog.length; i++){
            switch (numLog[i] - preNum){
                case 1:
                    sb.append('w');
                    break;
                case -1:
                    sb.append('s');
                    break;
                case 10:
                    sb.append('d');
                    break;
                case -10:
                    sb.append('a');
                    break;
            }
            preNum = numLog[i];
        }
        return sb.toString();
    }
}