import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder();
        
        char[] ch = a.toCharArray();
        
        for(char c : ch){
            if(c <= 'z' && c >= 'a'){
                sb.append(Character.toUpperCase(c));
            } else{
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println(sb.toString());
    }
}