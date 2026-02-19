class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        String regular = "[^" + skill + "]";
        int answer = 0;
        
        for(String skill_tree : skill_trees){
            String compare = skill_tree.replaceAll(regular, "");
            if(skill.contains(compare) && skill.indexOf(compare) == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}