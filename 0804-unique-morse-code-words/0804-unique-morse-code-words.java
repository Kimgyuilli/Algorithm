class Solution {
    private final String[] MOS = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> mosSet = new HashSet<>();

        for(String word : words) {
            StringBuilder sb = new StringBuilder();

            for(char c : word.toCharArray()) {
                sb.append(MOS[c - 'a']);
            }

            mosSet.add(sb.toString());
        }

        return mosSet.size();
    }
}