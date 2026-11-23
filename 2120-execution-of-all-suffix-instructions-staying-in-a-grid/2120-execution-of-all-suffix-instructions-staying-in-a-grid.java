class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length();
        int[] answer = new int[len];

        for(int i = 0; i < len; i++) {
            int cx = startPos[1];
            int cy = startPos[0];
            int count = 0;

            for(int j = i; j < len; j++) {
                char cmd = s.charAt(j);

                if(cmd == 'R') {
                    if(cx + 1 < n) {
                        cx++;
                        count++;
                    } else {
                        break;
                    }
                } else if(cmd == 'L') {
                    if(cx - 1 >= 0) {
                        cx--;
                        count++;
                    } else {
                        break;
                    }
                } else if(cmd == 'U') {
                    if(cy - 1 >= 0) {
                        cy--;
                        count++;
                    } else {
                        break;
                    }
                } else if(cmd == 'D') {
                    if(cy + 1 < n) {
                        cy++;
                        count++;
                    } else {
                        break;
                    }
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}