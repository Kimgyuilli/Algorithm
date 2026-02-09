class Solution {
    public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < food.length; i++){
            if(food[i] > 1){
                sb.append((i + "").repeat(food[i] / 2));
            }
        }
        
        
        return sb.toString() + "0" + sb.reverse().toString();
    }
}