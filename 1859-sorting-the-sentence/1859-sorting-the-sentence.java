class Solution {
    public String sortSentence(String s) {
        String[] sp = s.split(" ");
        String[] answer = new String[sp.length];

        for(String sen : sp) {
            int len = sen.length();
            int idx = sen.charAt(len - 1) - '0' - 1;

            answer[idx] = sen.substring(0, len - 1);
        }

        return String.join(" ", answer);

    }
}