class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.replace("+", "")
                                .split(" +");
        
        int xnum = 0;
        int num = 0;
        
        for(String s : arr){
            if(s.contains("x")){
                if(s.length() == 1) xnum++;
                else
                    xnum += Integer.parseInt(s.replaceAll("x", ""));
            } else{
                num += Integer.parseInt(s);
            }
        }
        
        if(xnum == 0) return num + "";
        if(xnum == 1){
            if(num == 0) return "x";   
            return "x + " + num;
        }
        if(num == 0) return xnum + "x";
        
        return xnum + "x + " + num;
    }
}