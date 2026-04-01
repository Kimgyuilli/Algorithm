import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] subtraction = sc.nextLine().split("-");
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < subtraction.length; i++) {
            int tempSum = 0;
            
            String[] addition = subtraction[i].split("\\+");

            for (String num : addition) {
                tempSum += Integer.parseInt(num);
            }

            if (result == Integer.MAX_VALUE) {
                result = tempSum;
            } else {
                result -= tempSum;
            }
        }

        System.out.println(result);
    }
}