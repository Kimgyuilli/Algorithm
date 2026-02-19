import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        
        String[][] regex_file = new String[files.length][3];
        
        for (int i = 0; i < files.length; i++) {
            
            regex_file[i][0] = files[i].split("[0-9]")[0];

            String rest = files[i].substring(regex_file[i][0].length());
            regex_file[i][1] = rest.split("[^0-9]")[0];

            regex_file[i][2] = files[i].substring(regex_file[i][0].length() + regex_file[i][1].length());
        }
        
        Arrays.sort(regex_file, (o1, o2) -> {
            int headCmp = o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
            if (headCmp != 0) return headCmp;
            return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
        });
        
        String[] answer = new String[files.length];
        
        for (int i = 0; i < files.length; i++) {
            answer[i] = regex_file[i][0] + regex_file[i][1] + regex_file[i][2];
        }
        
        return answer;
    }
}