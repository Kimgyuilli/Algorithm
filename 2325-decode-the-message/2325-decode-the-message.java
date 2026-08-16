class Solution {
    public String decodeMessage(String key, String message) {
        
        int[] hash = new int[26];
        int idx = 1;

        for(int i = 0; i < key.length(); i++) {
            int cur = key.charAt(i) - 'a';
            if(cur >= 26 || cur < 0 || hash[cur] > 0) continue;

            hash[cur] = idx++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < message.length(); i++) {
            char cur = message.charAt(i);
            if(cur >= 'a' && cur <= 'z') {
                cur = (char) (hash[cur - 'a'] - 1 + 'a');
            } 

            
            sb.append(cur);
        }
        return sb.toString();
    }
}