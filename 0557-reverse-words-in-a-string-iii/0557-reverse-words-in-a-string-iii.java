class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(String sen : split) {

            for(int i = sen.length() - 1; i >= 0; i--) {
                sb.append(sen.charAt(i));
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}