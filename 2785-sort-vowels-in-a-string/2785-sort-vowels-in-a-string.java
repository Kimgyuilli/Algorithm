class Solution {
    private final char[] VOWELS = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
    public String sortVowels(String s) {
        int len = s.length();
        Map<Character, Integer> vowelMap = new HashMap<>();

        for(char v : VOWELS) {
            vowelMap.put(v, 0);
        }

        char[] answer = new char[len];

        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if(vowelMap.get(c) != null) vowelMap.put(c, vowelMap.get(c) + 1);
            else answer[i] = c;
        }

        int idx = 0;

        for(int i = 0; i < len; i++) {
            if(answer[i] > 0) continue;
            while(vowelMap.get(VOWELS[idx]) == 0) {
                idx++;
            }
            
            answer[i] = VOWELS[idx];
            vowelMap.put(VOWELS[idx], vowelMap.get(VOWELS[idx]) - 1);
        }

        return new String(answer);
    }
}