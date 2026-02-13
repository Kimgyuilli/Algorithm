class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int bandage_stack = 0;
        int current_health = health;
        int attacks_idx = 0;
        int last_attack_time = attacks[attacks.length - 1][0];
        
        for(int i = 1; i <= last_attack_time; i++){
            
            if(attacks[attacks_idx][0] == i){
                current_health -= attacks[attacks_idx][1];
                attacks_idx++;
                
                if(current_health < 1){
                    return -1;
                }
                bandage_stack = 0;
                continue;
            }
            
            current_health += bandage[1];
            bandage_stack++;
            
            if(bandage_stack >= bandage[0]) {
                current_health += bandage[2];
                bandage_stack = 0;
            }
            
            if(current_health > health) current_health = health;
        }
        
        return current_health;
    }
}