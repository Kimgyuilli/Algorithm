class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int index1 = 0;
        int index2 = 0;
        
        for(int i = 0; i < goal.length; i++){
                        
            if(goal[i].equals(cards1[index1])){
                index1 = (index1 + 1) % cards1.length;
                continue;
            } 
            
            if(goal[i].equals(cards2[index2])) {
                index2 = (index2 + 1) % cards2.length;
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}