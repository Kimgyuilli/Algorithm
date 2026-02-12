class Solution {
    public String solution(String new_id) {
        
        String fixed_id = new_id
            .toLowerCase()                          // 1단계: 소문자 변환
            .replaceAll("[^a-z0-9-_.]", "")        // 2단계: 허용 문자만 남김
            .replaceAll("\\.+", ".")               // 3단계: 연속된 점을 하나로
            .replaceAll("^\\.|\\.$", "")           // 4단계: 처음/끝 점 제거
            .replaceAll("^$", "a");                 // 5단계: 빈 배열 a로 치환
        
        if(fixed_id.length() > 15){
            fixed_id = fixed_id.substring(0, 15).replaceAll("\\.$", "");
        } else if(fixed_id.length() < 3){
            char lastChar = fixed_id.charAt(fixed_id.length() - 1);
            fixed_id += String.valueOf(lastChar).repeat(3 - fixed_id.length());
        }
        
        System.out.println(fixed_id);
        
        return fixed_id;
    }
}