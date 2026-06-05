class Solution {
    public boolean checkIfPangram(String sentence) {
        
        if(sentence.length() < 26) return false;
        
        boolean[] sent = new boolean[26];

        for(int i = 0; i < sentence.length(); i++) {
            sent[sentence.charAt(i) - 'a'] = true;
        }

        for(boolean s : sent) {
            if(!s) return false;
        }
        return true;

    }
}