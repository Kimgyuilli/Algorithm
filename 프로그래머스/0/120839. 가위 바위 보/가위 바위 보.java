class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < rsp.length(); i++) {
            switch(rsp.charAt(i)) {
                case '2':  // 가위
                    sb.append("0");  // 바위로 이김
                    break;
                case '0':  // 바위
                    sb.append("5");  // 보로 이김
                    break;
                case '5':  // 보
                    sb.append("2");  // 가위로 이김
                    break;
            }
        }
        
        return sb.toString();
    }
}